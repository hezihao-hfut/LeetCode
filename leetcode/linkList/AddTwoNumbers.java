package leetcode.linkList;

public class AddTwoNumbers {
    
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        int carry = 0;
        while (true) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            p.val = sum % 10;
            if (l1 == null && l2 == null && carry == 0) break;
            p.next = new ListNode();
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);  // 输出: [7,0,8]
        if (result != null) result.printList();
        else System.out.println("null");

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode result2 = addTwoNumbers.addTwoNumbers(l3, l4);  // 输出: [0]
        if (result2 != null) result2.printList();
        else System.out.println("null");

        ListNode l5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result3 = addTwoNumbers.addTwoNumbers(l5, l6);  // 输出: [8,9,9,9,0,0,0,1]
        if (result3 != null) result3.printList();
        else System.out.println("null");
    }
    
}
