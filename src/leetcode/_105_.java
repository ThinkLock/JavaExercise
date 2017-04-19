package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * 根据前序和中序构建二叉树
 * Created by fengzhaoyang_i on 2017/4/19.
 */
public class _105_ {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeWith(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static TreeNode buildTreeWith(int[] preorder,int preleft,int preright,int[] inorder,int inleft,int inright){
        if(preleft>preright || inleft>inright){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preleft]);
        int index = inleft;
        for(;index<=inright;index++){
            if(preorder[preleft] == inorder[index]){
                break;
            }
        }

        int left_len = index-inleft;
        int right_len = inright-index;

        node.left = buildTreeWith(preorder,preleft+1,preleft+left_len,inorder,inleft,index-1);
        node.right = buildTreeWith(preorder,preright-right_len+1,preright,inorder,index+1,inright);

        return node;
    }
}
