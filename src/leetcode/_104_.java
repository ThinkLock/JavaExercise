package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * Created by Yang on 2017/3/28.
 */
public class _104_ {

    public static int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
