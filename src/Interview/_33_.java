package Interview;

import java.util.HashMap;

public class _33_ {


    public static void getSumN(int[] a, int n){
        if(a==null || a.length <2){
            return;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<a.length;i++){
            if(map.containsKey(a[i])){
                System.out.print(map.get(a[i]) + " " + i);
                break;
            }else {
                map.put((n-a[i]),i);
            }
        }
    }


    public static void main(String[] args){
        int[] a = {2,3,1,5,7,9};
        int n = 9;
        getSumN(a, n);
    }
}
