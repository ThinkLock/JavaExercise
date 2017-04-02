package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Yang on 2017/4/1.  进制的转换
 */
public class MainQuna2 {


    public static long getNum(String input){
        long result = 0;
        char[] in = reverse(input).toCharArray();
        for(int i=0;i<in.length;i++){
            int num = (in[i]-'a');
            result = result + num*(long)Math.pow(26.0,i);
        }
        return result;
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> in = new ArrayList<>();
        while (sc.hasNext()) {
            //in.add(sc.nextLine());
            System.out.println(getNum(sc.nextLine()));
        }
    }
}
