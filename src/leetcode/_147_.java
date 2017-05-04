package leetcode;

/**
 * Insertion Sort List
 * Created by fengzhaoyang_i on 2017/5/4.
 */
public class _147_{

    public static ListNode insertListSort(ListNode head){
        if(head==null||head.next==null)
            return head;

        ListNode res = new ListNode(0);
        ListNode pre = res;
        ListNode current = head;
        while (current!=null){
            pre = res;
            while (pre.next!=null&&pre.next.val<current.val){
                pre = pre.next;
            }
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return res.next;
    }

}
