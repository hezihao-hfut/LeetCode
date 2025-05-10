package leetcode.linkList;

/**
 * 24. 两两交换链表中的节点
 * 
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode nex = cur.next;
        while (cur != null && nex != null) {
            pre.next = nex;
            cur.next = nex.next;
            nex.next = cur;
            pre = cur;
            cur = cur.next;
            if (cur == null) break;
            nex = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = swapPairs.swapPairs(head);
        if (result != null) result.printList();
        else System.out.println("null");

        ListNode head2 = new ListNode(1);
        ListNode result2 = swapPairs.swapPairs(head2);
        if (result2 != null) result2.printList();
        else System.out.println("null");

        ListNode head3 = null;
        ListNode result3 = swapPairs.swapPairs(head3);
        if (result3 != null) result3.printList();
        else System.out.println("null");
    }
}
