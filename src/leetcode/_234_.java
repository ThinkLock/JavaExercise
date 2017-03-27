package leetcode;

import leetcode.ListNode;

import java.util.*;

/**
 * Created by Yang on 2017/3/27.
 */
public class _234_ {

    public static boolean isPalindrome(ListNode node){
        //简单粗暴，反转，然后比较，是否相等
        //另一种做法：利用栈的先进后出 规则，注意list长度的奇偶数区分

        if(node==null)
            return true;
        if(node.next==null)
            return true;
        Stack<ListNode> stack = new Stack<>();
        int count = 0;
        ListNode p =  node;
        while (p!=null){
            count++;
            p = p.next;
        }

        p = node;
        int i=0;
        while (p!=null&&i<count/2){
            stack.add(p);
            p= p.next;
            i++;
        }
        if(count%2==1){
            p=p.next;
        }

        while (p!=null){
            ListNode q = stack.pop();
            if(q.val!=p.val){
                return false;
            }
            p = p.next;
        }

        return true;
    }
}
