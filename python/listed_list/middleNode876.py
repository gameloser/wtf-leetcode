from lib.node import *


# slow fast pointer
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow


if __name__ == '__main__':
    s = Solution()
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(s.middleNode(l).val)
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    print(s.middleNode(l).val)