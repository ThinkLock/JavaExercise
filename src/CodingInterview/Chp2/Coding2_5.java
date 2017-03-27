package CodingInterview.Chp2;
public class Coding2_5{

    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if(a==null)
            return b;
        if(b==null)
            return a;
        ListNode c = null;
        ListNode p = c;
        int jinwei = 0;
        while(a!=null&&b!=null){
            ListNode item;
            int result = a.val+b.val+jinwei;
            if(result<10){
                item = new ListNode(result);
                jinwei=0;
            }else{
                jinwei = result/10;
                item = new ListNode(result%10);
            }
            if(c==null){
                c = item;
                p=c;
            }else{
                p.next = item;
                p=item;
            }
            a = a.next;
            b=b.next;
        }
        
        if(jinwei!=0 && a==null && b==null){
            p.next = new ListNode(jinwei);
        }
        
        while(a!=null){
            ListNode item;
            if(a.val+jinwei<10){
               item = new ListNode(a.val+jinwei);
            }else{
                jinwei = (a.val+jinwei)/10;
                item = new ListNode((a.val+jinwei)%10);
            }
             
            p.next = item;
            p=item;
            a=a.next;
        }
        
        while(b!=null){
            ListNode item;
            if(b.val+jinwei<10){
               item = new ListNode(b.val+jinwei);
            }else{
                jinwei = (b.val+jinwei)/10;
                item = new ListNode((b.val+jinwei)%10);
            }
             
            p.next = item;
            p=item;
            b=b.next;
        }
        return c;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode p = a;
        ListNode q = b;
        for(int i=1;i<=2;i++){
            ListNode item;
            item = new ListNode(i);
            
            p.next = item;
            p=item;
        }
        for(int i=1;i<=3;i++){
            ListNode item;
           item = new ListNode(i*2);
            q.next = item;
            q=item;
        }
        LinkedListUtils.printList(a);
        LinkedListUtils.printList(b);
        ListNode result = plusAB(a,b);
        if(result==null){
            System.out.println("error");
        }else{
            LinkedListUtils.printList(result);
        }
    }
}