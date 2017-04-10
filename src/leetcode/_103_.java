package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层次之字形输出
 * Created by Yang on 2017/4/10.
 */
public class _103_ {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;

        travel(root,result,0);
        return result;
    }


    public static void travel(TreeNode node,List<List<Integer>> list,int level){

        if(node==null)
            return ;
        if(list.size()<=level){
            List<Integer> newlevel = new LinkedList<>();
            list.add(newlevel);
        }

        List<Integer> collection = list.get(level);
        if(level%2==0)
            collection.add(node.val);
        else
            collection.add(0,node.val);

        travel(node.left,list,level+1);
        travel(node.right,list,level+1);
    }
}
