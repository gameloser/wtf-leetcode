package main

import (
	. "wtf-leetcode/linked_list/def"
)

func removeElements(head *ListNode, val int) *ListNode {
	dummyHead := &ListNode{Next: head}
	P := dummyHead
	for P.Next != nil {
		if P.Next.Val == val {
			P.Next = P.Next.Next
		} else {
			P = P.Next
		}
	}
	return dummyHead.Next
}
