package leetcode;

import CodingInterview.Chp4.TreeNode;

import java.util.List;

public class MainTest{

    public static void main(String[] args) {

        //链表测试部分
        {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int i = 1;
        while (i<10){
            ListNode item = new ListNode(i/2);
            p.next = item;
            p = item;
            i++;
        }
        head.printList();
        ListNode result = _147_.insertListSort(head);
        result.printList();
        }
        //树测试部分
        {
//            TreeNode root = new TreeNode(8);
//            root.left = new TreeNode(6);
//            root.right = new TreeNode(10);
//            //root.left.left = new TreeNode(2);
//            //root.left.right = new TreeNode(7);
//            root.right.left = new TreeNode(9);
//            //root.right.right = new TreeNode(12);
//            //root.right.left.left = new TreeNode(22);
//            root.printTree();
//            System.out.println();
//            List<Integer> res = _145_.postorderTraversal(root);
//            for(Integer s : res){
//
//                System.out.println(s);
//            }
        }

        //位操作测试部分
//        {
//            System.out.println(_371_.addBit(2,5));
//            System.out.println(_231_.isPow(5));
//        }



    }
}