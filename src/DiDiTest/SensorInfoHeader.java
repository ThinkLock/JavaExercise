package DiDiTest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;


/**
 * Created by fengzhaoyang_i on 2017/4/20.
 */
public class SensorInfoHeader {

    /**
     * 乘客手机号
     */
    private StringBuffer passenger_phone;

    /**
     * 乘客ID
     */
    private StringBuffer passenger_id;

    /**
     * 司机手机号
     */
    private StringBuffer driver_phone;

    /**
     * 司机ID
     */
    private StringBuffer driver_id;

    /**
     * 传感器描述信息
     */
    private List<SensorDesc> sensors;

    /**
     * 传感器采集频率
     */
    private int sample_frequerency;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[passenger_phone=").append(passenger_phone.getContent()).append("]");
        sb.append("[passenger_id=").append(passenger_id.getContent()).append("]");
        sb.append("[driver_phone=").append(driver_phone.getContent()).append("]");
        sb.append("[driver_id=").append(driver_id.getContent()).append("]");
        sb.append("[sensors=");
        for(SensorDesc sensorDescr : sensors){
            sb.append("{");
            sb.append(sensorDescr.toString());
            sb.append("}");
        }
        sb.append("]");
        sb.append("[sample_frequerency=").append(sample_frequerency).append("]");
        return sb.toString();
    }

    public ByteBuffer getByteBuffer(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put(passenger_phone.getStringBufferByte());
            buf.put(passenger_id.getStringBufferByte());
            buf.put(driver_phone.getStringBufferByte());
            buf.put(driver_id.getStringBufferByte());
            for (SensorDesc sensorDescr : sensors) {
                buf.put(sensorDescr.getName().getStringBufferByte());
                buf.put(sensorDescr.getVendor().getStringBufferByte());
                buf.putShort(sensorDescr.getVersion());
                buf.putShort(sensorDescr.getType());
                buf.putFloat(sensorDescr.getMax_range());
                buf.putFloat(sensorDescr.getResolution());
                buf.putFloat(sensorDescr.getPower());
                buf.putFloat(sensorDescr.getMin_delay());
            }
            buf.putInt(sample_frequerency);
        }catch (Exception e){
            System.out.print("getByteBuffer"+e.toString());
        }
        return buf;
    }

    public StringBuffer getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(StringBuffer passenger_phone) {
        this.passenger_phone = passenger_phone;
    }

    public StringBuffer getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(StringBuffer passenger_id) {
        this.passenger_id = passenger_id;
    }

    public StringBuffer getDriver_phone() {
        return driver_phone;
    }

    public void setDriver_phone(StringBuffer driver_phone) {
        this.driver_phone = driver_phone;
    }

    public StringBuffer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(StringBuffer driver_id) {
        this.driver_id = driver_id;
    }

    public List<SensorDesc> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDesc> sensors) {
        this.sensors = sensors;
    }

    public int getSample_frequerency() {
        return sample_frequerency;
    }

    public void setSample_frequerency(int sample_frequerency) {
        this.sample_frequerency = sample_frequerency;
    }

    public static class StringBuffer{
        private String content;
        private short size;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getSize() {
            return size;
        }

        public void setSize(short size) {
            this.size = size;
        }

        public byte[] getStringBufferByte(){
            ByteBuffer buf = ByteBuffer.allocate(content.length()+2);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putShort(size);
            buf.put(content.getBytes());
            return buf.array();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
