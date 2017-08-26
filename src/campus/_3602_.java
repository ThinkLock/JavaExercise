package campus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3602_ {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] a = new int[n];
        String[] sin = s.split(" ");
        for(int i=0;i<n;i++){
            a[i] = Integer.valueOf(sin[i]);
        }

        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = i-1; j>=0;j--) {
                if (a[j] > a[i]) {
                    res[i]++;
                }
            }
        }

        for (int i=0;i<n;i++){
            if(i==n-1){
                System.out.print(res[i]);
            }else {
                System.out.print(res[i] + " ");
            }
        }
    }
}
