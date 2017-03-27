package leetcode;

import leetcode.ListNode;

/**
 * Created by Yang on 2017/3/27.
 */
public class _203_ {

    public static ListNode removeElements(ListNode head, int val){
        if(head==null||(head.next==null&&head.val!=val))
            return head;

        ListNode newHead = null;
        ListNode p = newHead;
        while (head!=null){
            ListNode next = head.next;
            head.next = null;
            if(head.val!=val){
                if(newHead==null){
                    newHead = head;
                    p = newHead;
                }else {
                    p.next = head;
                    p = head;
                }
            }
            head = next;
        }

        return newHead;
    }
}
