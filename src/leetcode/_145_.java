package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历非递归
 * Created by fengzhaoyang_i on 2017/4/19.
 */
public class _145_ {

    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackTemp = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.empty()){
            while (p!=null){
                stack.push(p);
                stackTemp.push(p);
                p = p.right;
            }
            if(!stack.empty()){
                p = stack.pop();
                p = p.left;
            }
        }

        while (!stackTemp.empty()){
            p = stackTemp.pop();
            res.add(p.val);
        }

        return res;
    }

}
