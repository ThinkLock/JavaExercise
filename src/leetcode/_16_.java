package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 3Sum Closest
 * Created by Yang on 2017/5/2.
 */
public class _16_ {

    //campus 57 三个数之和等于0
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> item;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            int start = i+1;
            int end = numbers.length-1;
            while (start<end){
                int sum = numbers[i]+numbers[start]+numbers[end];
                if(sum==0){
                    item = new ArrayList<>();
                    item.add(numbers[i]);
                    item.add(numbers[start]);
                    item.add(numbers[end]);
                    if(!res.contains(item)) {
                        res.add(item);
                    }
                }

                if(sum>0){
                    end--;
                }else {
                    start++;
                }
            }
        }
        return res;
    }

    //leetcode 16 3Sum Closest
    public static int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }


    //头条面试题

    /**
     * 一个数组，如果存在一个递增序列，则返回true，其中递增序列位置不一定连续，如[1，-1,3,2,5]，则1 3 5 构成一个递增序列，
     如果一个都不存在的话返回false，如[1，-2,0，-7]
     * @param a 输入数组
     */
    public static boolean hasSeq(int[] a){
        for(int i=0;i<a.length-2;i++){
            int start = i+1;
            int end = a.length-1;
            while (start<end){
                if(a[i]<a[start] && a[start]<a[end]){
                    return true;
                }else {
                    end--;
                }
            }
            start = i+1;
            end = a.length-1;
            while (start<end){
                if(a[i]<a[start] && a[start]<a[end]){
                    return true;
                }else {
                    start++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] a = {-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> res = threeSum(a);
        for(ArrayList<Integer> item : res){
            System.out.println(item);
        }
        int[] b = {1,0,-1,7};
        System.out.println(hasSeq(b));
    }
}
