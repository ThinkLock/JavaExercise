package leetcode;
import java.util.*;
public class _229_{

    public static List<Integer> FindMutil(int[] nums){
        if(nums==null)
            return null;
        if(nums.length==0){
            return new ArrayList<Integer>();
        }
        List<Integer> result  = new ArrayList<>();
        HashMap<Integer,Integer> ha = new HashMap<>();
        for(int a :nums){
            if(ha.containsKey(a)){
                ha.put(a, ha.get(a)+1);
            }else{
                ha.put(a, 1);
            }
        }

       for (Map.Entry<Integer, Integer> entry : ha.entrySet()) {
            if(entry.getValue()>(nums.length/3)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}