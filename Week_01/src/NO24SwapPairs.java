public class NO24SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(8);
        new NO24SwapPairs().swapPairs(head);
        System.out.println(head.val);
        ListNode node = head;
        while ((node = node.next) != null) {
            System.out.println(node.val);
        }
    }

    //1->2->3->4 => 2->1->4->3
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int tmpValue=head.val;
        ListNode next=head.next;
        head.val=next.val; //1=>2
        head.next.val=tmpValue;
        next.next=swapPairs(next.next); //2->4 => 1->4
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}