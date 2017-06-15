package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * ac
 * Created by fengzhaoyang_i on 2017/6/13.
 */
public class _118_ {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        current.add(1);
        int index = 0;
        while (index<numRows){
            res.add(current);
            List<Integer> parent = current;
            current = new LinkedList<>();
            if(parent.size()>=1){
                current.add(1);
                for(int j=0;j<parent.size()-1;j++){
                    current.add(parent.get(j)+parent.get(j+1));
                }
                current.add(1);
            }

            index++;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(generate(9));
    }
}
