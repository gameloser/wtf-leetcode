package main

import (
	. "wtf-leetcode/linked_list/def"
)

func reverseKGroup(head *ListNode, k int) *ListNode {
	n := 0
	curr := head
	for curr != nil {
		n++
		curr = curr.Next
	}
	dummyHead := &ListNode{Next: head}
	p := dummyHead
	prev := p
	curr = p.Next
	for n >= k {
		n -= k
		for i := 1; i <= k; i++ {
			next := curr.Next
			curr.Next = prev
			prev = curr
			curr = next
		}
		// 记录pNext，p=pNext从新开始做reverseBetween92
		pNext := p.Next
		p.Next.Next = curr
		p.Next = prev
		p = pNext
	}
	return dummyHead.Next
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: nil}}}}}
	rel1 := reverseKGroup(l1, 2)
	PrintList(rel1)
}
