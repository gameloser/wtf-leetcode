from lib.node import *


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        p = None
        p1 = head
        while p1:
            p2 = p1
            p1 = p1.next
            p2.next = p
            p = p2
        return p

if __name__ == '__main__':
    s = Solution()
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print_nodes(s.reverseList(l))
