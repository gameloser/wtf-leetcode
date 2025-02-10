package main

import (
	"fmt"
)

// 2 binary search
func search(nums []int, target int) int {
	i := findLeastIndex(nums)
	n := len(nums)
	l, r := -1, n

	if nums[i] <= target && target <= nums[n-1] { // [i...length-1]
		l = i - 1
	} else { // [0...i-1]
		r = i
	}
	return binarySearchOpen(nums, target, l, r)
}

func findLeastIndex(arr []int) int {
	l := -1
	r := len(arr) - 1
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if arr[mid] < arr[r] {
			r = mid
		} else {
			l = mid
		}
	}
	return r
}

func binarySearchClose(arr []int, target int, l, r int) int {
	for l <= r { // exit when l == r
		mid := l + (r-l)/2
		if arr[mid] > target {
			r = mid - 1
		} else if arr[mid] < target {
			l = mid + 1
		} else {
			return mid
		}
	}
	return -1
}

func binarySearchOpen(arr []int, target int, l, r int) int {
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if arr[mid] > target {
			r = mid
		} else if arr[mid] < target {
			l = mid
		} else {
			return mid
		}
	}
	return -1
}

// 1 binary search
func search2(nums []int, target int) int {
	l, r := -1, len(nums)
	n := len(nums)
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if nums[mid] == target {
			return mid
		}
		if nums[0] <= nums[mid] { //前半段
			if nums[0] <= target && target < nums[mid] { // [0...target...mid)
				r = mid
			} else {
				l = mid
			}
		} else { //后半段
			if nums[mid] < target && target <= nums[n-1] { // (mid...target...n-1]
				l = mid
			} else {
				r = mid
			}
		}
	}
	return -1
}

func main() {
	arr := []int{}
	target := 0
	arr = []int{4, 5, 6, 7, 0, 1, 2}
	target = 0
	fmt.Println(search2(arr, target))
	arr = []int{4, 5, 6, 7, 0, 1, 2}
	target = 3
	fmt.Println(search2(arr, target))
	arr = []int{1, 3}
	target = 3
	fmt.Println(search2(arr, target))
	arr = []int{1}
	target = 1
	fmt.Println(search2(arr, target))
}
