package TouTiao;

import java.util.Stack;

/**
 * 数组调整
 * Created by fengzhaoyang_i on 2017/6/1.
 */
public class _32_ {

    private  static void trans(int[] in){
        if(in==null || in.length==0 || in.length==1) return;

        int low = 0;
        int high = in.length-1;

        while (low<high){
            while (low<high && in[high]%2==0) high--;
            while (low<high && in[low]%2==1) low++;
            if(low!=high){
                int temp = in[high];
                in[high] = in[low];
                in[low] = temp;
            }
        }


    }


    public static void mytrans(int[] in){
        if(in==null || in.length==0 || in.length==1) return;
        Stack<Integer> stack = new Stack<>();

        int index = 0;

        for(int i=0;i<in.length;i++){
            if(in[i]%2==1){
                in[index++] = in[i];
            }else {
                stack.push(in[i]);
            }
        }

        int j = in.length-1;
        while (!stack.isEmpty()){
            in[j--] = stack.pop();
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
//        trans(a);
//        for (int item : a) {
//            System.out.println(item);
//        }
        mytrans(a);
        for (int item : a) {
            System.out.println(item);
        }
    }
}
