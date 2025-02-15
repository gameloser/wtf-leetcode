package main

func findMaxConsecutiveOnes(nums []int) int {
	m := 0
	c := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 1 {
			c++
			m = max(m, c)
		} else {
			c = 0
		}
	}
	return m
}
