package Interview;

import CodingInterview.Chp4.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 分层遍历二叉树
 * Created by Yang on 2017/4/23.
 */
public class _12_ {

    public static void levelTravel(TreeNode root){
        if(root==null)
            return;
        //利用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    //另一种要求，将层次遍历作为一个列表输出出来
    //[
    //  [8]
    //  [6,10]
    //  [3,7,9,12]
    // ]
    public static ArrayList<LinkedList<TreeNode>> levelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
        //相当于一个队列，其实就是一个队列
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root!=null){
            //根节点不为空，则放入当前遍历
            current.add(root);
        }
        while (current.size()>0){
            //将前一个结果加入返回结果
            res.add(current);
            //缓存上层的节点，为后续访问他的子节点做准备
            LinkedList<TreeNode> parents = current;
            //清空当前遍历
            current = new LinkedList<>();
            //将上一层的节点的左右子节点加入当前
            for(TreeNode node : parents){
                if(node.left!=null){
                    current.add(node.left);
                }
                if(node.right!=null){
                    current.add(node.right);
                }
            }
        }
        return res;
    }
}
