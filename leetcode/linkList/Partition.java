package leetcode.linkList;

/**
 * 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-250);
        dummy.next = head;

        ListNode low = dummy;
        ListNode pre;
        ListNode current;
        while (low.next != null) {
            if (low.val < x && low.next.val >= x) break;
            low = low.next;
        }
        pre = low;
        while (pre.next != null) {
            current = pre.next;
            if (current.val >= x) pre = pre.next;
            else {
                pre.next = current.next;
                current.next = low.next;
                low.next = current;
                low = current;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = partition.partition(head, 3);
        if (result != null) result.printList();
        else System.out.println("null");

        int[] nums2 = {2, 1};
        ListNode head2 = ListNode.createListNode(nums2);
        ListNode result2 = partition.partition(head2, 2);
        if (result2 != null) result2.printList();
        else System.out.println("null");

        int[] nums3 = {1, 2, 3, 4, 5};
        ListNode head3 = ListNode.createListNode(nums3);
        ListNode result3 = partition.partition(head3, 3);
        if (result3 != null) result3.printList();
        else System.out.println("null");

        int[] nums4 = {5,-5,0,-8,3,8,-8,0,-1,3,-8,7,-4,-8,2,5,9,4,-5,-6};
        ListNode head4 = ListNode.createListNode(nums4);
        ListNode result4 = partition.partition(head4, -4);
        if (result4 != null) result4.printList();
        else System.out.println("null");
    }
}
