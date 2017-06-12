package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fengzhaoyang_i on 2017/6/12.
 */
public class _202_ {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)){
            int suqarSum = 0;
            int remain = 0;
            while (n > 0){
                remain = n%10;
                suqarSum = remain*remain;
                n = n/10;
            }
            if(suqarSum==1){
                return true;
            }else {
                n=suqarSum;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isHappy(19));
    }
}
