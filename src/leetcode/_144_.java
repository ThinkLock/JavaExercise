package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.ArrayList;;
import java.util.List;
/**
 * Created by Yang on 2017/3/28.
 */
public class _144_ {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getProOrder(root,result);
        return result;
    }

    public static void getProOrder(TreeNode node,List<Integer> list){
        if(node==null)
            return ;
        list.add(node.val);
        getProOrder(node.left,list);
        getProOrder(node.right,list);
    }
}
