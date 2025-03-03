package main

import (
	. "wtf-leetcode/linked_list/def"
)

func deleteDuplicates2(head *ListNode) *ListNode {
	dummyHead := &ListNode{Val: -101, Next: head}
	P0 := dummyHead
	for P0.Next != nil && P0.Next.Next != nil {
		// 如果后两个值不相等，P0++
		if P0.Next.Val != P0.Next.Next.Val {
			P0 = P0.Next
			continue
		}
		// 如果后两个值相等, P1++直到值不相等，删掉(P0, P1]之间的节点
		P1 := P0.Next
		for ; P1.Next != nil && P1.Val == P1.Next.Val; P1 = P1.Next {
		}
		P0.Next = P1.Next
	}
	return dummyHead.Next
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 1, Next: &ListNode{Val: 3}}}
	rel1 := deleteDuplicates2(l1)
	PrintList(rel1)
}
