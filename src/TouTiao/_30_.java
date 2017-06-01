package TouTiao;

/**
 * 反转整数
 * Created by Yang on 2017/5/24.
 */
public class _30_ {

    public static int reverseInt(int num){

        long res = 0L;
        int temp = Math.abs(num);
        while (temp>0){
            res *= 10;
            res += temp%10;
            if(res>Integer.MAX_VALUE){
                return 0;
            }
            temp = temp/10;
        }

        return num>=0?(int)res:(int)(-res);
    }

    public static void main(String[] args){
        int  a = -8876454;
        System.out.println(reverseInt(a));
    }
}
