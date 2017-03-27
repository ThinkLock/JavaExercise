package CodingInterview.Chp2;
import java.util.*;
public class Coding2_6{

    public static ListNode getNodeOfCircle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }

        if(fast==null || fast.next==null){
            return null;
        }

        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = e;
        //LinkedListUtils.printList(a);
        ListNode ss = getNodeOfCircle(a);
        if(ss!=null){
            System.out.print(ss.val);
        }else{
            System.out.print("error");
        }
       
        
    }
}