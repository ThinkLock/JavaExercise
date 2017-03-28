package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/27.
 */
public class Coding4_1 {

    //此种方法 getHeight被反复调用计算，增加了时间复杂度
    public static boolean isBalanced(TreeNode root){
        //solution 1
        if(root==null)
            return true;
        int diffhei = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(diffhei)>1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    public static int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    //方法2 增加getHeight的工作，如果平衡则返回树高，如果不平衡则返回-1，减少剩余计算；
    public static int checkHeight(TreeNode root){
        if(root==null)
            return 0;

        int leftHeight = checkHeight(root.left);
        if(leftHeight==-1)
            return -1;

        int rightHeight = checkHeight(root.right);
        if(rightHeight==-1)
            return -1;

        int diffHei = leftHeight-rightHeight;
        if(Math.abs(diffHei)>1)
            return -1;
        else
            return Math.max(leftHeight,rightHeight)+1;
    }

    public static boolean isBalanced2(TreeNode root){
        if(checkHeight(root)==-1)
            return false;
        else
            return true;
    }
}
