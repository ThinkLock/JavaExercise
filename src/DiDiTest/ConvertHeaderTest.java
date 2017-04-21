package DiDiTest;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengzhaoyang_i on 2017/4/21.
 */
public class ConvertHeaderTest {

    public static void main(String[] args){

        try {
            FileInputStream fis = new FileInputStream("trace_record_header_bin.txt");
            FileChannel fc = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            int r = fc.read(buffer);
            buffer.flip();

            byte[] temp;
            short size;

            //乘客手机号
            SensorInfoHeader.StringBuffer passenger_phone = new SensorInfoHeader.StringBuffer();
            size = buffer.get();
            passenger_phone.setSize(size);
            temp = new byte[size];
            buffer.get(temp);
            passenger_phone.setContent(new String(temp));
            //乘客id
            SensorInfoHeader.StringBuffer passenger_id = new SensorInfoHeader.StringBuffer();
            size = buffer.get();
            passenger_id.setSize(size);
            temp = new byte[size];
            buffer.get(temp);
            passenger_id.setContent(new String(temp));
            //司机手机号
            SensorInfoHeader.StringBuffer driver_phone = new SensorInfoHeader.StringBuffer();
            size = buffer.get();
            driver_phone.setSize(size);
            temp = new byte[size];
            buffer.get(temp);
            driver_phone.setContent(new String(temp));

            //司机id
            SensorInfoHeader.StringBuffer driver_id = new SensorInfoHeader.StringBuffer();
            size = buffer.get();
            driver_id.setSize(size);
            temp = new byte[size];
            buffer.get(temp);
            driver_id.setContent(new String(temp));

            List<SensorDesc> mSensorsList = new ArrayList<>();

            //构造传感器描述信息
            for(int i=0;i<9;i++){

                SensorDesc.StringBuffer sb_name = new SensorDesc.StringBuffer();
                SensorDesc.StringBuffer sb_vendor = new SensorDesc.StringBuffer();
                size = buffer.get();
                temp = new byte[size];
                buffer.get(temp);
                sb_name.setSize(size);
                sb_name.setContent(new String(temp));
                size = buffer.get();
                temp = new byte[size];
                buffer.get(temp);
                sb_vendor.setSize(size);
                sb_vendor.setContent(new String(temp));

                SensorDesc sensorDesc = new SensorDesc();
                sensorDesc.setName(sb_name);
                sensorDesc.setVendor(sb_vendor);
                sensorDesc.setVersion(buffer.getShort());
                sensorDesc.setType(buffer.getShort());
                sensorDesc.setMax_range(buffer.getFloat());
                sensorDesc.setResolution(buffer.getFloat());
                sensorDesc.setPower(buffer.getFloat());
                sensorDesc.setMin_delay(buffer.getFloat());

                mSensorsList.add(sensorDesc);
            }


            //构造记录的头部信息，包括乘客手机号，乘客id，司机手机号，司机id，传感器描述信息，采集频率
            SensorInfoHeader recordHeader = new SensorInfoHeader();
            recordHeader.setPassenger_phone(passenger_phone);
            recordHeader.setPassenger_id(passenger_id);
            recordHeader.setDriver_phone(driver_phone);
            recordHeader.setDriver_id(driver_id);
            recordHeader.setSensors(mSensorsList);
            recordHeader.setSample_frequerency(buffer.getInt());


            System.out.print(recordHeader.toString());

            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
