package lintcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yang on 2017/4/3.
 */
public class MainTencent3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(findcommonroot(k,a,b,c));
    }


    public static int findcommonroot(int k,int a,int b,int c){
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        ArrayList<Integer> cList = new ArrayList<>();

        while (a>0){
            aList.add(a);
            a = a>>1;
        }

        while (b>0){
            bList.add(b);
            b = a>>1;
        }

        while (c>0){
            cList.add(c);
            c = c>>1;
        }

        int commen = 0;
        int aSize = aList.size();
        int bSize = bList.size();
        int cSize = cList.size();
        int i=aSize-1;
        int j = bSize-1;
        int r = cSize-1;
        while (i>=0&&j>=0&&r>=0){
            if(aList.get(i)==bList.get(j) && aList.get(i)==cList.get(r)){
                commen = aList.get(i);
            }
            i--;
            j--;
            r--;
        }

        return commen;
    }
}
