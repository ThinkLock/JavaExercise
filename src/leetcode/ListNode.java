package leetcode;
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
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
