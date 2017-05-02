package TouTiao;

import CodingInterview.Chp2.ListNode;

/**
 * 链表的倒数第k个节点
 * Created by fengzhaoyang_i on 2017/4/24.
 */
public class _17_ {

    //用两个指针，一个先走k-1不，此时p和q相距k个节点，此时如果
    //p不为空，证明k的值没有超过链表总长度，则p和q同时向后移动，
    //当p到达尾部时，q刚好到倒数第k个节点
    public static int getKValue(ListNode head,int k){
        if(head==null || k==0)
            return -1;

        ListNode p = head;
        ListNode q = head;
        int count = 1;
        while (p!=null && count<k){
            p = p.next;
            count++;
        }
        if(p==null){
            return  -1;
        }

        while (p.next!=null){
            p = p.next;
            q = q.next;
        }
        return q.val;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode p = head;
        int i = 2;
        while (i<8){
            ListNode item = new ListNode(i);
            p.next = item;
            p = item;
            i++;
        }

      System.out.print(getKValue(head,5));
    }
}
