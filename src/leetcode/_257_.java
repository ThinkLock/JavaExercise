package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树所有的路径
 * Created by Yang on 2017/4/10.
 */
public class _257_{

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root==null)
            return result;
        String s = "";
        DFS(root,s,result);
        return result;
    }


    public static void DFS(TreeNode node,String path,List<String> result){
        if(node.left==null&& node.right==null) result.add(path+node.val);
        if(node.left!=null)
            DFS(node.left,path+node.val+"->",result);
        if(node.right!=null)
            DFS(node.right,path+node.val+"->",result);
    }
}
