package campus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yang on 2017/4/16.
 */
public class MainSH2 {

    public static ArrayList<ArrayList<Integer>> allSplits = new ArrayList<>();

    public static int  split(int sum, int max, int[] data, int index) {
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
            return 1 + split(sum, max-1, data, index);
        } else if (sum > max) {
            data[index] = max;
            return split(sum-max, max, data, index+1) + split(sum, max-1, data, index);
        } else {
            return split(sum, sum, data, index);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int target = sc.nextInt();
        int[] data = new int[target];
        int sum = split(target,9,data,0);
        for(int i=0;i<sum;i++){
            ArrayList<Integer> item = allSplits.get(i);
            if(item.size()==k) {
                for(int j=item.size()-1;j>=0;--j){
                    if(j>0){
                        System.out.print(item.get(j)+" ");
                    }else {
                        System.out.print(item.get(j)+"\n");
                    }
                }
            }
        }
    }
}
