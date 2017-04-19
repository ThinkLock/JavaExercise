package DiDiTest;

import java.io.*;

/**
 * Created by fengzhaoyang_i on 2017/4/18.
 */
public class FileUitls {

    public static byte[] objectToBytes(final Serializable object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos  =  null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
            return baos.toByteArray();
        } finally {
            if (oos != null)  {
                oos.close();
            }
            if (baos != null) {
                baos.close();
            }
        }
    }
}
