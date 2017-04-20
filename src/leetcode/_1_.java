package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengzhaoyang_i on 2017/4/20.
 */
public class _1_ {

    //time超时了
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null || nums.length==0)
            return res;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i]+nums[j]==target){
                    res[0] = i<j?i:j;
                    res[1] = i>j?i:j;
                }
            }
        }
        return res;
    }

    //优化办法
    public static int[] twoSum2(int[] nums,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = target-nums[i];
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
