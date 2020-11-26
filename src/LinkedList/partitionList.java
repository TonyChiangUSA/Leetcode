package LinkedList;

public class partitionList {
    public static ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode dummy1=new ListNode();
        ListNode l1=dummy1;
        ListNode dummy2=new ListNode();
        ListNode l2=dummy2;

        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                l1.next=cur;
                l1=l1.next;
            }else{
                l2.next=cur;
                l2=l2.next;
            }

            cur=cur.next;
        }

        l2.next=null;
        l1.next=dummy2.next;
        return dummy1.next;
    }

    /*
   * Input: head = 1->4->3->2->5->2, x = 3
     Output: 1->2->2->4->3->5
   * */
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        l1.next.next.next=new ListNode(2);
        l1.next.next.next.next=new ListNode(5);
        l1.next.next.next.next.next=new ListNode(2);

       ListNode res = partition(l1,3);

        System.out.println(res.toString());
    }
}
