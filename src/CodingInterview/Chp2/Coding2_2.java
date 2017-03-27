package CodingInterview.Chp2;
public class Coding2_2{

    public static ListNode getKNode(ListNode head,int k){
        if(head==null)
            return null;
        if(k<0)
            return head;
        ListNode pre = head;
        ListNode p = head;
        int i=0;
        while(p!=null && i<k-1){
            p=p.next;
            i++;
        }
        if(p==null){
            return null;
        }
        while(p.next!=null){
            p= p.next;
            pre = pre.next;
        }
        return pre;
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
        ListNode result = getKNode(head,12);
        if(result==null){
            System.out.println("error");
        }else{
            System.out.println(result.val);
        }
    }
}