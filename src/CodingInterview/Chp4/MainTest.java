package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/27.
 */
public class MainTest {

    public static void main(String[] args){
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);

        root.printTree();
    }
}
