package campus;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 网易2018校招 编程题1
 * 彩色砖块
 * ABAB
 */
public class MainNetease {


    //数组交换元素
    public static void swap(char[] a,int m,int n){
        if(m!=n){
            char temp = a[m];
            a[m] = a[n];
            a[n] = temp;
        }
    }
    //递归得到全排列
    public static void getAllRange(char[] array,int start,int end,List<String> res){
        if(end<=1)
            return;
        if(start==end){
            res.add(String.copyValueOf(array));
            return;
        }
        for(int i=start;i<=end;i++){
            if(isSwap(array,start,i)) {
                swap(array, start, i);
                getAllRange(array, start + 1, end, res);
                swap(array, start, i);
            }
        }
    }


    public static boolean isSwap(char[] array,int start,int end){
        for (int i=start;i<end;i++){
            if(array[i] == array[end])
                return false;
        }
        return true;
    }

    //list 去重
    public static void removeDup(List<String> in){
        HashSet<String> h = new HashSet<>(in);
        in.clear();
        in.addAll(h);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dic = sc.nextLine();
        List<String> res   = new ArrayList<>();
        getAllRange(dic.toCharArray(),0,dic.length()-1,res);
//        removeDup(res);
        for (String s : res){
            System.out.println(s);
        }

        int result = 0;
        for(String s : res){
            char[] items = s.toCharArray();
            int count = 0;
            for(int i = 0; i<items.length-1 ;++i){
                if(items[i] != items[i+1]){
                    count++;
                }
            }

            if(count<=1){
                result++;
            }
        }

        System.out.println(result);
    }
}
