package lintcode;

import java.util.Scanner;

/**
 * Created by Yang on 2017/5/7.
 */
public class MainDD {

    public static int compute(char[] str1, char[] str2)
    {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 从后向前，动态规划计算所有子问题。也可从前到后。
        for (int i = substringLength1 - 1; i >= 0; i--)
        {
            for (int j = substringLength2 - 1; j >= 0; j--)
            {
                if (str1[i] == str2[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
            }
        }

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2)
        {
            if (str1[i] == str2[j])
            {
                //System.out.print(str1[i]);
                i++;
                j++;
            }
            else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        return opt[0][0];
    }

    public static int compute(String str1, String str2)
    {
        return compute(str1.toCharArray(), str2.toCharArray());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dic = sc.nextLine();
        String input = sc.nextLine();
        char[] inputs = input.toCharArray();
        StringBuffer sb = new StringBuffer();
        String in_str = "";
        for(int i=0;i<inputs.length;i++){
            sb.append(getString(inputs[i]));
        }
        in_str = sb.toString();
        String[] dics = dic.split(" ");

        String result = "";
        int maxlen = 0;
        for(String s : dics){
            int len = compute(s,in_str);
            if(len>maxlen){
                maxlen = len;
                result = s;
            }
            System.out.println(s+" " + len);
        }
        System.out.println(in_str);
        System.out.println(result);
    }


    private static String getString(char num){
        String res = "";
        switch (num){
            case '2':
                res = "abc";
                break;
            case '3':
                res = "def";
                break;
            case '4':
                res = "ghi";
                break;
            case '5':
                res = "jkl";
                break;
            case '6':
                res = "mno";
                break;
            case '7':
                res = "pqrs";
                break;
            case '8':
                res = "tuv";
                break;
            case '9':
                res = "wxyz";
                break;
        }
        return res;
    }
}
