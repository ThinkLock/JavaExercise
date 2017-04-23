package TouTiao;

/**
 *  给一个矩阵从左上角走到右下角，只能往右或者向下，找出最小的和
 *
 * Created by Yang on 2017/4/23.
 */
public class _13_ {

    //类似于华为笔试第三题 /lintcode/MainHW3,采用动态规划的方法
    public static int getMinWeight(int[][] a,int m,int n){

        int[][] dp = new int[m][n];
        dp[0][0] = a[0][0];
        for (int i=1;i<m;i++)
            dp[i][0]=dp[i-1][0]+a[i][0];
        for (int j=1;j<n;j++)
            dp[0][j]=dp[0][j-1]+a[0][j];

        for (int i=1;i<m;i++)
        {
            for (int j=1;j<n;j++)
            {//上方和左方的较小值加上自己本身的值就是当前能获得的最小值
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+a[i][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        int[][] a = {{1,2,11},{4,5,6},{7,8,9}};
        System.out.println(getMinWeight(a,a.length,a[0].length));
    }
}
