package main

import (
	. "wtf-leetcode/linked_list/def"
)

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	p1, p2 := l1, l2
	preNode := &ListNode{}
	p := preNode
	carry := 0
	for p1 != nil && p2 != nil {
		curr := (p1.Val + p2.Val + carry) % 10
		carry = (p1.Val + p2.Val + carry) / 10
		p.Next = &ListNode{Val: curr}
		p = p.Next
		p1 = p1.Next
		p2 = p2.Next
	}
	for p1 != nil {
		curr := (p1.Val + carry) % 10
		carry = (p1.Val + carry) / 10
		p.Next = &ListNode{Val: curr}
		p = p.Next
		p1 = p1.Next
	}
	for p2 != nil {
		curr := (p2.Val + carry) % 10
		carry = (p2.Val + carry) / 10
		p.Next = &ListNode{Val: curr}
		p = p.Next
		p2 = p2.Next
	}
	if carry > 0 {
		p.Next = &ListNode{Val: carry}
	}
	return preNode.Next
}

func main() {
	l1 := &ListNode{Val: 2, Next: &ListNode{Val: 4, Next: &ListNode{Val: 3}}}
	l2 := &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4}}}
	PrintList(addTwoNumbers(l1, l2))
}
