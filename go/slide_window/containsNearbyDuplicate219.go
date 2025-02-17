package main

import "fmt"

func containsNearbyDuplicate(nums []int, k int) bool {
	mp := map[int]int{}
	for i, num := range nums {
		if _, ok := mp[num]; ok {
			return true
		}
		mp[num] = 1
		if i >= k {
			// i - j <= k
			// j >= i - k
			delete(mp, nums[i-k])
		}
	}
	return false
}

func main() {
	fmt.Println(containsNearbyDuplicate([]int{1, 2, 3, 1}, 3))
}
