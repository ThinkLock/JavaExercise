package lintcode;

import java.util.Scanner;

/**
 * HW 编程1
 * Created by fengzhaoyang_i on 2017/4/21.
 */
public class MainHW {

    public static int Leapyear(int year)
    {
        if (year % 400 == 0 ||(year % 4 == 0 && year % 100 != 0))
            return 1;
        else
            return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] inputs = in.split("-");

        int year, month, day;
        int[] Monthlib= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int i, count;
        year = Integer.parseInt(inputs[0]);
        month = Integer.parseInt(inputs[1]);
        day = Integer.parseInt(inputs[2]);

        int flog=Leapyear(year);
        if((year<=0)||(year>=10000)||(month>12||month<=0)||(day<=0||day>31)||((month%2==0)&&(day==31))||((flog==0)&&(month==2)&&(day>28))){
            System.out.println("invalid input");
            return;
        }

        if (Leapyear(year)==1)
            Monthlib[1] = 29;

        count = day;
        for (i=0; i<month-1; ++i)
            count += Monthlib[i];

        System.out.println(String.format("%d-%d-%d is the No.%d day of %d", year, month,day,count,year));
    }
}
