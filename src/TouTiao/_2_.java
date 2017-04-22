package TouTiao;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的全排列
 * 可以参考链接http://wuchong.me/blog/2014/07/28/permutation-and-combination-realize/
 * Created by Yang on 2017/4/22.
 */
public class _2_ {


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
            swap(array,start,i);
            getAllRange(array,start+1,end,res);
            swap(array,start,i);
        }
    }

    public static void main(String[] args){
        String a = "abc";
        List<String> res   = new ArrayList<>();
        getAllRange(a.toCharArray(),0,a.length()-1,res);
        for(String s : res){
            System.out.println(s);
        }
    }

}
