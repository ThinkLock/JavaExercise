package leetcode;
public class _283_{

    public static void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;

        int len = nums.length;
        int id = 0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                nums[id++] = nums[i];
            }
        }

        for(int i=id;i<len;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        for(int i : a){
            System.out.print(i+" ");
        }
        moveZeroes(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}