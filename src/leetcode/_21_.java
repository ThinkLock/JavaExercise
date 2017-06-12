package leetcode;

/**
 * Created by fengzhaoyang_i on 2017/6/12.
 */
public class _21_ {

    public static ListNode addTwoSortList(ListNode l1,ListNode l2){
        if(l1==null && l2==null) {
            return null;
        }

        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        while (l1!=null && l2!=null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            if(l1.val<= l2.val){
                p.next = l1;
                l1.next = null;
                p=l1;
                l1 = l1_next;
            }else {
                p.next = l2;
                l2.next = null;
                p=l2;
                l2 = l2_next;
            }
        }


        while (l1!=null){
            ListNode l1_next = l1.next;
            p.next = l1;
            l1.next = null;
            p=l1;
            l1 = l1_next;
        }

        while (l2!=null){
            ListNode l2_next = l2.next;
            p.next = l2;
            l2.next = null;
            p=l2;
            l2 = l2_next;
        }

        return l3.next;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode p = head;
        int i = 1;
        while (i<10){
            ListNode item = new ListNode(i);
            p.next = item;
            p = item;
            i = i+2;
        }
        head.printList();


        ListNode head2 = new ListNode(0);
        ListNode p2 = head2;
        int i2 = 2;
        while (i2<10){
            ListNode item2 = new ListNode(i2);
            p2.next = item2;
            p2 = item2;
            i2 = i2+2;
        }
        head2.printList();

        ListNode l3 = addTwoSortList(head,head2);
        l3.printList();
    }
}
