package TouTiao;

import CodingInterview.Chp4.TreeNode;

/**
 * 判断一棵树是不是平衡的
 * Created by Yang on 2017/4/22.
 */
public class _6_ {


    public static boolean isBalanced(TreeNode root){
        if(checkHeight(root)==-1){
            return false;
        }else {
            return true;
        }
    }

    //获取树高，如果是平衡的则返回树高，如果不平衡直接返回-1
    public static int checkHeight(TreeNode node){
        if(node==null)
            return 0;

        int left = checkHeight(node.left);
        if(left==-1){
            return -1;
        }

        int right = checkHeight(node.right);
        if(right==-1){
            return -1;
        }

        if(Math.abs(left-right)>1){
            return -1;
        }else {
            return Math.max(left,right)+1;
        }
    }
}
