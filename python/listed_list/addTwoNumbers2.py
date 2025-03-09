from lib.node import *

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        dummy = l3 = ListNode(-1)
        while l1 and l2:
            val = l1.val + l2.val + carry
            carry = val // 10
            val = val % 10
            l3.next = ListNode(val)
            l3 = l3.next
            l1 = l1.next
            l2 = l2.next

        while l1:
            val = l1.val + carry
            carry = val // 10
            val = val % 10
            l3.next = ListNode(val)
            l3 = l3.next
            l1 = l1.next

        while l2:
            val = l2.val + carry
            carry = val // 10
            val = val % 10
            l3.next = ListNode(val)
            l3 = l3.next
            l2 = l2.next

        if carry:
            l3.next = ListNode(carry)

        return dummy.next

    def addTwoNumbers2(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        dummy = l3 = ListNode(-1)
        while l1 or l2 or carry:
            val = 0
            if l1:
                val += l1.val
                l1 = l1.next
            if l2:
                val += l2.val
                l2 = l2.next

            val += carry
            carry = val // 10
            val = val % 10
            l3.next = ListNode(val)
            l3 = l3.next

        return dummy.next

if __name__ == '__main__':
    s = Solution()
    # l1 = ListNode(2, ListNode(4, ListNode(3)))
    # l2 = ListNode(5, ListNode(6, ListNode(4)))

    l1 = ListNode(9, ListNode(9))
    l2 = ListNode(9, ListNode(9, ListNode(9)))
    print_nodes(s.addTwoNumbers2(l1, l2))