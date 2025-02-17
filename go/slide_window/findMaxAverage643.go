package main

import (
	"fmt"
	"math"
)

func findMaxAverage(nums []int, k int) float64 {
	sum := 0
	sumMax := math.MinInt
	for i, num := range nums {
		// add
		sum += num
		if i < k-1 {
			continue
		}
		// sum
		sumMax = max(sumMax, sum)
		// sub
		sum -= nums[i-k+1]
	}
	return float64(sumMax) / float64(k)
}

func main() {
	fmt.Println(findMaxAverage([]int{1, 12, -5, -6, 50, 3}, 1))
}
