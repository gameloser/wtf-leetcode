from typing import Tuple

from lib.node import *

class Solution:
    # 闭合为环
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 0 or not head or not head.next:
            return head

        length = 0
        p = tail = head
        while p:
            tail = p
            length += 1
            p = p.next

        tail.next = head

        i = length - k % length

        p = head
        for _ in range(i-1):
            p = p.next

        p1 = p.next
        p.next = None

        return p1


if __name__ == '__main__':
    s = Solution()
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print_nodes(s.rotateRight(l, 2))


