package Interview;

/**
 * Created by Yang on 2017/5/14.
 */
public class _28_ {

    /**
     * 二叉树数据结构
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 根据先序和中序输出后序
     * @param preorder 先序
     * @param inorder 中序
     * @return
     */
    public static void getThePostOrder(int[] preorder, int[] inorder) {
        //建树
        TreeNode root = buildTreeWith(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        printPostOrder(root);
    }

    public static void printPostOrder(TreeNode root){
        if(root==null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 辅助建树
     * @param preorder 先序
     * @param preleft 先序起点
     * @param preright 先序终点
     * @param inorder 中序
     * @param inleft 中序起点
     * @param inright 中序终点
     * @return
     */
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

    public static void main(String[] args){
        int[] pre = {1,2,4,3};
        int[] in = {4,2,1,3};
        getThePostOrder(pre,in);
    }

}
