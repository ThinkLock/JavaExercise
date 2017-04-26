package TouTiao;

/**
 * 最长回文子序列
 * Created by fengzhaoyang_i on 2017/4/24.
 */
public class _18_ {

    public static String getMaxSubString(String a){
        if(a.length()<=1)
            return a;

        int start=0,maxlen = 0;

        for(int i=1;i<a.length();i++){

            //偶数回文子串
            int low = i-1;
            int high = i;
            while (low>=0 && high<a.length() && a.charAt(low)==a.charAt(high)){
                low--;
                high++;
            }

            if(high-low-1 >maxlen){
                maxlen = high-low-1;
                start = low+1;
            }

            //奇数回文
            low = i-1;
            high = i+1;
            while (low>=0 && high<a.length() && a.charAt(low)==a.charAt(high)){
                low--;
                high++;
            }

            if(high-low-1 >maxlen){
                maxlen = high-low-1;
                start = low+1;
            }

        }

        return a.substring(start,maxlen);
    }

    public static void main(String[] args){
        String s = "ascabach";
        System.out.print(getMaxSubString(s));
    }
}
