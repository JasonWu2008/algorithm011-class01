public class NO2AddTwoNumbers {
    public static void main(String[] args) {

        NO2AddTwoNumbers no2AddTwoNumbers = new NO2AddTwoNumbers();
//        ListNode result = no2AddTwoNumbers.addTwoNumbers(no2AddTwoNumbers.buildNode(new int[]{2, 4, 3}), no2AddTwoNumbers.buildNode(new int[]{5, 6, 4}));
//        ListNode result = no2AddTwoNumbers.addTwoNumbers(no2AddTwoNumbers.buildNode(new int[]{5}), no2AddTwoNumbers.buildNode(new int[]{5}));
        ListNode result = no2AddTwoNumbers.addTwoNumbers(no2AddTwoNumbers.buildNode(new int[]{1}), no2AddTwoNumbers.buildNode(new int[]{9, 9}));
        System.out.println(result.val);
        ListNode next = result.next;
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }

    private ListNode buildNode(int[] nums) {
        ListNode rootNode = new ListNode(nums[0]);
        ListNode[] nodes = new ListNode[nums.length];
        nodes[0] = rootNode;
        for (int i = 1; i < nums.length; i++) {
            nodes[i] = new ListNode(nums[i]);
            nodes[i - 1].next = nodes[i];
        }
        return rootNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val;
        if (getNodeValue(l1) + getNodeValue(l2) < 10) {
            val = getNodeValue(l1) + getNodeValue(l2);
        } else {
            val = getNodeValue(l1) + getNodeValue(l2) - 10;
        }
        boolean newCarryOver = getNodeValue(l1) + getNodeValue(l2) > 9;
        ListNode parent = new ListNode(val);
        addTwoNumbers(parent, newCarryOver, l1.next, l2.next);
        return parent;
    }

    private void addTwoNumbers(ListNode parent, boolean isCarryOver, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && !isCarryOver) {
            return;
        }
        int val;
        int carryOverBit = isCarryOver ? 1 : 0;
        boolean newCarryOver = false;
        if (getNodeValue(l1) + getNodeValue(l2) + carryOverBit < 10) {
            val = getNodeValue(l1) + getNodeValue(l2) + carryOverBit;
        } else {
            val = getNodeValue(l1) + getNodeValue(l2) + carryOverBit - 10;
            newCarryOver = true;
        }
        parent.next = new ListNode(val);
        addTwoNumbers(parent.next, newCarryOver, l1 != null && l1.next != null ? l1.next : null, l2 != null && l2.next != null ? l2.next : null);
    }

    private int getNodeValue(ListNode listNode) {
        return listNode != null ? listNode.val : 0;
    }

    /**
     * Definition for singly-linked list.
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
