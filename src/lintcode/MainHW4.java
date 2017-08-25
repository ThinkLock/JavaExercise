package lintcode;

import java.util.Scanner;

public class MainHW4 {

    private static boolean isnum(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str_a = scanner.next();
        String str_b = scanner.next();

        boolean allnum = isnum(str_a) && isnum(str_b);

        if(str_a.length() != str_b.length() || !allnum){
            System.out.println(-1);
        }

        int res = 0;
        int num = 0;
        for(int i = 0; i<=str_a.length()-1; i++){
            if(str_a.charAt(i) == str_b.charAt(i)){
                num++;
                if(num>res)
                    res = num;
            }
            else{
                if(num>res)
                    res = num;
                num = 0;
            }
        }

        if(res <= 1){
            System.out.println(0);
        }else {
            System.out.println(res);
        }

    }
}
