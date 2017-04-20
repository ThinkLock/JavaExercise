package DiDiTest;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by fengzhaoyang_i on 2017/4/18.
 */
public class SensorData {

    /**
     * 信息块类别
     */
    private Byte info_type;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 加速度
     */
    private Accelerometer acceleration;

    /**
     * 角速度
     */
    private Gyroscope gyroscope;

    /**
     * 角速度时间间隔
     */
    private short gyro_dt;

    /**
     * 磁力
     */
    private Magnetic magnetic;


    //===>info_type第1个比特为1时填充这些信息，其采集频率为10HZ
    /**
     * 气压
     */
    private Float pressure;

    /**
     * 光照
     */
    private Float light;

    /**
     * 温度
     */
    private Short temperature;

    /**
     * 距离
     */
    private Short distance; //频率10HZ


    /**
     * 重力
     */
    private Gravity gravity; //频率10HZ

    /**
     * 旋转向量
     */
    private RotationVector rotation_vector; //频率10HZ


    //===>info_type第2个比特为1时填充这些信息，其采集频率为1HZ
    private GPSData gps; //频率1HZ

    //标记是否将其他传感器信息放入返回的bytebuffer
    private Boolean EnableOthersSensor;

    //标记是否将时间戳返回bytebuffer
    private Boolean EnableTS;

    //标记是否将GPS信息返回bytebuffer
    private Boolean EnableGPS;

