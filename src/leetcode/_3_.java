package leetcode;

/**
 * 最长无重复字符子串
 * Created by Yang on 2017/5/3.
 */
public class _3_ {

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        if(s.length()==1){
            return 1;
        }

        int start = 0;
        int end = s.length()-1;

        System.out.println(s.substring(0,end));

        return 1;
    }


    public static void main(String[] args){
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }
}
