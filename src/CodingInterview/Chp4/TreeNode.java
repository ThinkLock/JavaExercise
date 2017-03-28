package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/27.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }


    //根据完全层次遍历重建二叉树
//    public TreeNode(char[] a){
//        this.val = Integer.parseInt(""+a[0]);
//
//    }

    //中序遍历这棵树
    public void printTree(){
        if(this!=null){
            if(this.left!=null){
                this.left.printTree();
            }
            System.out.print(this.val+" ");
            if(this.right!=null){
                this.right.printTree();
            }
        }
    }
}
