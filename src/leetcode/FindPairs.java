package leetcode;
import java.util.*;
public class FindPairs{

    public static int findPairs(int[] nums, int k) {
        if(nums.length==0 || nums==null)
            return 0;
        
        HashMap<String,Boolean> flag = new HashMap<>(); 
        int count  = 0;
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(Math.abs(nums[i]-nums[j])==k) {
                    String s = nums[i]+" "+nums[j];
                    String s2 = nums[j] + " " + nums[i];
                    if(!flag.containsKey(s) && !flag.containsKey(s2)){
                        flag.put(nums[i]+" "+nums[j], true);
                        flag.put(nums[j]+" "+nums[i], true);
                        count++;
                        System.out.println(nums[i] + " " + nums[j]);
                    }
                }
            }
        }
        return count;
            
    }

    public static int findPairs2(int[] nums,int k){
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1};
        
        System.out.print(findPairs2(a,1));
    }
}