package main

import "fmt"

func searchRange(nums []int, target int) []int {
	start := LowerBound(nums, target)
	if start == len(nums) || nums[start] != target {
		return []int{-1, -1}
	}
	end := LowerBound(nums, target+1) - 1
	return []int{start, end}
}

func LowerBound(arr []int, target int) int {
	l, r := 0, len(arr)-1
	for l <= r {
		mid := (l + r) >> 1
		if arr[mid] >= target {
			r = mid - 1
		} else if arr[mid] < target {
			l = mid + 1
		}
	}
	// r + 1 = l
	return l
}

func main() {
	fmt.Println(searchRange([]int{5, 7, 7, 8, 8, 10}, 8))
}
