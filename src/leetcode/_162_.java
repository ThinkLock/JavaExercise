package leetcode;

/**
 * Find Peak Element
 * 寻找峰值
 * Created by fengzhaoyang_i on 2017/5/15.
 */
public class _162_ {

    public static boolean isPeak(int[] nums,int i){
        int left = i-1>=0?nums[i-1]:Integer.MIN_VALUE;
        int right = i+1<nums.length?nums[i+1]:Integer.MIN_VALUE;

        if(nums[i]> left && nums[i]>right){
            return true;
        }else {
            return false;
        }
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;

        for(int i=0;i<nums.length;i++){
            if(isPeak(nums,i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,1};
        System.out.println(findPeakElement(a));
    }
}
