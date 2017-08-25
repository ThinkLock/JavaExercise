package lintcode;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MainALLI {

    public static int leftBottle;
    public static int leftTop;

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int maxMount(int price, int cap, int emptyBottle, int money) {
        int bottle = money / price;
        int top = money / price;

        return (money / price) +  drink(bottle,cap,emptyBottle,top);
    }


    static int drink(int bottle, int cap, int emptyBottle, int top){

        if(bottle >= emptyBottle || top >= cap){
            leftBottle = (bottle / emptyBottle) + (bottle % emptyBottle) + (top / cap);
            leftTop = (top / cap) + (top % cap) + (bottle / 2);
            return (bottle / emptyBottle) + (top / cap) + drink(leftBottle,cap,emptyBottle,leftTop);
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _price;
        _price = Integer.parseInt(in.nextLine().trim());

        int _cap;
        _cap = Integer.parseInt(in.nextLine().trim());

        int _emptyBottle;
        _emptyBottle = Integer.parseInt(in.nextLine().trim());

        int _money;
        _money = Integer.parseInt(in.nextLine().trim());

        res = maxMount(_price, _cap, _emptyBottle, _money);
        System.out.println(String.valueOf(res));

    }
}