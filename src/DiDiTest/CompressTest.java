package DiDiTest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩算法测试
 * Created by fengzhaoyang_i on 2017/5/4.
 */
public class CompressTest {

    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\fengzhaoyang_i\\Desktop\\trace_data\\2017-5-4\\trace_sensor_get_on_bin.txt");
            FileChannel fc = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(fis.available());
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            fc.read(buffer);
            buffer.flip();
            System.out.println("Original " +buffer.limit()/1024 + "KB");
            System.out.println(" Gzip " + gZip(buffer.array()).length/1024 + "KB" + " " + ((double)gZip(buffer.array()).length/buffer.limit())*100 + "%");
            System.out.println(" Zip " + zip(buffer.array()).length/1024 + "KB" + " " + ((double)zip(buffer.array()).length/buffer.limit())*100 +"%");
            System.out.println(" Deflate " + getGZipCompressed(buffer.array()).length/1024 + "KB" + " " + ((double)getGZipCompressed(buffer.array()).length/buffer.limit())*100 + "%");
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /** 使用gzip方式压缩数组 */
    public static byte[] gZip(byte[] data) {
        long now = System.currentTimeMillis();
        byte[] result = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            result = bos.toByteArray();
            bos.close();
        } catch (Throwable ex) {
            //ex.printStackTrace();
        }
        System.out.print("time: " + (System.currentTimeMillis()-now));
        return result;
    }

    /** 使用zip方式压缩数组 */
    public static byte[] zip(byte[] data) {
        long now = System.currentTimeMillis();
        byte[] result = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zip = new ZipOutputStream(bos);
            ZipEntry entry = new ZipEntry("zip");
            entry.setSize(data.length);
            zip.putNextEntry(entry);
            zip.write(data);
            zip.closeEntry();
            zip.close();
            result = bos.toByteArray();
            bos.close();
        } catch (Throwable ex) {
            //ex.printStackTrace();
        }
        System.out.print("time: " + (System.currentTimeMillis()-now));
        return result;
    }

    public static byte[] getGZipCompressed(byte[] byteData) {
        long now = System.currentTimeMillis();
        byte[] compressed = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(
                    byteData.length);
            Deflater compressor = new Deflater();
            compressor.setLevel(Deflater.BEST_COMPRESSION);
            compressor.setInput(byteData, 0, byteData.length);
            compressor.finish();

            final byte[] buf = new byte[1024];
            while (!compressor.finished()) {
                int count = compressor.deflate(buf);
                bos.write(buf, 0, count);
            }
            compressor.end();
            compressed = bos.toByteArray();
            bos.close();
        } catch (Throwable e) {//fix crash:http://omega.xiaojukeji.com/app/quality/crash/detail?app_id=1&msgid=H--I-HEkSZm8Oydz01nc5w
            //e.printStackTrace();
        }
        System.out.print("time: " + (System.currentTimeMillis()-now));
        return compressed;
    }

}
