package leetcode;

import static leetcode._151_.reverse;

/**反转字符串III
 * Created by fengzhaoyang_i on 2017/5/2.
 */
public class _557_ {
    public static String reverseWordsIII(String s) {
        char[] a = s.toCharArray();
        int start = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]==' '){
                reverse(a,start,i-1);
                start = i+1;
            }
        }
        reverse(a,start,a.length-1);

        return new String(a);
    }

    public static void main(String[] main){
        String s = "the sky is blue";
        System.out.print(reverseWordsIII(s));
    }
}
