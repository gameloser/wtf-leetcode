from lib.node import *

class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        p1 = head1 = head
        p2 = head2 = head.next
        # 保证p1值始终在不为NONE，为了让后续p1.next = head2
        while p2 and p2.next:
            p1.next = p2.next
            p1 = p1.next
            p2.next = p1.next
            p2 = p2.next
        p1.next = head2
        return head1


if __name__ == '__main__':
    s = Solution()
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    print_nodes(s.oddEvenList(l))
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print_nodes(s.oddEvenList(l))
