package def

import "fmt"

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// PrintList Function to print the list in the format "1 -> 2 -> 3 -> nil"
func PrintList(head *ListNode) {
	for current := head; current != nil; current = current.Next {
		fmt.Print(current.Val)
		if current.Next != nil {
			fmt.Print(" -> ")
		}
	}
	fmt.Println(" -> nil")
}
