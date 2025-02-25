package main

import (
	. "wtf-leetcode/linked_list/def"
)

func reverseList(head *ListNode) *ListNode {
	preNode := &ListNode{}
	backtrack(preNode, head)
	return preNode.Next
}

func backtrack(preNode *ListNode, targetNode *ListNode) {
	if targetNode == nil {
		return
	}
	backtrack(preNode, targetNode.Next)
	preNode.Next = &ListNode{Val: targetNode.Val}
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3}}}
	rel1 := reverseList(l1)
	PrintList(rel1)
}
