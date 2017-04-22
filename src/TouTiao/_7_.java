package TouTiao;

import CodingInterview.Chp4.TreeNode;

/**
 * 7、给定一个数n，查找树中是否有一个路径之后等于n。
 * Created by Yang on 2017/4/23.
 */
public class _7_ {

    /**
     * 判断是否存在一个和为target的路径
     * @param root 当前节点
     * @param sum  累加和
     * @param target 目标值
     * @return 是否
     */
    public static boolean hasSumPath(TreeNode root,int sum,int target){
        if(root==null)
            return false;
        //到达叶子节点，判断是否符合sum与target相等
        if(root.left==null&&root.right==null) {
            if (sum + root.val == target)
                return true;
        }
        //递归判断其左右子树，只要返回一个true就证明有这条路径，所以用||
        return hasSumPath(root.left,sum+root.val,target) || hasSumPath(root.right,sum+root.val,target);
    }

    public static boolean hasPtah(TreeNode root,int target){
        return hasSumPath(root,0,target);
    }
}
