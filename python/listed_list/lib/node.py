# Definition for singly-linked list.
from typing import Optional
from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


def print_nodes(head: Optional[ListNode]) -> None:
    while head:
        print(head.val, end="->")
        head = head.next
    print(None)