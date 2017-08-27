package Interview;

/**
 * 判断两棵树是不是一样
 * Created by Yang on 2017/5/24.
 */
public class _29_ {

    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val){
            this.val =val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isTreeEquals(TreeNode a,TreeNode b){
        if(a==null && b==null)return true;
        if(a==null || b==null)return false;
        if(a.val==b.val){
            return isTreeEquals(a.left,b.left) && isTreeEquals(a.right,b.right);
        }else {
            return false;
        }
    }
}
