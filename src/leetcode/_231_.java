package leetcode;

/**
 * Created by Yang on 2017/3/30. 判断是不是2的指数
 */
public class _231_ {

    public static boolean isPow(int n){
        if(n<1)
            return false;

        return (n&(n-1))==0;
    }
}
