package leetcode;


import leetcode.ListNode;

/**
 * Created by Yang on 2017/3/27.
 */
public class _206_ {

    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null)
            return head;

        ListNode result = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = null;
            if(result==null){
                result = head;
            }else {
                head.next = result;
                result = head;
            }
            head = next;
        }

        return result;
    }
}
