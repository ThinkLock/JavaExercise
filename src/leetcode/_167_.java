package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum II - Input array is sorted
 * Created by Yang on 2017/5/2.
 */
public class _167_ {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i+1;
                result[0] = map.get(target - numbers[i])+1;
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
