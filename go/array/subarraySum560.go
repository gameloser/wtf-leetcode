package main

// prefix + map
func subarraySum(nums []int, k int) int {
	sum := 0
	mp := map[int]int{0: 1}
	ans := 0
	for _, num := range nums {
		sum += num
		ans += mp[sum-k]
		mp[sum]++
	}
	return ans
}
