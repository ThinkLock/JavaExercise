package DiDiTest;

import java.io.Serializable;

/**
 * Created by fengzhaoyang_i on 2017/4/14.
 */
public class SensorDesc implements Serializable{


    /**
     * 传感器名称，例如LSM6DS3 Accelerometer Sensor
     */
    private  String name;
    /*
     * 制造商，例如STMicroelectronics
     */
    private  String vendor;

    /**
     * //版本号，例如1
     */
    private  Integer version;


    /**
     * 类别
     */
    private  Integer type;       //类别，例如磁力计为2

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

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getType() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setType(Integer type) {
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
}
