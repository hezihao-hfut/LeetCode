package leetcode.linkList;

/**
 * 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        ListNode c = p.next;
        while (c != null && c.next != null) {
            if (c.val == c.next.val) {
                int dup = c.val;
                while (c != null && c.val == dup) {
                    c = c.next;
                }
                p.next = c;
            }
            else {
                p = c;
                c = c.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = deleteDuplicates.deleteDuplicates(head);
        if (result != null) result.printList();
        else System.out.println("null");

        int[] nums2 = {1, 1, 1, 2, 3};
        ListNode head2 = ListNode.createListNode(nums2);
        ListNode result2 = deleteDuplicates.deleteDuplicates(head2);
        if (result2 != null) result2.printList();
        else System.out.println("null");
    }
}
