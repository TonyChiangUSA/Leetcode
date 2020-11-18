package LinkedList;

import java.util.Stack;

public class addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode cur = new ListNode(0);
        int carry=0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry==1) {
            int sum=(s1.isEmpty()?0:s1.pop()) + (s2.isEmpty()?0:s2.pop()) +carry;
            cur.val = sum % 10;
            ListNode head = new ListNode(0);
            head.next = cur;
            cur = head;
            carry=sum/10;
        }
        return cur.val == 0 ? cur.next : cur;
    }

    /*
    * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
      Output: 7 -> 8 -> 0 -> 7
    * */
    public static void main(String[] args) {
        ListNode l1=new ListNode(7);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        l1.next.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode res=addTwoNumbers(l1,l2);

        System.out.println(res.toString());
    }
}
