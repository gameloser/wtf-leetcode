from lib.node import *

class Solution:
    def reverseBookList(self, head: Optional[ListNode]) -> List[int]:
        return self.reverseBookList(head.next) + [head.val] if head is not None else []


if __name__ == '__main__':
    s = Solution()
    l = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(s.reverseBookList(l))
