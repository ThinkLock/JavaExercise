package lintcode;

import java.util.Scanner;

/**
 * Created by Yang on 2017/3/30.
 */
public class MainTouTiao {


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int q = sc.nextInt();
//        int[] A = new int[n];
//        int[] B = new int[n];
//        int[][] query = new int[q][2];
//        for(int i=0;i<n;i++){
//            A[i] = sc.nextInt();
//        }
//        for(int i=0;i<n;i++){
//            B[i] = sc.nextInt();
//        }
//        for(int i=0;i<q;i++){
//            for(int j=0;j<2;j++){
//                query[i][j] = sc.nextInt();
//            }
//        }
//
//        int[] result = new int[q];
//
//        for(int i=0;i<q;i++){
//            int count = 0;
//            for(int j=0;j<n;j++){
//                if(A[j]>=query[i][0]&&B[j]>=query[i][1]){
//                    count ++;
//                }
//            }
//            result[i] = count;
//        }
//
//        for(int a : result){
//            System.out.println(a);
//        }


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        String A = sc.nextLine();
        String B = sc.nextLine();
        String[] qu = new String[q];
        for(int i=0;i<q;i++){
            qu[i] = sc.nextLine();
        }

        //System.out.print(A.length()+" " + B.length() + " " + qu.length);
        int len = A.length();
        for(int i=0;i<q;i++){
            int count = 0;
            for(int j=0;j<len;j=j+2){
                int a = Integer.parseInt(A.substring(j,j+1));
                int b = Integer.parseInt(B.substring(j,j+1));
                String[] qs = qu[i].split(" ");
                if(a>=Integer.parseInt(""+qs[0])&&b>=Integer.parseInt(""+qs[1])){
                    count ++;
                }
            }
            System.out.println(count);
        }

    }


}
