package Interview;

/**
 * 两个二进制字符串求和
 * Created by Yang on 2017/4/24.
 */
public class _22_ {

    public static String addToStringInt(String s1,String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        //对齐后的长度
        int len = len1>=len2?len1:len2;
        //对齐两个字符串
        if(len1<len2){
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (i<len2-len1){
                sb.append("0");
                i++;
            }
            s1 = sb.append(s1).toString();
        }
        if(len1>len2){
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (i<len1-len2){
                sb.append("0");
                i++;
            }
            s2 = sb.append(s2).toString();
        }
        //经过对齐后两个字符串的长度相同，从后向前逐步相加
        StringBuffer sb = new StringBuffer();
        int carry = 0;//进位
        for (int i = len-1;i>=0;i--){
            int val1 = Integer.valueOf(""+s1.charAt(i));
            int val2 = Integer.valueOf(""+s2.charAt(i));
            int sum = carry + val1 + val2;
            sb.append(""+(sum%2));
            carry = sum/2;
        }
        if(carry>0){
            sb.append(carry);
        }
        //反转后输出
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        String s1 = "1100100";
        String s2 = "110001";
        System.out.println(addToStringInt(s1,s2));
    }
}
