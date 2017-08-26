package campus;

import java.util.Scanner;

/**
 * Created by fengzhaoyang_i on 2017/4/21.
 */
public class MainHW3 {



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] gift = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                gift[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[M][N];
        dp[0][0] = gift[0][0];
        for (int i=1;i<M;i++)
            dp[i][0]=dp[i-1][0]+gift[i][0];
        for (int j=1;j<N;j++)
            dp[0][j]=dp[0][j-1]+gift[0][j];

        for (int i=1;i<M;i++)
        {
            for (int j=1;j<N;j++)
            {//上方和左方的较大值加上自己本身的值就是当前能获得的最大值
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+gift[i][j];
            }
        }

        System.out.println(dp[M-1][N-1]);
    }
}
