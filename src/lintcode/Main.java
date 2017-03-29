package lintcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Yang on 2017/3/29.
 */
public class Main {

    public static void main(String[] args) {

        ///第一题 年会选礼物，背包问题
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] values = new int[n];
//        int[] weight = new int[n];
//        for(int i=0;i<n;i++){
//            values[i] = sc.nextInt();
//        }
//        for(int i=0;i<n;i++){
//            weight[i] = sc.nextInt();
//        }
//
//        int m = sc.nextInt();
//
//        System.out.print(values.length + " " + weight.length + " " + m);
//
//        int[][] f = new int[n+1][m+1]; //f[i][j]表示前i个物品能装入容量为j的背包中的最大价值
//        //初始化第一列和第一行
//        for(int i=0;i<f.length;i++){
//            f[i][0] = 0;
//        }
//        for(int i=0;i<f[0].length;i++){
//            f[0][i] = 0;
//        }
//        //通过公式迭代计算
//        for(int i=1;i<f.length;i++){
//            for(int j=1;j<f[0].length;j++){
//                if(weight[i-1]>j)
//                    f[i][j] = f[i-1][j];
//                else{
//                    if(f[i-1][j]<f[i-1][j-weight[i-1]]+values[i-1]){
//                        f[i][j] = f[i-1][j-weight[i-1]]+values[i-1];
//                    }else{
//                        f[i][j] = f[i-1][j];
//                    }
//                    //f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i-1]]+val[i-1]);
//                }
//            }
//        }
//
//        System.out.print(f[n][m]);


        //第二题 爸爸去哪儿，换水果，类似于换零钱问题
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int giftValue = sc.nextInt();
        //System.out.print(str+" " + giftValue);

        String[] in = str.split(",");
        int[] inInt = new int[in.length];
        for(int i=0;i<in.length;i++){
            inInt[i] = Integer.parseInt(in[i]);
        }

        int  min = getMinCount(giftValue,inInt);
        if(min>Integer. MAX_VALUE-giftValue ){ //min 没有另外赋值，则表示零钱不够
            System.out. println( "-1" );
        }else{
            System.out. println( min);
        }

    }

    public static int getMinCount (int k,int c[]){

        //网传方法
//        int a[]=new int[k+1];//保存最近加入的零钱值
//        a [0]=0;
//        for(int x=1;x<k+1;x++){ //要求a[k],先求a[1]~a[k-1]
//            if(x>=c[0]){  //给a[x]附初值
//                a[x]=a[x-c[0]]+1;
//            }else{   //要找零钱比最小零钱值还小，零钱不够
//                a[x]=Integer.MAX_VALUE- k;
//            }
//            for(int i=1;i<c.length;i++){
//                if(x>=c[i]&&(a[x]>a[x-c[i]]+1)){//x-c[i]表示当前值减去coins[]中值，即可由前面那些子问题+1一次得来
//                    a[ x]= a[ x- c[ i]]+1;
//                }
//            }
//        }
//        return a[k];
        int[] dp = new int[k+1];
        int[] coinValue = new int[k+1];
        for(int i = 1; i <= k; i++) {
            int minNum = i;
            int usedMoney = 0;
            for(int j = 0; j < c.length; j++) {
                if(i >= c[j]) {
                    if(dp[i-c[j]] + 1 <= minNum && (i == c[j] || coinValue[i-c[j]]!=0)) {
                        minNum = dp[i-c[j]]+1;
                        usedMoney = c[j];
                    }
                }
            }
            dp[i] = minNum;
            coinValue[i] = usedMoney;
        }

        if(coinValue[k] == 0)
            return -1;
        else
            return dp[k];
    }

}
