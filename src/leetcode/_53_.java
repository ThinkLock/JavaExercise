package leetcode;

/**
 * Maximum Subarray
 * Created by fengzhaoyang_i on 2017/5/9.
 */
public class _53_ {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;

    }

    public static void main(String[] args){
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(a));
    }
}
