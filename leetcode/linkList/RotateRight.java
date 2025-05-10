package leetcode.linkList;

/**
 * 61. 旋转链表
 * 
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode p = head;
        int length = 1;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        p.next = head;
        int moveTimes = length - k % length;
        while (moveTimes-- > 1) head = head.next;
        p = head;
        head = head.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = rotateRight.rotateRight(head, 2);
        if (result != null) result.printList();
        else System.out.println("null");

        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode result2 = rotateRight.rotateRight(head2, 4);
        if (result2 != null) result2.printList();
        else System.out.println("null");
    }
}
