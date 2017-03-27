package CodingInterview.Chp2;
public class Coding2_7{

    public static boolean isHui(ListNode head){

        if(head==null){
            return false;
        }
        if(head.next== null){
            return true;
        }

        ListNode revList = reverse(head);
        ListNode p = head;
        ListNode q = revList;
        while(p!=null && q!=null){

            if(p.val!=q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode nHead = null;

        while(head!=null){
            ListNode next = head.next;
            head.next = null;
            if(nHead==null){
                nHead = head;
            }else{
                head.next = nHead;
                nHead = head;
            }
            head = next;
        }

        return nHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.print(isHui(a));
    }
}