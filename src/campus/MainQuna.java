package campus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Yang on 2017/4/1.
 */
public class MainQuna {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right  = null;
        }
    }

    public static TreeNode buildTreePreOrderInOrder(int[] preOrder,int begin1,int end1,int[] inOrder,int begin2,int end2){
        if(begin1>end1||begin2>end2){
            return null;
        }
        int rootData=preOrder[begin1];
        TreeNode head=new TreeNode(rootData);
        int divider=findIndexInArray(inOrder,rootData,begin2,end2);
        int offSet=divider-begin2-1;
        TreeNode left=buildTreePreOrderInOrder(preOrder,begin1+1,begin1+1+offSet,inOrder,begin2,begin2+offSet);
        TreeNode right=buildTreePreOrderInOrder(preOrder,begin1+offSet+2,end1,inOrder,divider+1,end2);
        head.left=left;
        head.right=right;
        return head;
    }


    public static int findIndexInArray(int[] a,int x,int begin,int end){
        for(int i=begin;i<=end;i++){
            if(a[i]==x)return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for(int i=0;i<n;i++){
            preorder[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            inorder[i] = sc.nextInt();
        }

        TreeNode root = buildTreePreOrderInOrder(preorder,0,n-1,inorder,0,n-1);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null) {
                queue.add(node.right);
            }
        }

        for(int i=0;i<result.size();i++){
            if(i!=result.size()-1){
                System.out.print(result.get(i)+" ");
            }else {
                System.out.print(result.get(i));
            }
        }
    }

}
