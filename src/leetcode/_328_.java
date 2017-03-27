package leetcode;

import leetcode.ListNode;

/**
 * Created by Yang on 2017/3/27.
 */
public class _328_ {
    public static ListNode oddEvenList(ListNode head){
        if(head==null || head.next==null)
            return head;

        ListNode oddl = null;
        ListNode oul = null;
        ListNode oddhead = null;
        ListNode ouhead = null;
        int i=1;
        while (head!=null){
            ListNode next = head.next;
            head.next = null;
            if(i%2==1){
                if(oddl==null){
                    oddl = head;
                    oddhead = oddl;
                }else {
                    oddl.next = head;
                    oddl = head;
                }
            }else {
                if(oul==null){
                    oul = head;
                    ouhead = oul;
                }else {
                    oul.next = head;
                    oul = head;
                }
            }
            head = next;
            i++;
        }

        if(oddl==null)
            return ouhead;
        else {
            oddl.next = ouhead;
            return oddhead;
        }
    }
}
