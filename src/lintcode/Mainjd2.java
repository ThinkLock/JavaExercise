package lintcode;

import java.util.*;

/**
 * Created by Yang on 2017/4/7.
 */
public class Mainjd2 {

    public static ArrayList<ArrayList<Integer>> allSplits = new ArrayList<>();

    public static int  splitInteger(int sum, int max, int[] data, int index) {
        if (max > sum) max = sum;
        if (sum < 1 || max < 1) return 0;
        if (sum == 1 || max == 1) {
            if (sum == 1) {
                data[index] = sum;
                ArrayList<Integer> item = new ArrayList<>();
                for(int i=0;i<index+1;i++){
                    item.add(data[i]);
                }
                allSplits.add(item);
            } else {
                for (int i = 0; i < sum; i++) {
                    data[index++] = max;
                }
                ArrayList<Integer> item = new ArrayList<>();
                for(int i=0;i<index;i++){
                    item.add(data[i]);
                }
                allSplits.add(item);
            }
            return 1;
        }
        if (sum == max) {
            data[index] = max;
            ArrayList<Integer> item = new ArrayList<>();
            for(int i=0;i<index+1;i++){
                item.add(data[i]);
            }
            allSplits.add(item);
            return 1 + splitInteger(sum, max-1, data, index);
        } else if (sum > max) {
            data[index] = max;
            return splitInteger(sum-max, max, data, index+1) + splitInteger(sum, max-1, data, index);
        } else {
            return splitInteger(sum, sum, data, index);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];
        int sum = splitInteger(n,n,data,0);
        System.out.print(allSplits.size()+" " + sum);
        int result = 0;
        for(int i=0;i<sum;i++){
            ArrayList<Integer> item = allSplits.get(i);
            Set<Integer> set = new HashSet<>(item);
            int max = 0;
            if(item.size()-set.size()<item.size()/2){
                for(int j=0;j<item.size();j++){
                    if(item.get(j)>=k)
                        max++;
                }
            }

            if(max>result){
                result = max;
            }
        }

        System.out.println(result);
    }
}
