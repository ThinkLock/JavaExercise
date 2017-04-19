package leetcode;

/**
 * Created by fengzhaoyang_i on 2017/4/19.
 */
public class _2_ {


    public static ListNode addLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;

        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        int carry = 0;
        while (l1!=null || l2!=null){
            int sum = carry;
            sum += l1==null?0:l1.val;
            sum += l2==null?0:l2.val;
            ListNode item = new ListNode(sum%10);
            p.next = item;
            p=item;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(carry>0){
            p.next = new ListNode(carry);
        }

        return l3.next;
    }
}
