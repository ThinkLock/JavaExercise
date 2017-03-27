package leetcode;

public class MainTest{

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode p = head;
        int i = 1;
        while (i<10){
            ListNode item = new ListNode(i/2);
            p.next = item;
            p = item;
            i++;
        }
        head.printList();
        ListNode result = _203_.removeElements(head,3);
        result.printList();
    }
}