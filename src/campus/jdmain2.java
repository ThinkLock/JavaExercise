package campus;

import java.util.Scanner;

public class jdmain2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int strlength = string.length();
        char str[] = new char[strlength];
        for(int i=0;i<strlength;i++)
        {
            str[i] = string.charAt(i);
        }
        int sum = 1;
        int num=0;
        for(int i=0;i<strlength;i++)
        {
            if(str[i]=='(')
            {
                num++;
            }else{
                sum = sum*num;
                num--;
            }
        }
        System.out.println(sum);
    }

}
