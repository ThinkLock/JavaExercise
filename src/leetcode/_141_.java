package leetcode;

/**
 * Created by fengzhaoyang_i on 2017/4/19.
 */
public class _141_ {

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;

        ListNode slowp = head;
        ListNode fastp = head;

        while (fastp.next!=null && fastp.next.next!=null){
            slowp = slowp.next;
            fastp = fastp.next.next;
            if(fastp==slowp)
                return true;
        }

        return false;
    }
}
