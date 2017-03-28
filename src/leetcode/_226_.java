package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * Created by Yang on 2017/3/28.
 */
public class _226_ {
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right =  tmp;
        return root;
    }
}
