package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * Created by Yang on 2017/3/28. 二叉树最小深度
 */
public class _111_ {

    public static int minDepth(TreeNode root){
        if(root==null)
            return 0;

        int leftHeight = 0;
        int rightHetght = 0;

        if(root.left !=null && root.right!=null){
            leftHeight = minDepth(root.left);
            rightHetght = minDepth(root.right);
        }else if(root.right==null){
            leftHeight = minDepth(root.left);
            rightHetght = Integer.MAX_VALUE;
        }else if(root.left==null){
            rightHetght = minDepth(root.right);
            leftHeight = Integer.MAX_VALUE;
        }else {
            return 1;
        }

        return Math.min(leftHeight,rightHetght)+1;
    }
}
