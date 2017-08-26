package campus;

import java.util.*;

/**
 * Created by fengzhaoyang_i on 2017/4/21.
 */
public class MainHW2 {

    public static class Puke{
        public int val;
        public String color;

        public Puke(int val,String col){
            this.val = val;
            this.color = col;
        }
    }

    public static int getTheVal(List<Puke> list){

        HashMap<String,ArrayList<Integer>> res = getTheSameColorandIndex(list);

        if(res.size()==1){
            //同花 或者 同花顺
            for(Map.Entry<String,ArrayList<Integer>> entry : res.entrySet()){
                ArrayList values = entry.getValue();
                for(int i=0;i<values.size()-1;i++){
                    if(((int)values.get(i+1)-(int)values.get(i))!=1){
                        return 4;
                    }
                }
            }
            return 1;
        }

        HashMap<Integer,Integer>  temp = new HashMap<>();

        for(Puke puke : list){
            if(!temp.containsKey(puke.val)){
                temp.put(puke.val,1);
            }else {
                temp.put(puke.val,temp.get(puke.val)+1);
            }
        }

        if(temp.size()==2){
            for(Map.Entry<Integer,Integer> entry : temp.entrySet()){
                if(entry.getValue()==4 || entry.getValue()==1){
                    //四张数字相同
                    return 2;
                }else if(entry.getValue()==2){
                    return 3;
                }
            }

        }

        if(temp.size()==3){
            return 6;
        }

        for(int i=0;i<list.size()-1;i++){
            if(((int)list.get(i+1).val-(int)list.get(i).val)!=1){
                return 5;
            }
        }

        return 7;
    }


    public static HashMap<String,ArrayList<Integer>> getTheSameColorandIndex(List<Puke> list){
        HashMap<String,ArrayList<Integer>> res =new HashMap<>();
        ArrayList<String> colors = new ArrayList<>();
        for(Puke puke : list){
            if(!colors.contains(puke.color)){
                colors.add(puke.color);
                ArrayList<Integer> index = new ArrayList<>();
                index.add(puke.val);
                res.put(puke.color,index);
            }else {
                res.get(puke.color).add(puke.val);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inputs = new String[5];
        for(int i=0;i<5;i++){
            inputs[i] = sc.nextLine();
        }
        List<Puke> pukes = new ArrayList<>();
        for(String s : inputs){
            String[] split_s = s.split(" ");
            Puke item = new Puke(Integer.parseInt(split_s[0]),split_s[1]);
            pukes.add(item);
        }

        System.out.println(getTheVal(pukes));
    }
}
