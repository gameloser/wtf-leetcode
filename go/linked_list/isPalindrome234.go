package main

import (
	"fmt"
	. "wtf-leetcode/linked_list/def"
)

// O(n) 时间复杂度  O(n) 空间复杂度
func isPalindrome(head *ListNode) bool {
	vals := []int{}
	for ; head != nil; head = head.Next {
		vals = append(vals, head.Val)
	}
	l, r := 0, len(vals)-1
	for l < r {
		if vals[l] != vals[r] {
			return false
		}
		l++
		r--
	}
	return true
}

// 进阶：O(n) 时间复杂度  O(1) 空间复杂度
func isPalindrome2(head *ListNode) bool {
	midNode := middleNode(head)
	//PrintList(midNode)
	head2 := reverseList(midNode)
	//PrintList(head2)
	//PrintList(head)
	for head2 != nil {
		if head.Val != head2.Val {
			return false
		}
		head = head.Next
		head2 = head2.Next
	}
	return true
}

func main() {
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 2, Next: &ListNode{Val: 1}}}}}
	isPara := isPalindrome2(l1)
	fmt.Println(isPara)
}
