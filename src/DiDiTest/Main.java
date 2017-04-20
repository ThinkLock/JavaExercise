package DiDiTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by fengzhaoyang_i on 2017/4/14.
 */
public class Main {
    //信息块类别
    static  byte mInfo_type;
    //时间戳
    static long mTimeStamp;
    //加速度
    static short[] mAcceleration;
    //角速度
    static short[] mGyroscope;
    //角速度dt
    static short mGyro_dt;
    //记录上次采集角度的时间,单位us
    static long mLastGetGyroTime = 0l;
    //磁场
    static short[] mMahnetic;

    //气压
    static float mPressure;
    //光照
    static float mLight;
    //温度
    static short mTemperature;
    //距离
    static short mDistance;
    //重力
    static short[] mGravity;
    //旋转向量
    static short[] mRotationVector;


    //gps信息中间值
    //经度
    static float mLon;
    //纬度
    static float mLat;
    //高度
    static float mAltitude;
    //精度
    static byte mAccuracy;
    //速度
    static byte mSpeed;
    //卫星数
    static byte mSateNum;
    //锁定卫星数
    static byte mUseInFixs;

    static int info_type_count = 1;
    static Boolean EnableTSandGPS = false;
    static Boolean EnableOthersSensor = false;


    public static void main(String[] args) {




        String name = "hello world";
        String vendor = "hello";

        SensorDesc.StringBuffer sb_name = new SensorDesc.StringBuffer();
        sb_name.setContent(name);
        sb_name.setSize((short)name.length());

        SensorDesc.StringBuffer sb_vendor = new SensorDesc.StringBuffer();
        sb_vendor.setContent(vendor);
        sb_vendor.setSize((short)vendor.length());


        SensorDesc sensorDesc = new SensorDesc();
        sensorDesc.setName(sb_name);
        sensorDesc.setVendor(sb_vendor);
        sensorDesc.setVersion((short)1);
        sensorDesc.setType((short)1);
        sensorDesc.setMax_range(500.0f);
        sensorDesc.setResolution(100.0f);
        sensorDesc.setPower(20.0f);
        sensorDesc.setMin_delay(30.0f);


//        try {
//            //写入数据测试
//            FileOutputStream fout = new FileOutputStream("bufferwithsize.txt");
//            FileChannel fcout = fout.getChannel();
//            ByteBuffer bufferout = sensorDesc.dataToByteBuffer();
//            bufferout.flip();
//            fcout.write(bufferout);
//            System.out.println(bufferout.order());
//
//            FileInputStream fin = new FileInputStream( "bufferwithsize.txt" );
//            FileChannel fc = fin.getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate( 1024 );
//            fc.read(buffer);
//
//            buffer.flip();
//            while (buffer.position()<buffer.limit()){
//                System.out.print(buffer.get()+" ");
//            }
////            for(int i=0;i<buffer.position();i++){
////                System.out.println(buffer.get(i));
////            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        mAcceleration = new short[3];
        mGyroscope = new short[3];
        mMahnetic = new short[3];
        mGravity = new short[3];
        mRotationVector = new short[3];
        mLastGetGyroTime = System.currentTimeMillis()*1000;


        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                mTimeStamp = System.currentTimeMillis();
                //Log.i("runnable click ",System.currentTimeMillis()+"");
                if(info_type_count%50==1){
                    //1HZ 部分
                    info_type_count = 1;
                    EnableTSandGPS = true;
                    EnableOthersSensor = true;
                    mInfo_type = (byte)0x000000E0;

                }else if(info_type_count%10==1){
                    // 10Hz 部分
                    EnableOthersSensor = true;
                    EnableTSandGPS = false;
                    mInfo_type = (byte)0x00000040;
                }else{
                    // 50 HZ 部分
                    EnableTSandGPS = false;
                    EnableOthersSensor = false;
                    mInfo_type = (byte)0x00000000;
                }

                //构建加速度计数据
                SensorData.Accelerometer acceleration = new SensorData.Accelerometer();
                acceleration.setX_axis(mAcceleration[0]);
                acceleration.setY_axis(mAcceleration[1]);
                acceleration.setZ_axis(mAcceleration[2]);

                //构建角速度计数据
                SensorData.Gyroscope gyroscepe = new SensorData.Gyroscope();
                gyroscepe.setX_axis(mGyroscope[0]);
                gyroscepe.setY_axis(mGyroscope[1]);
                gyroscepe.setZ_axis(mGyroscope[2]);

                //构建磁力计数据
                SensorData.Magnetic magnetic = new SensorData.Magnetic();
                magnetic.setX_axis(mMahnetic[0]);
                magnetic.setY_axis(mMahnetic[1]);
                magnetic.setZ_axis(mMahnetic[2]);

                //构建重力计数据
                SensorData.Gravity gravity = new SensorData.Gravity();
                gravity.setX_axis(mGravity[0]);
                gravity.setY_axis(mGravity[1]);
                gravity.setZ_axis(mGravity[2]);

                //构建旋转向量数据
                SensorData.RotationVector rotationVector = new SensorData.RotationVector();
                rotationVector.setX_axis(mRotationVector[0]);
                rotationVector.setY_axis(mRotationVector[1]);
                rotationVector.setZ_axis(mRotationVector[2]);

                //构建GPS信息
                GPSData gpsdata = new GPSData();
                gpsdata.setLon(mLon);
                gpsdata.setLat(mLat);
                gpsdata.setAltitude(mAltitude);
                gpsdata.setAccuracy(mAccuracy);
                gpsdata.setSpeed(mSpeed);
                gpsdata.setSate_num(mSateNum);
                gpsdata.setUse_in_fixs(mUseInFixs);


                SensorData sensordata = new SensorData();
                sensordata.setInfo_type(mInfo_type);
                if(EnableTSandGPS){
                    //是否配置时间戳和gps信息
                    sensordata.setTimestamp(mTimeStamp);
                    sensordata.setGps(gpsdata);
                }
                sensordata.setAcceleration(acceleration);
                sensordata.setGyroscope(gyroscepe);
                sensordata.setGyro_dt(mGyro_dt);
                sensordata.setMagnetic(magnetic);

                if(EnableOthersSensor){
                    //是否配置其他传感器信息
                    sensordata.setPressure(mPressure);
                    sensordata.setLight(mLight);
                    sensordata.setTemperature(mTemperature);
                    sensordata.setDistance(mDistance);
                    sensordata.setGravity(gravity);
                    sensordata.setRotation_vector(rotationVector);
                }

                sensordata.setEnableOthersSensor(EnableOthersSensor);
                sensordata.setEnableTS(EnableTSandGPS);

                try {
                    FileOutputStream fout = new FileOutputStream("sensors_littleend.txt",true);
                    FileChannel fcout = fout.getChannel();
                    ByteBuffer bufferout = sensordata.getSensorDataByteBuffer();
                    bufferout.flip();
                    fcout.write(bufferout);
                    System.out.println(sensordata.toString() +"\n" + bufferout.position());
                }catch (Exception e){
                    e.printStackTrace();
                }
                info_type_count++;
            }
        };


        Timer timer2 = new Timer();
        final TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {

                mAcceleration[0] = (short) (0.08*32767/50);
                mAcceleration[1] = (short)(0.06*32767/50);
                mAcceleration[2] = (short)(0.078*32767/50);
           
                //角速度获取
                long now_ts = System.currentTimeMillis()*1000;
                mGyroscope[0] = (short)(0.08*32767/50);
                mGyroscope[1] = (short)(0.08*32767/50);
                mGyroscope[2] = (short)(0.08*32767/50);
                mGyro_dt = (short) (now_ts-mLastGetGyroTime);
                mLastGetGyroTime = now_ts;
           
                //磁场获取
                mMahnetic[0] = (short)(0.08*32767/100);
                mMahnetic[1] = (short)(0.08*32767/100);
                mMahnetic[2] = (short)(0.008*32767/100);
          
                //气压
                mPressure = 23;
       
                //光照
                mLight = 657;
          
                //温度
                mTemperature = (short)(23);
         
                //距离
                mDistance = (short)45;
    
                //重力
                mGravity[0] = (short)(9.8*32767/50);
                mGravity[1] = (short)(0.09*32767/50);
                mGravity[2] = (short)(0.09*32767/50);
     
                //旋转向量
                mRotationVector[0] = (short)(0.73*32767);
                mRotationVector[1] = (short)(0.0064*32767);
                mRotationVector[2] = (short)(0.7*32767);
            }
        };

        timer2.scheduleAtFixedRate(timerTask2,0,10);
        timer.scheduleAtFixedRate(timerTask,1000,20);
    }
}
