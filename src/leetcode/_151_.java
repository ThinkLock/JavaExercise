package leetcode;

/**
 * 反转字符串
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Created by fengzhaoyang_i on 2017/5/2.
 */
public class _151_{


    public static void reverse(char[] s,int start,int end){
        while (start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            ++start;
            --end;
        }
    }

    public static String reverseWords(String s) {
        char[] a = s.toCharArray();
        int start = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]==' '){
                reverse(a,start,i-1);
                start = i+1;
            }
        }
        reverse(a,start,a.length-1);
        reverse(a,0,a.length-1);
        return new String(a);
    }

    public static void main(String[] main){
        String s = "the sky is blue";
        System.out.print(reverseWords(s));
    }
}
