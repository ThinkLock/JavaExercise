package leetcode;

import leetcode.ListNode;

/**
 * Created by Yang on 2017/3/27.
 */
public class _237_ {

    public static void delNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
