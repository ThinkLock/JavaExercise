package campus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class xiaomi3 {

    static int fun(String drinks, int n) {


        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<drinks.length();i++){
            String key = String.valueOf(drinks.charAt(i));
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }

        }

        int all_len = drinks.length();

        int base_time = map.size();
        int res = all_len;

        int min = Integer.MAX_VALUE;
        for(Map.Entry entry : map.entrySet()){
            if((int)entry.getValue() < min){
                min = (int)entry.getValue();
            }
        }

        int sum = 0;
        for(Map.Entry entry : map.entrySet()){
            if((int)entry.getValue() > min){
                sum = sum + ((int)entry.getValue() - min);
            }
        }


        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _drinks;
        try {
            _drinks = in.nextLine();
        } catch (Exception e) {
            _drinks = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = fun(_drinks, _n);
        System.out.println(String.valueOf(res));

    }
}
