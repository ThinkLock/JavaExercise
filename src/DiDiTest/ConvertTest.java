package DiDiTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/**
 * Created by fengzhaoyang_i on 2017/4/19.
 */
public class ConvertTest {

    public static void main(String[] args){

        boolean isInfoType = true;
        boolean isLastRemaining = false;

        byte mInfoType = 0;
        int offset = 0;

        try {
            FileInputStream fis = new FileInputStream("trace_sensor_bin.txt");
            FileChannel fc = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            int r = fc.read(buffer);
            buffer.flip();
            byte[] data;
            byte[] cache = new byte[68];
            while (r!=-1){

                //持续读取缓冲区内容
                while (buffer.hasRemaining()) {
                    if(isInfoType) {
                        //当前byte是infotype标志位
                        mInfoType = buffer.get();
                        isInfoType = false;
                    }else {
                        //读取当前infotype标志下的数据信息
                        int length = getNextReadSize(mInfoType);
                        data = new byte[length];
                        if(isLastRemaining){
                            //上次buffer有剩余未构建的数据
                            for(int i=0;i<offset;i++){
                                //加载上次buffer剩余数据
                                data[i] = cache[i];
                            }
                            //获取一个sensordata剩余所需要的字节
                            buffer.get(data,offset,length-offset);
                            offset = 0;
                            isInfoType = true;
                            isLastRemaining = false;
                            System.out.print(convertDataToString(mInfoType,data,data.length)+"\n");
                            //writeToFile(convertDataToString(mInfoType,data,data.length),"convertbin2str_result.txt");
                        }else {
                            //上次buffer中的数据已经全部构建完成
                            if (buffer.remaining() >= length) {
                                //当前buffer中的剩余数据足够构建一个sensordata
                                buffer.get(data);
                                isInfoType = true;
                                isLastRemaining = false;
                                System.out.print(convertDataToString(mInfoType,data,data.length)+"\n");
                                //writeToFile(convertDataToString(mInfoType,data,data.length),"convertbin2str_result.txt");
                            } else {
                                //当前buffer中的数据不够一个sensordata的长度
                                offset = buffer.remaining();    //记录剩余的字节长度
                                //将剩余字节放入一个临时byte数组
                                buffer.get(cache, 0, buffer.remaining());
                                isInfoType = false;
                                isLastRemaining = true;
                            }
                        }
                    }
                }
                buffer.clear();
                r = fc.read(buffer);
                buffer.flip();
            }
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /**
     * 转换字节数组中的数据为sensordata字符串格式
     * @param inforType 传感器信息容量描述
     * @param data 传感器信息字节数据
     * @param length 传感器信息字节数据长度
     * @return 传感器数据字符串
     */
    public static String convertDataToString(byte inforType,byte[] data,int length){
        if(data.length==0){
            return "error";
        }

        ByteBuffer buf = ByteBuffer.allocate(length);
        buf.put(data);
        buf.flip();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        boolean hasGPSInfo = false;
        boolean hasTSInfo = false;
        boolean hasOtherSensorInfo = false;
        switch (length){
            case 20:
                hasGPSInfo = false;
                hasOtherSensorInfo = false;
                hasTSInfo = false;
                break;
            case 44:
                hasGPSInfo = false;
                hasOtherSensorInfo = true;
                hasTSInfo = false;
                break;
            case 52:
                hasGPSInfo = false;
                hasOtherSensorInfo = true;
                hasTSInfo = true;
                break;
            case 68:
                hasGPSInfo = true;
                hasOtherSensorInfo = true;
                hasTSInfo = true;
                break;
        }
        SensorData sensordata = new SensorData();
        sensordata.setInfo_type(inforType);
        if(hasTSInfo){
            sensordata.setTimestamp(buf.getLong());
        }

        //构建加速度计数据
        SensorData.Accelerometer acceleration = new SensorData.Accelerometer();
        acceleration.setX_axis(buf.getShort());
        acceleration.setY_axis(buf.getShort());
        acceleration.setZ_axis(buf.getShort());

        //构建角速度计数据
        SensorData.Gyroscope gyroscepe = new SensorData.Gyroscope();
        gyroscepe.setX_axis(buf.getShort());
        gyroscepe.setY_axis(buf.getShort());
        gyroscepe.setZ_axis(buf.getShort());

        sensordata.setGyro_dt(buf.getShort());

        //构建磁力计数据
        SensorData.Magnetic magnetic = new SensorData.Magnetic();
        magnetic.setX_axis(buf.getShort());
        magnetic.setY_axis(buf.getShort());
        magnetic.setZ_axis(buf.getShort());

        sensordata.setAcceleration(acceleration);
        sensordata.setGyroscope(gyroscepe);
        sensordata.setMagnetic(magnetic);

        if(hasOtherSensorInfo){
            sensordata.setPressure(buf.getFloat());
            sensordata.setLight(buf.getFloat());
            sensordata.setTemperature(buf.getShort());
            sensordata.setDistance(buf.getShort());

            //构建重力计数据
            SensorData.Gravity gravity = new SensorData.Gravity();
            gravity.setX_axis(buf.getShort());
            gravity.setY_axis(buf.getShort());
            gravity.setZ_axis(buf.getShort());

            //构建旋转向量数据
            SensorData.RotationVector rotationVector = new SensorData.RotationVector();
            rotationVector.setX_axis(buf.getShort());
            rotationVector.setY_axis(buf.getShort());
            rotationVector.setZ_axis(buf.getShort());

            sensordata.setGravity(gravity);
            sensordata.setRotation_vector(rotationVector);
        }


        if(hasGPSInfo){
            //构建GPS信息
            GPSData gpsdata = new GPSData();
            gpsdata.setLon(buf.getFloat());
            gpsdata.setLat(buf.getFloat());
            gpsdata.setAltitude(buf.getFloat());
            gpsdata.setAccuracy(buf.get());
            gpsdata.setSpeed(buf.get());
            gpsdata.setSate_num(buf.get());
            gpsdata.setUse_in_fixs(buf.get());

            sensordata.setGps(gpsdata);
        }


        sensordata.setEnableOthersSensor(hasOtherSensorInfo);
        sensordata.setEnableTS(hasTSInfo);
        sensordata.setEnableGPS(hasGPSInfo);

        //获取加速度信息
        float acc_x =  (float)(sensordata.getAcceleration().getX_axis()*50)/32767;
        float acc_y =  (float)(sensordata.getAcceleration().getY_axis()*50)/32767;
        float acc_z =  (float) (sensordata.getAcceleration().getZ_axis()*50)/32767;

        //获取角速度信息
        float gyro_x =  (float)(sensordata.getGyroscope().getX_axis()*50)/32767;
        float gyro_y =  (float)(sensordata.getGyroscope().getY_axis()*50)/32767;
        float gyro_z =  (float)(sensordata.getGyroscope().getZ_axis()*50)/32767;

        //获取磁力计信息
        float magn_x =  (float)(sensordata.getMagnetic().getX_axis()*100)/32767;
        float magn_y =  (float)(sensordata.getMagnetic().getY_axis()*100)/32767;
        float magn_z =  (float)(sensordata.getMagnetic().getZ_axis()*100)/32767;

        StringBuilder sb_acc = new StringBuilder();
        sb_acc.append(acc_x).append(",").append(acc_y).append(",").append(acc_z);
        StringBuilder sb_gyro = new StringBuilder();
        sb_gyro.append(gyro_x).append(",").append(gyro_y).append(",").append(gyro_z);
        StringBuilder sb_magn = new StringBuilder();
        sb_magn.append(magn_x).append(",").append(magn_y).append(",").append(magn_z);

        System.out.println(String.format("%.2f",acc_z) + " " +sb_acc.toString() + " " + sb_gyro.toString()+ " " + sb_magn.toString());

        //writeToFile(sb_acc.toString(),"acceleration.txt");
        //writeToFile(sb_gyro.toString(),"gyroscope.txt");
        //writeToFile(sb_magn.toString(),"magnetic.txt");
        return sensordata.toString();
    }


    /**
     * 将当前字符串写入文件
     * @param log 字符串
     * @param filename 文件名
     * @return yes or no
     */
    public static boolean writeToFile(String log,String filename) {
        String logFilePath = filename;
        File logFile = new File(logFilePath);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
        }

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(new File(logFilePath), true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "unicode");
            osw.write(log);
            osw.write("\n");
            osw.flush();
            osw.close();
            return true;
        } catch (FileNotFoundException e1) {
            //e1.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            //e2.printStackTrace();
        } catch (Exception e2) {
            //e2.printStackTrace();
        }
        return false;
    }

    /**
     * 获取当前infotype下的数据信息的字节长度
     * @param inforType 传感器信息容量描述
     * @return 传感器信息字节数据长度
     */
    public static int getNextReadSize(byte inforType){
        int res = 0;
        switch (inforType){
            case (byte) 0x00000000:
                res = 20;
                break;
            case (byte) 0x00000040:
                res = 44;
                break;
            case (byte) 0x000000C0:
                res = 52;
                break;
            case (byte) 0x000000E0:
                res = 68;
                break;
        }
        return res;
    }
}
