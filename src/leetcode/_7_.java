package leetcode;

/**
 * 反转整数
 * Created by fengzhaoyang_i on 2017/5/12.
 */
public class _7_ {

    public static int reverse(int x) {
        if(x>-10 && x <10)
            return x;
        boolean isna = false;
        if(x>0) {
            isna = false;
        }else {
            isna = true;
        }

        String s = String.valueOf(x);

        String res = reverseStr(isna?1:0,s.length()-1,s.toCharArray());

        int int_res = Integer.valueOf(res);

        return int_res;
    }

    public static String reverseStr(int low,int high,char[] a){

        while (low<high){
            char temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }

        return new String(a);
    }

    public static void main(String[] args){
        int a = 123;
        int b = -123;
        System.out.println(reverse(a));
        System.out.println(reverse(b));
    }

}
