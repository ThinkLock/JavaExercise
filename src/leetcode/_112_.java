package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * 二叉树路径和
 * Created by Yang on 2017/4/11.
 */
public class _112_{

    /**
     * 这个不是root到leaf的解决方法
     */
//    public static boolean hasPathSum(TreeNode root, int sum) {
//        if(root==null)
//            return false;
//        if(root.val==sum){
//            return true;
//        }else if(root.val>sum){
//            return false;
//        }else {
//            return root.left==null?true:hasPathSum(root.left,sum-root.val)
//                    && root.right==null?true:hasPathSum(root.right,sum-root.val);
//        }
//    }

    public static boolean hasPathSum(TreeNode root,int sum){
        if(root==null)
            return false;
        return checkPath(root,0,sum);
    }

    private static boolean checkPath(TreeNode node,int pathsum,int target){
        if(node==null)
            return false;
        if(node.left==null&&node.right==null){
            return (pathsum+node.val)==target;
        }
        //不能是&&因为只要有一个路径的话就可以返回true了s
        return checkPath(node.left, pathsum+node.val, target)
                ||checkPath(node.right, pathsum+node.val, target);
    }
}
