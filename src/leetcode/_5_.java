package leetcode;

/**
 * 最长回文子串
 * Created by fengzhaoyang_i on 2017/5/4.
 */
public class _5_ {

    public static String getMaxPString(String s){
        if(s.length()<=1){
            return s;
        }
        int start = 0;
        int maxlen = 0;
        for(int i=1;i<s.length();i++){
            //奇数回文
            int low = i-1;
            int high = i+1;
            while (low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }

            if(high-low-1 >maxlen){
                maxlen = high-low-1;
                start = low+1;
            }
            //偶数回文子串
            low = i-1;
            high = i;
            while (low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }

            if(high-low-1 >maxlen){
                maxlen = high-low-1;
                start = low+1;
            }
        }

        return s.substring(start,start+maxlen);
    }
}
