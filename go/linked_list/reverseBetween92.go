package main

import (
	. "wtf-leetcode/linked_list/def"
)

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	dummyHead := &ListNode{
		Next: head,
	}
	p := dummyHead
	// p at left-1
	for i := 0; i < left-1; i++ {
		p = p.Next
	}
	prev := p
	curr := p.Next
	for i := left; i <= right; i++ {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	p.Next.Next = curr
	p.Next = prev
	return dummyHead.Next
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: nil}}}}}
	rel1 := reverseBetween(l1, 2, 4)
	PrintList(rel1)

	l2 := &ListNode{Val: 1, Next: nil}
	rel2 := reverseBetween(l2, 1, 1)
	PrintList(rel2)
}
