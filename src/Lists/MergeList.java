package Lists;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/merge-k-sorted-lists

public class MergeList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                (o1, o2) -> o1.val - o2.val
        );
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        return pre.next;
    }
}

