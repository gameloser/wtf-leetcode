package main

import (
	"fmt"
)

// == x
func BinarySearch(arr []int, target int) int {
	l, r := 0, len(arr)-1
	for l <= r {
		mid := l + (r-l)/2
		if arr[mid] == target {
			return mid
		} else if arr[mid] > target {
			r = mid - 1
		} else if arr[mid] < target {
			l = mid + 1
		}
	}
	return -1
}

// 二分查找大于等于某个数的第一个位置的功能
// >= x
// result range [0, length]
func LeftBoundClose(arr []int, target int) int {
	l, r := 0, len(arr)-1
	for l <= r {
		mid := l + (r-l)/2
		if arr[mid] >= target {
			r = mid - 1
		} else if arr[mid] < target {
			l = mid + 1
		}
	}
	// r + 1 = l
	return l
}

// <= x
// result range [-1, length-1]
func RightBoundClose(arr []int, target int) int {
	l, r := 0, len(arr)-1
	for l <= r {
		mid := l + (r-l)/2
		if arr[mid] > target {
			r = mid - 1
		} else if arr[mid] <= target {
			l = mid + 1
		}
	}
	return r
}

// >= x
// result range [0, length]
func LeftBoundOpen(arr []int, target int) int {
	l := -1
	r := len(arr)
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if arr[mid] >= target {
			r = mid
		} else {
			l = mid
		}
	}
	return r
}

func main() {
	arr := []int{1, 3, 3, 3, 3, 9}
	//res := BinarySearch(arr, 3)
	//fmt.Println(res)
	//res = LeftBoundClose(arr, 3)
	//fmt.Println(res)
	//res = LeftBoundClose(arr, 10)
	//fmt.Println(res)
	//res = RightBoundClose(arr, 8)
	//fmt.Println(res)
	//fmt.Println(sort.SearchInts(arr, 3))
	//fmt.Println(sort.Search(10, func(i int) bool {
	//	return BinarySearch(arr[:i], 0) >= 0
	//}))
	fmt.Println(LeftBoundOpen(arr, 3))
	fmt.Println(LeftBoundOpen(arr, 2))
	fmt.Println(LeftBoundOpen(arr, 10))
	fmt.Println(LeftBoundOpen(arr, 3+1) - 1)

}
