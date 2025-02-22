package main

func maxArea(height []int) int {
	l, r := 0, len(height)-1
	ans := 0
	for l < r {
		if height[l] < height[r] {
			ans = max(ans, height[l]*(r-l))
			l++
		} else {
			ans = max(ans, height[r]*(r-l))
			r--
		}
	}
	return ans
}
