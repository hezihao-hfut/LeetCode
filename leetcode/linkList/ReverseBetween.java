package leetcode.linkList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        Deque<ListNode> queue = new ArrayDeque<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        ListNode low = dummy;
        ListNode high;
        for (int i = 1;; i++) {
            current = current.next;
            if (i <= left - 1) {
                low = current;
                continue;
            }
            if (i == right + 1) {
                high = current;
                break;
            }
            queue.push(current);
        }
        current = low;
        while (!queue.isEmpty()) {
            current.next = queue.pop();
            current = current.next;
        }
        current.next = high;

        return dummy.next;
    }
    
    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = reverseBetween.reverseBetween(head, 2, 4);
        if (result != null) result.printList();
        else System.out.println("null");

        int[] nums2 = {1, 5};
        ListNode head2 = ListNode.createListNode(nums2);
        ListNode result2 = reverseBetween.reverseBetween(head2, 1, 2);
        if (result2 != null) result2.printList();
        else System.out.println("null");
    }
}
