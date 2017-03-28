package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/27.
 */
public class MainTest {

    public static void main(String[] args){

        //TEST for 4.1
//        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(10);
//        //root.left.left = new TreeNode(2);
//        //root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(12);
//        root.right.left.left = new TreeNode(22);
//        root.printTree();
//        System.out.print(Coding4_1.isBalanced2(root));

        //TEST for 4.3
        int[] a = {1,2,3,4,5,6,7};
        TreeNode root = Coding4_3.createMinialBST(a);
        root.printTree();
    }
}
