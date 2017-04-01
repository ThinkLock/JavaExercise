package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * Created by Yang on 2017/3/30.
 */
public class _114_ {

    public static void flatten(TreeNode root){
        if(root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode p = root;
        while (p.right!=null){
            p = p.right;
        }
        p.right = right;
    }
}
