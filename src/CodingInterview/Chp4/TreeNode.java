package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/27.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }


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
