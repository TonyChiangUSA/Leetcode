package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {}

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(val).append("-");
        if (next != null) {
            result.append(next.toString());
        }
        return result.toString();
    }
}
