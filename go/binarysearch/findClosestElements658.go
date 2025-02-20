package main

import "fmt"

// O(n-k)
func findClosestElements(arr []int, k int, x int) []int {
	l, r := 0, len(arr)-1
	// [l, r)
	// [0+1, 1), k=1
	// [l...x...r]
	for l+k <= r {
		if x-arr[l] <= arr[r]-x {
			r--
		} else {
			l++
		}
	}
	return arr[l : r+1]
}

// O(log(n)+k)
func findClosestElements2(arr []int, k int, x int) []int {
	r := LowerBoundOpen(arr, x)
	// r = [0, len(arr)]
	l := r - 1
	// l = [-1, len(arr)-1]
	// l, r = [-1, len(arr)]
	for ; k > 0; k-- {
		if l < 0 {
			r++
		} else if r >= len(arr) {
			l--
		} else if x-arr[l] <= arr[r]-x {
			l--
		} else {
			r++
		}
	}
	// [0, len(arr))
	return arr[l+1 : r]
}

func LowerBoundOpen(arr []int, target int) int {
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
	fmt.Println(findClosestElements2([]int{1, 2, 3, 4, 5}, 4, 3))
	fmt.Println(findClosestElements2([]int{1, 1, 1, 10, 10, 10}, 1, 9))
	fmt.Println(findClosestElements2([]int{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5))
	fmt.Println(findClosestElements2([]int{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2))

	//arr := []int{0, 0, 2, 3, 3, 7, 7, 8}
	//x := 4
	//fmt.Println(sort.SearchInts(arr, x))

}
