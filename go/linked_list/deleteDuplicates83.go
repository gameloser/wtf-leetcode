package main

import (
	. "wtf-leetcode/linked_list/def"
)

func deleteDuplicates(head *ListNode) *ListNode {
	dummyHead := &ListNode{Val: -101, Next: head}
	P := dummyHead
	for P.Next != nil {
		if P.Next.Val == P.Val {
			P.Next = P.Next.Next
		} else {
			P = P.Next
		}
	}
	return dummyHead.Next
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 1, Next: &ListNode{Val: 3}}}
	rel1 := deleteDuplicates(l1)
	PrintList(rel1)
}
