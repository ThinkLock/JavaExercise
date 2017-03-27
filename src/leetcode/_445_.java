package leetcode;

import java.util.*;

public class _445_{

    public static ListNode addTwoList(ListNode l1,ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1!=null){
            s1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.add(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode p = new ListNode(0);
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()) sum += s1.pop();
            if(!s2.empty()) sum += s2.pop();
            p.val = sum%10;
            ListNode head = new ListNode(sum/10);
            head.next = p;
            p = head;
            sum = sum /10;
        }
        return p.val==0?p.next:p;
    }
}