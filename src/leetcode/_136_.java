package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 落单的数
 * Created by Yang on 2017/5/3.
 */
public class _136_ {

    public static int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                res = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] a = {1,2,2,1,3,4,3};
        System.out.println(singleNumber(a));
    }
}
