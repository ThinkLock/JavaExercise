package campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainHW5 {




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        List<String> strWithnomul = new ArrayList<>();
        List<Boolean> res = new ArrayList<>();

        while (true){
            String s = sc.next();
            if(s.charAt(s.length()-1) == ',') {
                inputs.add(s.substring(1, s.length() - 2));
            }else {
                inputs.add(s.substring(1, s.length() - 1));
            }
            if(s.charAt(s.length()-1) != ','){
                break;
            }
        }

        HashMap<String,String> hashMap = new HashMap<>();

        for (String s : inputs){
            System.out.println(s);
            String[] item  = s.split(",");
            System.out.println(item.length);
            hashMap.put(item[0],item[1]);
            if(!strWithnomul.contains(item[0])){
                strWithnomul.add(item[0]);
                res.add(false);
            }
            if(!strWithnomul.contains(item[1])){
                strWithnomul.add(item[1]);
                res.add(false);
            }
        }


        for(int i = 0; i<strWithnomul.size();i++){

            String origin = strWithnomul.get(i);
            String temp = strWithnomul.get(i);
            while (hashMap.containsKey(temp)){
                temp = hashMap.get(temp);
//                System.out.println(temp);
                if(origin.equals(temp)){
                    res.set(i,true);
                    break;
                }
            }

        }


        for(int i = 0; i<strWithnomul.size();i++){
            if(i==strWithnomul.size()-1){
                System.out.println("{"+strWithnomul.get(i) + ", " + res.get(i) + "}");
            }else {
                System.out.println("{"+strWithnomul.get(i) + ", " + res.get(i) + "},");
            }
        }
    }
}
