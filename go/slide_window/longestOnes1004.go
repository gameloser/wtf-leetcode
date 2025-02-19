package main

import "fmt"

// notice: 枚举，r填一个0, l删一个0
func longestOnes(nums []int, k int) int {
	l := 0
	c0 := 0 // count 0's
	res := 0
	for r, num := range nums {
		c0 += 1 - num
		for c0 > k {
			c0 -= 1 - nums[l]
			l++
		}
		res = max(res, r-l+1)
	}
	return res
}

func main() {
	// 6
	//fmt.Println(longestOnes([]int{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2))
	// 10
	fmt.Println(longestOnes([]int{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3))
}
