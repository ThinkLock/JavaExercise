package leetcode;

import CodingInterview.Chp4.TreeNode;

/**
 * Created by Yang on 2017/3/30. 寻找 p q 的公共父节点
 */
public class _236_ {

    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //判断p q是不是root的子节点
        if(!covers(root,p) || !covers(root,q))
            return null;

        return commonAncestorHelper(root,p,q);
    }


    /**
     * 判断p是不是root的子节点
     * @param root
     * @param p
     * @return
     */
    public static boolean covers(TreeNode root,TreeNode p){
        if(root==null)
            return false;
        if(root==p)
            return true;
        return covers(root.left,p) || covers(root.right,p);
    }

    /**
     * 寻找p q的公共父节点
     * 如果 p q 都在root的左子树，那么在其左子树中继续递归查找
     * 如果 p q 都在root的右子树，那么在其右子树中继续递归查找
     * 如果 p q 不在root的同一侧，那么root就是他们的公共父节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode commonAncestorHelper(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;

        boolean isp_on_left = covers(root.left,p);
        boolean isq_on_left = covers(root.left,q);

        if(isp_on_left!=isq_on_left) return root;

        TreeNode child_side = isp_on_left?root.left:root.right;

        return commonAncestorHelper(child_side,p,q);
    }
}
