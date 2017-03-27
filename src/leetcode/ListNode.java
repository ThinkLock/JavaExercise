package leetcode;
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public void printList(){
        ListNode p = this;
        if(p==null){
            System.out.print("null");
        }
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }

    public void printValue(){
        if(this==null){
            System.out.println("null");
        }else {
            System.out.println(this.val);
        }
    }
}
