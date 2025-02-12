package main

import "fmt"

func minSubArrayLen(target int, nums []int) int {
	l := 0
	n := len(nums)
	sum := 0
	ans := n + 1
	for r := 0; r < n; r++ {
		sum += nums[r]
		for sum >= target {
			ans = min(ans, r-l+1)
			sum -= nums[l]
			l++
		}
	}
	if ans <= n {
		return ans
	} else {
		return 0
	}
}

func main() {
	// 2
	fmt.Println(minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))
}
