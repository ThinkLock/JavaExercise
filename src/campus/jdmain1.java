package campus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class jdmain1 {

    public static boolean isnumber(int number)
    {
        List<Integer> nums = new ArrayList<>();
        int remain = number;
        while (remain!=0){
            nums.add(remain%10);
            remain/=10;
        }
        int sum = 0;
        for(int i=0;i<nums.size();i++) sum += nums.get(i);
        if(sum%2==1) return false;
        int target = sum /2 ;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for(int i=0;i<nums.size();++i){
            for(int j=target;j>=nums.get(i);--j){
                dp[j] = dp[j] || dp[j-nums.get(i)];
            }
        }
        return dp[dp.length-1];
    }

    public static int getcount(int start,int end){
        int count = 0;
        for(int i=start;i<=end;i++){
            if(isnumber(i))count++;
        }
        return count;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();

        System.out.print(getcount(start,end));

        in.close();
    }
}
