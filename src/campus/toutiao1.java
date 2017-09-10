package campus;

import java.util.Scanner;

public class toutiao1 {


    public static void judgenum(int[] res,int[][] matrix,int n,int c,int start,int end){


        for(int i=0;i<c;i++) {
            int line = 0;
            for (int j = start; j <= end ; j ++) {
               line += matrix[j%n][i];
            }
            if(line > 1){
                res[i] = 1;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[n][c];
        sc.nextLine();
        for(int i=0;i<n;i++){
            String input = sc.nextLine();
            String[] item = input.split(" ");
            int len = Integer.valueOf(item[0]);
            for(int j = 1;j<=len;j++){
                matrix[i][Integer.valueOf(item[j]) - 1] = 1;
            }
        }

        int[] res = new int[c];
        for (int i=0;i<n;i++){
            int[] num = new int[c];
            judgenum(num,matrix,n,c,i,(i+m)-1);

            for(int j=0;j<c;j++){
                if(num[j]==1)
                    res[j] = 1;
            }
        }

        int sum_res = 0;
        for (int i=0;i<c;i++){
            sum_res += res[i];
        }
        System.out.print(sum_res);
    }
}
