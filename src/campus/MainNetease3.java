package campus;
import java.util.Scanner;

public class MainNetease3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        int[][] gift = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                gift[i][j] = Math.abs(a[i]-a[j]);
                System.out.print(gift[i][j] + " ");
            }
            System.out.println();
        }

        int[][] dp = new int[n][n];
        dp[0][0] = gift[0][0];
        for (int i=1;i<n;i++)
            dp[i][0]=dp[i-1][0]+gift[i][0];
        for (int j=1;j<n;j++)
            dp[0][j]=dp[0][j-1]+gift[0][j];

        for (int i=1;i<n;i++)
        {
            for (int j=1;j<n;j++)
            {//上方和左方的较大值加上自己本身的值就是当前能获得的最大值

                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + gift[i][j];
            }
        }

        System.out.println();

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {//上方和左方的较大值加上自己本身的值就是当前能获得的最大值

               System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[n-1][n-2]);
    }
}
