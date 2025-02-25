package main

func trap(height []int) int {
	l, r := 0, len(height)-1
	ans := 0
	preMax, sufMax := 0, 0
	for l < r {
		preMax = max(preMax, height[l])
		sufMax = max(sufMax, height[r])
		if height[l] < height[r] {
			ans += preMax - height[l]
			l++
		} else {
			ans += sufMax - height[r]
			r--
		}
	}
	return ans
}
