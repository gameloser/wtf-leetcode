package main

import (
	. "wtf-leetcode/linked_list/def"
)

func swapPairs(head *ListNode) *ListNode {
	dummyHead := &ListNode{Next: head}
	P0 := dummyHead
	for P0.Next != nil && P0.Next.Next != nil {
		P1 := P0.Next
		P2 := P1.Next
		P0.Next = P2
		P2 = P2.Next
		P0.Next.Next = P1
		P1.Next = P2
		P0 = P0.Next.Next
	}
	return dummyHead.Next
}
