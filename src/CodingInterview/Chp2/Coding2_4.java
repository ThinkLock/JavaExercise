package CodingInterview.Chp2;
public class Coding2_4{

    public static ListNode partition(ListNode head,int x){
        if(head ==null)
            return null;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while(head!=null){
            ListNode next = head.next;
            head.next = null;
            if(head.val<x){
                if(beforeStart==null){
                    beforeStart = head;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            }else{
                if(afterStart == null){
                    afterStart = head;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }

        if(beforeStart == null){
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i=1;i<=10;i++){
            ListNode item;
            if(i<5){
                item = new ListNode(i*3);
            }
            else {
                item = new ListNode(i/2);
            }
            p.next = item;
            p=item;
        }
        LinkedListUtils.printList(head);
        ListNode result = partition(head,5);
        if(result==null){
            System.out.println("error");
        }else{
            LinkedListUtils.printList(result);
        }
    }
}