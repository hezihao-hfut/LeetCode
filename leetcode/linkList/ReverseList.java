package leetcode.linkList;

/**
 * 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseList {
    // 迭代版本
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current =next;
        }
        return pre;
    }

    // 递归版本
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = reverseList.reverseList(head);
        if (result != null) result.printList();
        else System.out.println("null");

        int[] nums2 = {1, 2};
        ListNode head2 = ListNode.createListNode(nums2);
        ListNode result2 = reverseList.reverseList(head2);
        if (result2 != null) result2.printList();
        else System.out.println("null");

    }

}
