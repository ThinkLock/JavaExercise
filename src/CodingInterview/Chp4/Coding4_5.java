package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/30.
 */
public class Coding4_5 {

    public static boolean isBST(TreeNode root){
        return checkBST(root,null,null);
    }


    public static boolean checkBST(TreeNode node,Integer min,Integer max){
        if(node==null)
            return true;

        if(min!=null && node.val<=min) return false;
        if(max!=null && node.val>=max) return false;

        return checkBST(node.left,min,node.val)&&checkBST(node.right,node.val,max);
    }
}
