package DiDiTest;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by fengzhaoyang_i on 2017/4/18.
 */
public class GPSData{

    /**
     * 经度
     */
    private Float lon;

    /**
     * 纬度
     */
    private Float lat;

    /**
     * 高度
     */
    private Float altitude;

    /**
     * 精度
     */
    private Byte accuracy;

    /**
     * 速度
     */
    private Byte speed;


    /**
     * 卫星数
     */
    private Byte sate_num;

    /**
     * 锁定卫星数
     */
    private Byte use_in_fixs;


    public GPSData(){}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[lon=").append(lon).append("]");
        sb.append("[lat=").append(lat).append("]");
        sb.append("[altitude=").append(altitude).append("]");
        sb.append("[accuracy=").append(accuracy).append("]");
        sb.append("[speed=").append(speed).append("]");
        sb.append("[sate_num=").append(sate_num).append("]");
        sb.append("[use_in_fixs=").append(use_in_fixs).append("]");
        return sb.toString();
    }

    public byte[] getBytes(){
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.putFloat(lon);
        buf.putFloat(lat);
        buf.putFloat(altitude);
        buf.put(accuracy);
        buf.put(speed);
        buf.put(sate_num);
        buf.put(use_in_fixs);
        return buf.array();
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public Byte getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Byte accuracy) {
        this.accuracy = accuracy;
    }

    public Byte getSpeed() {
        return speed;
    }

    public void setSpeed(Byte speed) {
        this.speed = speed;
    }

    public Byte getSate_num() {
        return sate_num;
    }

    public void setSate_num(Byte sate_num) {
        this.sate_num = sate_num;
    }

    public Byte getUse_in_fixs() {
        return use_in_fixs;
    }

    public void setUse_in_fixs(Byte use_in_fixs) {
        this.use_in_fixs = use_in_fixs;
    }
}
