package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * Created by Yang on 2017/3/28.
 */
public class _98_ {
    public static boolean isValidBST(TreeNode root) {

//        if(root==null)
//            return true;
//        if(root.left!=null && root.right!=null &&root.val>root.left.val&&root.val<root.right.val){
//            return isValidBST(root.left)&& isValidBST(root.right);
//        }else if(root.left!=null && root.right==null && root.val>root.left.val){
//            return isValidBST(root.left);
//        }else if(root.left==null && root.right!=null && root.val<root.right.val){
//            return isValidBST(root.right);
//        }else if(root.left==null && root.right==null){
//            return true;
//        }else {
//            return false;
//        }

        return isValid(root,null,null);
    }

    //上述错误方法只是考虑当前节点的大小关系，ac80% ！-！
    public static boolean isValid(TreeNode root,Integer min,Integer max){
        if(root==null)
            return true;
        if(min!=null&&root.val<=min) return false;
        if(max!=null && root.val>=max) return false;

        return isValid(root.left,min,root.val)&& isValid(root.right,root.val,max);
    }
}
