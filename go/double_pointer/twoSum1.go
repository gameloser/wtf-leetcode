package main

func twoSum(nums []int, target int) []int {
	// nums[i] + nums[j] = 9
	// 9 - nums[i]
	mp := map[int]int{}
	for i, val := range nums {
		if j, ok := mp[target-val]; ok {
			return []int{i, j}
		} else {
			mp[val] = i
		}
	}
	return nil
}
