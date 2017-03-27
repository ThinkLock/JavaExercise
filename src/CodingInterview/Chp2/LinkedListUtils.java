package CodingInterview.Chp2;

public class LinkedListUtils{


  public static void printList(ListNode head){
    while(head!=null){
        System.out.print(head.val+" ");
        head= head.next;
    }
    System.out.println();
  }

}
