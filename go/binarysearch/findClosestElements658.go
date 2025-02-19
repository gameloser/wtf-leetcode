package main

import (
	"fmt"
	"math"
)

func findClosestElements(arr []int, k int, x int) []int {
	p := findClosest(arr, x)
	// (l, r)
	l, r := p-1, p+1
	for ; k-1 > 0; k-- {
		// |a - x| < |b - x| 或者
		// |a - x| == |b - x| 且 a < b
		// => |a - x| <= |b - x| 且 a < b
		if r >= len(arr) && l >= 0 {
			l--
			continue
		}
		if l < 0 && r <= len(arr) {
			r++
			continue
		}
		if math.Abs(float64(arr[l]-x)) <= math.Abs(float64(arr[r]-x)) {
			l--
		} else {
			r++
		}
	}
	return arr[l+1 : r]
}

func findClosest(nums []int, target int) int {
	l, r := -1, len(nums)
	for l+1 < r {
		mid := l + (r-l)/2
		if nums[mid] >= nums[mid+1] {
			r = mid
		} else {
			l = mid
		}
	}
	return r
}

func main() {
	//fmt.Println(findClosestElements([]int{1, 2, 3, 4, 5}, 4, 3))
	//fmt.Println(findClosestElements([]int{1, 1, 1, 10, 10, 10}, 1, 9))
	//fmt.Println(findClosestElements([]int{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5))
	fmt.Println(findClosest([]int{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 5))

}
