package campus;

import java.util.Dictionary;

public class _581_ {

    /**每次得到在字典中存在的最短的前缀，
     * 如果存在，则将前缀截去，再求剩余部分的最短前缀，以此类推，直至字符串长度为0
     * 如果不存在，则将第一个字符截去，再最最短前缀*/
    int countOccurences(String s, Dictionary dict){
        int res = 0;
        String temp = s;
        while (temp.length() > 0){
            String min_pre = dict.match(s);
            if(min_pre != null){
                // 最短前缀不为空
                res++;
                temp = temp.substring(min_pre.length(), temp.length());
            }else {
                temp = temp.substring(1,temp.length());
            }
        }

        return res;
    }

    // 利用二分查找的方式进行
    /**利用二分查找的方式进行
     * 如果中间值小于最左边的值，证明旋转位置一定在中间值的右边包括中间值
     * 否则证明旋转位置在中间值的左边*/
    int findMin(int[] arr, int arrlen){
        if(arrlen==0)
            return 0;
        int low = 0;
        int high = arrlen - 1;
        int mid = 0;
        while (low<high){
            mid = (low+high)/2;
            if(arr[mid] < arr[low]){
                // 旋转位置一定在mid的右边，也有可能是mid
                low = mid;
            }else {
                high = mid-1;
            }
        }
        return arr[low];
    }
}
