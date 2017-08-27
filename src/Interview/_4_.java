package Interview;

/**
 * 输入一个数n，找出小于等于n且满足一下规则的最大的数x。
 规则：x中的从左到右的每一位都是单调不减的。
 * Created by Yang on 2017/4/22.
 */
public class _4_ {

    /**
     * 检查当前数组是否符合单调不减的规则
     * @param x
     * @return
     */
    public static boolean checkNum(int x){
        String x_str = String.valueOf(x);
        for(int i=0;i<x_str.length()-1;i++){
            int pre = Integer.valueOf(""+x_str.charAt(i));
            int post = Integer.valueOf(""+x_str.charAt(i+1));
            if(post<pre){
                return false;
            }
        }
        return true;
    }

    public static int getMaxVauleFor(int n){
        for(int i=n;n>Integer.MIN_VALUE;i--){
            if(checkNum(i)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int n = 98;
        System.out.print(getMaxVauleFor(n));
    }
}
