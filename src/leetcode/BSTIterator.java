package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.LinkedList;

/**
 * Created by Yang on 2017/3/28.
 */
public class BSTIterator {

    LinkedList<TreeNode> linkedTree;
    int currentIndex = 0;

    public BSTIterator(TreeNode root){
        linkedTree = new LinkedList<>();
        initLinked(root);
    }

    private void initLinked(TreeNode node){
        if(node==null){
            return;
        }
        initLinked(node.left);
        linkedTree.add(node);
        initLinked(node.right);
    }

    public boolean hasNext(){
        return currentIndex<linkedTree.size();
    }

    public int next(){
        return linkedTree.get(currentIndex++).val;
    }
}
