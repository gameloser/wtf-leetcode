package main

import (
	. "wtf-leetcode/linked_list/def"
)

func detectCycle(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			// walk from head meets at cycle point
			for head != slow {
				head = head.Next
				slow = slow.Next
			}
			return slow
		}
	}
	return nil
}
