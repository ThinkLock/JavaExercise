package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/3/30. 二叉树的中序遍历
 */
public class _94_ {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        getInorder(root,result);
        return result;
    }

    public static void getInorder(TreeNode node,List<Integer> list) {
        if (node == null)
            return;

        if(node.left!=null)
            getInorder(node.left,list);

        list.add(node.val);

        if(node.right!=null)
            getInorder(node.right,list);
    }
}
