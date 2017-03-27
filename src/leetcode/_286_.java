package leetcode;
public class _286_{

    public static int missingNum(int[] nums){
        if(nums==null)
            return 0;
        int sum = 0;
        for(int num: nums)
            sum += num;
            
        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,3};
        System.out.println(missingNum(a));
    }
}