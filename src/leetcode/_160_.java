package leetcode;

/**
 * Created by Yang on 2017/3/27.
 */
public class _160_ {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA==null || headB==null){
            return null;
        }
        int countA = 0;
        int countB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (p!=null){
            countA++;
            p = p.next;
        }

        while (q!=null){
            countB++;
            q = q.next;
        }
        ListNode c1 = null;
        p = headA;
        q = headB;
        int i=0;
        if(countA>countB){
            while (i<countA-countB){
                p=p.next;
                i++;
            }
        }else if(countB>countA){
            while (i<countB-countA){
                q=q.next;
                i++;
            }
        }else {
            while (p!=null && q!=null){
                if(p==q){
                    c1 = p;
                    break;
                }
                p=p.next;
                q= q.next;
            }
        }

        return c1;
    }
}
