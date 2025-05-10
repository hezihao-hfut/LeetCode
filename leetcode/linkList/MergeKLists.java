package leetcode.linkList;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return (lists[0]);
        return merge(0, lists.length -1, lists);
    }

    private ListNode merge(int left, int right, ListNode[] lists) {
        if (left == right) return lists[left];
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        ListNode l1 = merge(left, mid, lists);
        ListNode l2 = merge(mid + 1, right, lists);
        return mergeTwoLists(l1, l2);
    }

    // 合并两个有序链表（递归版本）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 迭代版本
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 同时遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // 处理剩余节点
        current.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
    
    // 使用优先队列
    public ListNode mergeKLists2(ListNode[] lists) {
        // 处理空数组的情况
        if (lists == null || lists.length == 0) return null;
        
        // 创建优先队列，按照节点值排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 将所有链表的头节点加入队列
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 不断从队列中取出最小节点
        while (!pq.isEmpty()) {
            // 取出当前最小节点
            ListNode minNode = pq.poll();
            
            // 将最小节点加入结果链表
            current.next = minNode;
            current = current.next;
            
            // 如果该节点还有下一个节点，将下一个节点加入队列
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode result = mergeKLists.mergeKLists(lists);
        if (result != null) result.printList();
        else System.out.println("null");

        ListNode[] lists2 = new ListNode[0];
        ListNode result2 = mergeKLists.mergeKLists(lists2);
        if (result2 != null) result2.printList();
        else System.out.println("null");

        ListNode[] lists3 = new ListNode[1];
        lists3[0] = null;
        ListNode result3 = mergeKLists.mergeKLists(lists3);
        if (result3 != null) result3.printList();
        else System.out.println("null");
    }
}
