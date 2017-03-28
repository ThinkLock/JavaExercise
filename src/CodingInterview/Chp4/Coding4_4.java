package CodingInterview.Chp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2017/3/28.
 */
public class Coding4_4{

    //利用广度优先遍历
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root!=null){
            current.add(root);
        }
        while (current.size()>0){
            result.add(current);
            //保存当前节点，为后续遍历其子节点做准备
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode node : parents){
                if(node.left!=null){
                    current.add(node.left);
                }
                if(node.right!=null){
                    current.add(node.right);
                }
            }
        }

        return result;
    }
}
