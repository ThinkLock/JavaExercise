package DiDiTest;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by fengzhaoyang_i on 2017/4/14.
 */
public class SensorDesc{


    /**
     * 传感器名称，例如LSM6DS3 Accelerometer Sensor
     */
    private  StringBuffer name;
    /*
     * 制造商，例如STMicroelectronics
     */
    private  StringBuffer vendor;

    /**
     * //版本号，例如1
     */
    private  Short version;


    /**
     * 类别
     */
    private  Short type;       //类别，例如磁力计为2

    /**
     * 最大取值上限
     */
    private  Float max_range;  //最大取值上限

    /**
     * 分辨率
     */
    private  Float resolution; //分辨率

    /**
     * 耗电量
     */
    private  Float power;      //耗电量

    /**
     * 最小刷新时间间隔
     */
    private  Float min_delay;  //最小刷新时间间隔


    public SensorDesc(){}

    public StringBuffer getName() {
        return name;
    }

    public StringBuffer getVendor() {
        return vendor;
    }

    public Short getVersion() {
        return version;
    }

    public Short getType() {
        return type;
    }

    public Float getMax_range() {
        return max_range;
    }

    public Float getResolution() {
        return resolution;
    }

    public Float getPower() {
        return power;
    }

    public Float getMin_delay() {
        return min_delay;
    }

    public void setName(StringBuffer name) {
        this.name = name;
    }

    public void setVendor(StringBuffer vendor) {
        this.vendor = vendor;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public void setMax_range(Float max_range) {
        this.max_range = max_range;
    }

    public void setResolution(Float resolution) {
        this.resolution = resolution;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public void setMin_delay(Float min_delay) {
        this.min_delay = min_delay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[name=").append(name).append("]");
        sb.append("[vendor=").append(vendor).append("]");
        sb.append("[version=").append(version).append("]");
        sb.append("[type=").append(type).append("]");
        sb.append("[max_range=").append(max_range).append("]");
        sb.append("[resolution=").append(resolution).append("]");
        sb.append("[power=").append(power).append("]");
        sb.append("[min_delay=").append(min_delay).append("]");
        return sb.toString();
    }

    public ByteBuffer dataToByteBuffer() throws UnsupportedEncodingException{
        ByteBuffer buf = ByteBuffer.allocate( 1024 );
        byte[] bytes = name.getStringBufferByte();
        buf.put(bytes);
        bytes = vendor.getStringBufferByte();
        buf.put(bytes);
        buf.putShort(version);
        buf.putShort(type);
        buf.putFloat(max_range);
        buf.putFloat(resolution);
        buf.putFloat(power);
        buf.putFloat(min_delay);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        return buf;
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
            buf.putShort(size);
            buf.put(content.getBytes());
            return buf.array();
        }
    }
}
