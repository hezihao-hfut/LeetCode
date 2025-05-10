package leetcode.linkList;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode delPre = new ListNode();
        delPre.next = head;
        while (cur != null) {
            cur = cur.next;
            if (--n < 0) delPre = delPre.next;
        }
        if (delPre.next == head) head = head.next;
        else delPre.next = delPre.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = removeNthFromEnd.removeNthFromEnd(head, n);
        if (result != null) result.printList();
        else System.out.println("null");

        ListNode head2 = new ListNode(1);
        int n2 = 1;
        ListNode result2 = removeNthFromEnd.removeNthFromEnd(head2, n2);
        if (result2 != null) result2.printList();
        else System.out.println("null");

        ListNode head3 = new ListNode(1, new ListNode(2));
        int n3 = 1;
        ListNode result3 = removeNthFromEnd.removeNthFromEnd(head3, n3);
        if (result3 != null) result3.printList();
        else System.out.println("null");

        ListNode head4 = new ListNode(1, new ListNode(2));
        int n4 = 2;
        ListNode result4 = removeNthFromEnd.removeNthFromEnd(head4, n4);
        if (result4 != null) result4.printList();
        else System.out.println("null");
    }
}
