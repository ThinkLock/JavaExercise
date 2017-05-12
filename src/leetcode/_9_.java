package leetcode;

/**
 * 回文数
 * Created by fengzhaoyang_i on 2017/5/12.
 */
public class _9_ {
    public static boolean isPalindrome(int x){

        String s = String.valueOf(x);

        if(s.length()==1)
            return true;

        int left;
        int right;
        if(s.length()%2==1){
            //长度为奇数
            left = (s.length()/2) -1;
            right = (s.length()/2) +1;
        }else {
            //长度为偶数
            right = s.length()/2;
            left = right -1;
        }

        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        if(right-left-1 == s.length()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        int x = 1233521;
        System.out.println(isPalindrome(x));
    }
}
