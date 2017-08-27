package Interview;

import leetcode.ListNode;

/**
 * 两个链表求和
 * Created by Yang on 2017/4/22.
 */
public class _1_ {

    public static ListNode addTwoList(ListNode l1,ListNode l2){
        if(l1==null&&l2==null)
            return null;

        //最后结果
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        //进位
        int carry = 0;
        while (l1!=null || l2!=null){
            //获取 链表1和2的值
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;

            int sum = carry + val1 +val2;
            //构造新的节点
            ListNode item = new ListNode(sum%10);
            carry = sum/10;
            p.next = item;
            p=item;
            if(l1.next!=null)l1= l1.next;
            if(l2.next!=null)l2 = l2.next;
        }

        if(carry>0){
            p.next = new ListNode(carry);
        }

        return  l3.next==null?l3:l3.next;
    }
}
