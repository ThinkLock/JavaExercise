package lintcode;

import java.util.*;

/**
 * Created by Yang on 2017/4/16.
 */
public class MainSH {

    public static Set convertToSet(String string) {
        Set resultSet = new HashSet();
        for (int i = 0; i < string.length(); i++) {
            resultSet.add(new Character(string.charAt(i)));
        }
        return resultSet;
    }

    public static boolean equals(Set<?> set1, Set<?> set2){
        if(set1 == null || set2 ==null){
            return false;
        }
        if(set1.size()!=set2.size()){
            return false;
        }
        return set1.containsAll(set2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] inputs = in.split(",");

        ArrayList<String> res = new ArrayList<>();

        HashMap<Set,Integer> map  = new HashMap<>();

        for(int i=0;i<inputs.length;i++){
            Set set = convertToSet(inputs[i]);
            if(map.containsKey(set)){
                map.put(set,map.get(set)+1);
            }else {
                map.put(set,1);
            }
        }


        for(int i=0;i<inputs.length;i++){
            Set set = convertToSet(inputs[i]);
            if(map.get(set)>1){
                res.add(inputs[i]);
            }
        }

        for(int i=0;i<res.size();i++){
            if(i<res.size()-1){
                System.out.print(res.get(i)+",");
            }else {
                System.out.print(res.get(i));
            }
        }
    }
}
