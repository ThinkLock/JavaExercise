package leetcode;

import java.util.*;

/**
 * 落单的数第三版
 * Created by Yang on 2017/5/3.
 */
public class _260_ {

    public static int[] singleNumber(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                res.add(entry.getKey());
            }
        }
        int[] result = new int[res.size()];
        for(int i=0;i<result.length;i++){
            result[i] = res.get(i);
        }

        return result;
    }


}
