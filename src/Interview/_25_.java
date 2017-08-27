package Interview;

import CodingInterview.Chp4.TreeNode;

import java.util.Stack;

/**
 * 树的各种非递归遍历
 * Created by Yang on 2017/4/26.
 */
public class _25_ {

    //先序遍历
    public static void pretravel(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
        }
    }


    //中序遍历
    public static void inorderTravel(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.empty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }


    public static void postOrder(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            out.push(node);
            if(node.left!=null){
                stack.push(node.left);
            }

            if(node.right!=null){
                stack.push(node.right);
            }
        }

        while (!out.empty()){
            System.out.println(out.pop().val);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        //root.right.right = new TreeNode(12);
        //root.right.left.left = new TreeNode(22);
        pretravel(root);
        System.out.println();
        inorderTravel(root);
        System.out.println();
        postOrder(root);
    }
}
