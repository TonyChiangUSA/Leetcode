package LinkedList;

public class removeElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prev=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                cur=cur.next;
                continue;
            }

            prev=cur;
            cur=cur.next;
        }

        return dummy.next;
    }

    /*
   * Input: head = 1->4->3->2->5->2, x = 3
     Output: 1->2->2->4->3->5
   * */
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(6);
        l1.next.next.next=new ListNode(3);
        l1.next.next.next.next=new ListNode(4);
        l1.next.next.next.next.next=new ListNode(5);
        l1.next.next.next.next.next.next=new ListNode(6);

        ListNode res = removeElements(l1,6);

        System.out.println(res.toString());
    }
}
