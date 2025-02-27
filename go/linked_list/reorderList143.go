package main

import (
	. "wtf-leetcode/linked_list/def"
)

// merge l2 into l1 one by one node, l1 and l2 one node diff
func mergeList(l1, l2 *ListNode) {
	p1, p2 := l1, l2
	for p1 != nil && p2 != nil {
		p1, p2 = p1.Next, p2.Next
		l1.Next, l1 = l2, p1
		l2.Next, l2 = l1, p2
	}
}

func reorderList(head *ListNode) {
	if head == nil {
		return
	}
	mid := middleNode(head)
	l1, l2 := head, mid.Next
	mid.Next = nil
	l2 = reverseList(l2)
	mergeList(l1, l2)
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 5, Next: nil}}}
	l2 := &ListNode{Val: 2, Next: &ListNode{Val: 4, Next: &ListNode{Val: 6, Next: nil}}}
	p := l1
	mergeList(l1, l2)
	PrintList(p)

	l3 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: nil}}}}}
	reorderList(l3)
	PrintList(l3)
}
