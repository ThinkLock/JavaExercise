package TouTiao;

import CodingInterview.Chp4.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个完全二叉树，插入一个节点，还是完全二叉树
 * Created by Yang on 2017/4/24.
 */
public class _15_ {

    public static void insertNode(TreeNode root,int val){
        if(root==null)
            return;
        //利用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null && node.right!=null){
                queue.add(node.left);
                queue.add(node.right);
            }
            if(node.left==null){
                node.left = new TreeNode(val);
                return;
            }
            if(node.left!=null && node.right==null){
                node.right = new TreeNode(val);
                return;
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        //root.right.left = new TreeNode(9);
        //root.right.right = new TreeNode(12);
        //root.right.left.left = new TreeNode(22);
        root.printTree();
        System.out.println();
        insertNode(root,9);
        root.printTree();
    }
}
