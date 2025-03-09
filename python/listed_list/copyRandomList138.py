from lib.node import *


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        m = dict()
        p = head
        while p:
            m[p] = Node(p.val)
            p = p.next

        p = head
        while p:
            if p.next:
                m[p].next = m[p.next]
            if p.random:
                m[p].random = m[p.random]
            p = p.next
        return m[head]

    def copyRandomList2(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        # dup nodes
        p = head
        while p:
            p1 = Node(p.val, p.next)
            p.next = p1
            p = p.next.next

        # reassign random
        p = head
        while p:
            if p.random:
                p.next.random = p.random.next
            p = p.next.next

        # split odd, even
        p1 = head
        head2 = p2 = p1.next
        while p2 and p2.next:
            p1.next = p2.next
            p1 = p1.next
            p2.next = p1.next
            p2 = p2.next

        return head2

        # # only return even nodes
        # p = head.next
        # while p and p.next:
        #     p.next = p.next.next
        #     p = p.next
        # return head.next


if __name__ == '__main__':
    s = Solution()
    l = Node(1, Node(2, Node(3, Node(4))))
    print_nodes(s.copyRandomList2(l))