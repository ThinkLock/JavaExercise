package leetcode;

import CodingInterview.Chp4.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/3/28.
 */
public class _102_ {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();
        List<Integer> current_value = new ArrayList<>();
        if(root!=null){
            current.add(root);
            current_value.add(root.val);
        }
        while (current.size()>0){
            result.add(current_value);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            current_value = new ArrayList<>();
            for(TreeNode node : parents){
                if(node.left!=null){
                    current.add(node.left);
                    current_value.add(node.left.val);
                }
                if(node.right!=null){
                    current.add(node.right);
                    current_value.add(node.right.val);
                }
            }
        }

        //leetcode 107 反转
        //Collections.reverse(result);
        return result;
    }
}
