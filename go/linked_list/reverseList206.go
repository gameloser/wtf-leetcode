package main

import (
	. "wtf-leetcode/linked_list/def"
)

func reverseList2(head *ListNode) *ListNode {
	// recurse to last node
	if head == nil || head.Next == nil {
		return head
	}
	last := reverseList2(head.Next)
	head.Next.Next = head
	head.Next = nil
	return last
}

func reverseList(head *ListNode) *ListNode {
	//     prev -> 1 -> 2 -> 3 -> nil
	// nil <- 1 <- 2 <- 3
	var prev, curr *ListNode = nil, head
	for curr != nil {
		p := curr
		curr = curr.Next
		p.Next = prev
		prev = p
	}
	return prev
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3}}}
	rel1 := reverseList(l1)
	PrintList(rel1)
}
