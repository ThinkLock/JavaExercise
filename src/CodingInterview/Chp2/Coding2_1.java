package CodingInterview.Chp2;

import java.util.*;
public class Coding2_1{

  public static void delRepeat(ListNode head){
      Hashtable<Integer,Boolean> table = new Hashtable<>();
      ListNode pre = null;
      while(head!=null){
          if(table.containsKey(head.val)){
              pre.next = head.next;
          }else {
              table.put(head.val,true);
              pre = head;
          }
          head = head.next;
      }
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
      delRepeat(head);
      System.out.println();
      LinkedListUtils.printList(head);
  }
}
