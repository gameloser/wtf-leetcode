from typing import Tuple, Any, Union

from lib.node import *
from python.listed_list.lib.node import ListNode


class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        head2 = self.middleNode(head)
        head = self.sortList(head)
        head2 = self.sortList(head2)
        return self.mergeTwoLists(head, head2)

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        p = dummy
        while list1 and list2:
            if list1.val < list2.val:
                p.next = list1
                list1 = list1.next
            else:
                p.next = list2
                list2 = list2.next
            p = p.next

        if list1:
            p.next = list1

        if list2:
            p.next = list2

        return dummy.next

    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            prev = slow
            fast = fast.next.next
            slow = slow.next
            if not fast or not fast.next:
                prev.next = None # cut prev mid
        return slow


class Solution2:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        length = self.getLength(head)
        dummy = ListNode(-1, head)
        step = 1
        while step < length:
            p = dummy
            p1 = dummy.next
            while p1:
                head1 = p1
                head2 = self.splitList(head1, step)
                # update next p1
                p1 = self.splitList(head2, step)
                head, tail = self.mergeTwoLists(head1, head2)
                # combine head after p node
                p.next = head
                p = tail
            step *= 2
        return dummy.next

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) \
            -> tuple[Optional[ListNode], Optional[ListNode]]:
        p = dummy = ListNode(-1)
        while list1 and list2:
            if list1.val < list2.val:
                p.next = list1
                list1 = list1.next
            else:
                p.next = list2
                list2 = list2.next
            p = p.next

        p.next = list1 or list2
        while p.next:
            p = p.next
        return dummy.next, p


    def getLength(self, head: Optional[ListNode]) -> int:
        length = 0
        p = head
        while p:
            length += 1
            p = p.next
        return length


    def splitList(self, head: Optional[ListNode], size: int) -> Optional[ListNode]:
        p = ListNode(-1, head)
        for i in range(size):
            if not p:
                break
            p = p.next

        if not p:
            return None

        p1 = p.next
        p.next = None
        return p1


if __name__ == '__main__':
    s = Solution2()
    l = ListNode(3, ListNode(2, ListNode(3, ListNode(4, ListNode(1)))))
    print_nodes(s.sortList(l))

    # l1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    # l2 = ListNode(1, ListNode(2))
    # h, t = s.mergeTwoLists(l1, l2)
    # print_nodes(h)
    # print_nodes(t)

    # l = ListNode(3, ListNode(2, ListNode(3, ListNode(4, ListNode(1)))))
    # print_nodes(s.splitList(l, 2))
