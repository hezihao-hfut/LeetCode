package leetcode.linkList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = pre.next;
        while (true) {
            if (deque.size() == k) {
                while (!deque.isEmpty()) {
                    pre.next = deque.pollLast();
                    pre = pre.next;
                }
            }
            if (current == null) break;
            deque.offerLast(current);
            current = current.next;
        }
        if (deque.size() < k) {
            pre.next = deque.pollFirst();
            deque.clear();
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseKGroup solution = new ReverseKGroup();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = ListNode.createListNode(nums);
        ListNode result = solution.reverseKGroup(head, k);
        if (result != null) result.printList();
        else System.out.println("null");

        nums = new int[]{1, 2, 3, 4, 5};
        k = 3;
        head = ListNode.createListNode(nums);
        result = solution.reverseKGroup(head, k);
        if (result != null) result.printList();
        else System.out.println("null");

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 2;
        head = ListNode.createListNode(nums);
        result = solution.reverseKGroup(head, k);
        if (result != null) result.printList();
        else System.out.println("null");

        nums = new int[]{1, 2};
        k = 2;
        head = ListNode.createListNode(nums);
        result = solution.reverseKGroup(head, k);
        if (result != null) result.printList();
        else System.out.println("null");
    }
}
