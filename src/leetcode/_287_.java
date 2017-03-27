package leetcode;
import java.util.*;
public class _287_{

    public static int findDuplicate(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int[] index = new int[nums.length+1];

        for(int i : nums){
            index[i] ++;
        }

        for(int i=0;i<nums.length+1;i++){
            if(index[i]>1){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,1};
        System.out.print(findDuplicate(a));
    }
}