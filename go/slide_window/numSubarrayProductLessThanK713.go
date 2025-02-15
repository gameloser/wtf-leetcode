package main

import "fmt"

func numSubarrayProductLessThanK(nums []int, k int) int {
	// [l, r]: 以r为区间的右端点
	// (61) 2345 = 2 23 234 + 3 34 345 (r-l+1 = 3-1+1 = 3)
	if k <= 1 {
		return 0
	}
	l := 0
	prod := 1
	ans := 0
	for r, num := range nums {
		prod *= num
		for prod >= k {
			prod /= nums[l]
			l++
		}
		ans += r - l + 1
	}
	return ans
}

func main() {
	fmt.Println(numSubarrayProductLessThanK([]int{10, 5, 2, 6}, 100))
}
