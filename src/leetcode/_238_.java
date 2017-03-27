package leetcode;
public class _238_{

    public static int[] productExceptSelf(int[] nums){

        if(nums==null)
            return null;
        if(nums.length==0){
            return new int[0];
        }

        int all = 1;
        for(int a : nums){
            all*=a;
        }

        int[] output = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            output[i] = all/nums[i];
        }

        return output;
    }


    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        ArrayUtils.printArray(a);
        int[] b= productExceptSelf2(a);
        ArrayUtils.printArray(b);
    }
}