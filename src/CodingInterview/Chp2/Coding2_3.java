package CodingInterview.Chp2;
public class Coding2_3{

    public static void delNode(ListNode x){
        if(x==null || x.next==null){
            return ;
        }
        ListNode next = x.next;
        x.val = next.val;
        x.next = next.next;
    
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i=1;i<=10;i++){
            ListNode item;
            if(i<5){
                item = new ListNode(i);
            }
            else {
                item = new ListNode(i/2);
            }
            p.next = item;
            p=item;
        }
        LinkedListUtils.printList(head);
        delNode(head.next);
        LinkedListUtils.printList(head);
     
    }
}