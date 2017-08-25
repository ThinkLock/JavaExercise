package lintcode;

import java.util.Scanner;


/**
 * 网易2018 数组a  ai插入b最后，然后b逆序
 * 50% 内存
 */
public class MainNetease2 {





    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int[] b = new int[n];

        int index_b = 0;
        int k = n-1;
        boolean flag = true;

        for (int i = n-1; i>=0 ;--i){
            if(flag){
                b[index_b++] = a[i];
            }else {
                b[k--] = a[i];
            }
            flag = !flag;
        }


        for (int i=0;i<n;i++){
            if(i==n-1){
                System.out.print(b[i]);
            }else {
                System.out.print(b[i] + " ");
            }
        }

    }
}