    public SensorData(){}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[info_type=").append(info_type).append("]");
        if(EnableTS) {
            sb.append("[timestamp=").append(timestamp).append("]");
        }
        sb.append("[acceleration=").append(acceleration==null?"null":acceleration.toString()).append("]");
        sb.append("[gyroscope=").append(gyroscope==null?"null":gyroscope.toString()).append("]");
        sb.append("[gyro_dt=").append(gyro_dt).append("]");
        sb.append("[magnetic=").append(magnetic==null?"null":magnetic.toString()).append("]");
        if(EnableOthersSensor) {
            sb.append("[pressure=").append(pressure).append("]");
            sb.append("[light=").append(light).append("]");
            sb.append("[temperature=").append(temperature).append("]");
            sb.append("[distance=").append(distance).append("]");
            sb.append("[gravity=").append(gravity == null ? "null" : gravity.toString()).append("]");
            sb.append("[rotation_vector=").append(rotation_vector == null ? "null" : rotation_vector.toString()).append("]");
        }
        if(EnableGPS) {
            sb.append("[gps=").append(gps == null ? "null" : gps.toString()).append("]");
        }
        return sb.toString();
    }

    public ByteBuffer getSensorDataByteBuffer(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(info_type);
        if(EnableTS){
            buf.putLong(timestamp);
        }
        buf.put(acceleration.getBytes());
        buf.put(gyroscope.getBytes());
        buf.putShort(gyro_dt);
        buf.put(magnetic.getBytes());

        if(EnableOthersSensor){
            buf.putFloat(pressure);
            buf.putFloat(light);
            buf.putShort(temperature);
            buf.putShort(distance);
            buf.put(gravity.getBytes());
            buf.put(rotation_vector.getBytes());
        }
        if(EnableGPS){
            buf.put(gps.getBytes());
        }

        return buf;
    }


    public static class Accelerometer {
        private Short x_axis;
        private Short y_axis;
        private Short z_axis;

        public Accelerometer(){}

        public Short getX_axis() {
            return x_axis;
        }

        public void setX_axis(Short x_axis) {
            this.x_axis = x_axis;
        }

        public Short getY_axis() {
            return y_axis;
        }

        public void setY_axis(Short y_axis) {
            this.y_axis = y_axis;
        }

        public Short getZ_axis() {
            return z_axis;
        }

        public void setZ_axis(Short z_axis) {
            this.z_axis = z_axis;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("x:").append(x_axis).append(",");
            sb.append("y:").append(y_axis).append(",");
            sb.append("z:").append(z_axis);
            return sb.toString();
        }

        public byte[] getBytes(){
            ByteBuffer buf = ByteBuffer.allocate(6);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putShort(x_axis);
            buf.putShort(y_axis);
            buf.putShort(z_axis);
            return buf.array();
        }
    }

    public static class Gyroscope {
        private Short x_axis;
        private Short y_axis;
        private Short z_axis;

        public Gyroscope(){}

        public Short getX_axis() {
            return x_axis;
        }

        public void setX_axis(Short x_axis) {
            this.x_axis = x_axis;
        }

        public Short getY_axis() {
            return y_axis;
        }

        public void setY_axis(Short y_axis) {
            this.y_axis = y_axis;
        }

        public Short getZ_axis() {
            return z_axis;
        }

        public void setZ_axis(Short z_axis) {
            this.z_axis = z_axis;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("x:").append(x_axis).append(",");
            sb.append("y:").append(y_axis).append(",");
            sb.append("z:").append(z_axis);
            return sb.toString();
        }

        public byte[] getBytes(){
            ByteBuffer buf = ByteBuffer.allocate(6);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putShort(x_axis);
            buf.putShort(y_axis);
            buf.putShort(z_axis);
            return buf.array();
        }
    }

    public static class Magnetic {
        private Short x_axis;
        private Short y_axis;
        private Short z_axis;

        public Magnetic(){}

        public Short getX_axis() {
            return x_axis;
        }

        public void setX_axis(Short x_axis) {
            this.x_axis = x_axis;
        }

        public Short getY_axis() {
            return y_axis;
        }

        public void setY_axis(Short y_axis) {
            this.y_axis = y_axis;
        }

        public Short getZ_axis() {
            return z_axis;
        }

        public void setZ_axis(Short z_axis) {
            this.z_axis = z_axis;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("x:").append(x_axis).append(",");
            sb.append("y:").append(y_axis).append(",");
            sb.append("z:").append(z_axis);
            return sb.toString();
        }

        public byte[] getBytes(){
            ByteBuffer buf = ByteBuffer.allocate(6);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putShort(x_axis);
            buf.putShort(y_axis);
            buf.putShort(z_axis);
            return buf.array();
        }
    }

    public static class Gravity {
        private Short x_axis;
        private Short y_axis;
        private Short z_axis;

        public Gravity(){}

        public Short getX_axis() {
            return x_axis;
        }

        public void setX_axis(Short x_axis) {
            this.x_axis = x_axis;
        }

        public Short getY_axis() {
            return y_axis;
        }

        public void setY_axis(Short y_axis) {
            this.y_axis = y_axis;
        }

        public Short getZ_axis() {
            return z_axis;
        }

        public void setZ_axis(Short z_axis) {
            this.z_axis = z_axis;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("x:").append(x_axis).append(",");
            sb.append("y:").append(y_axis).append(",");
            sb.append("z:").append(z_axis);
            return sb.toString();
        }
        public byte[] getBytes(){
            ByteBuffer buf = ByteBuffer.allocate(6);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putShort(x_axis);
            buf.putShort(y_axis);
            buf.putShort(z_axis);
            return buf.array();
        }
    }

    public static class RotationVector {
        private Short x_axis;
        private Short y_axis;
        private Short z_axis;

        public RotationVector(){}

        public Short getX_axis() {
            return x_axis;
        }

        public void setX_axis(Short x_axis) {
            this.x_axis = x_axis;
        }

        public Short getY_axis() {
            return y_axis;
        }

        public void setY_axis(Short y_axis) {
            this.y_axis = y_axis;
        }

        public Short getZ_axis() {
            return z_axis;
        }

        public void setZ_axis(Short z_axis) {
            this.z_axis = z_axis;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("x:").append(x_axis).append(",");
            sb.append("y:").append(y_axis).append(",");
            sb.append("z:").append(z_axis);
            return sb.toString();
        }

        public byte[] getBytes(){
            ByteBuffer buf = ByteBuffer.allocate(6);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.putShort(x_axis);
            buf.putShort(y_axis);
            buf.putShort(z_axis);
            return buf.array();
        }
    }

    public Byte getInfo_type() {
        return info_type;
    }

    public void setInfo_type(Byte info_type) {
        this.info_type = info_type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Accelerometer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Accelerometer acceleration) {
        this.acceleration = acceleration;
    }

    public Gyroscope getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(Gyroscope gyroscope) {
        this.gyroscope = gyroscope;
    }

    public short getGyro_dt() {
        return gyro_dt;
    }

    public void setGyro_dt(short gyro_dt) {
        this.gyro_dt = gyro_dt;
    }

    public Magnetic getMagnetic() {
        return magnetic;
    }

    public void setMagnetic(Magnetic magnetic) {
        this.magnetic = magnetic;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getLight() {
        return light;
    }

    public void setLight(Float light) {
        this.light = light;
    }

    public Short getTemperature() {
        return temperature;
    }

    public void setTemperature(Short temperature) {
        this.temperature = temperature;
    }

    public Short getDistance() {
        return distance;
    }

    public void setDistance(Short distance) {
        this.distance = distance;
    }

    public Gravity getGravity() {
        return gravity;
    }

    public void setGravity(Gravity gravity) {
        this.gravity = gravity;
    }

    public RotationVector getRotation_vector() {
        return rotation_vector;
    }

    public void setRotation_vector(RotationVector rotation_vector) {
        this.rotation_vector = rotation_vector;
    }

    public GPSData getGps() {
        return gps;
    }

    public void setGps(GPSData gps) {
        this.gps = gps;
    }

    public Boolean getEnableOthersSensor() {
        return EnableOthersSensor;
    }

    public void setEnableOthersSensor(Boolean enableOthersSensor) {
        EnableOthersSensor = enableOthersSensor;
    }

    public Boolean getEnableTS() {
        return EnableTS;
    }

    public void setEnableTS(Boolean enableTS) {
        EnableTS = enableTS;
    }

    public Boolean getEnableGPS() {
        return EnableGPS;
    }

    public void setEnableGPS(Boolean enableGPS) {
        EnableGPS = enableGPS;
    }
}
