package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	// i < j < k
	n := len(nums)
	res := [][]int{}
	mp := make(map[[3]int]int, 0)
	for i := 0; i < n-2; i++ {
		j := i + 1
		k := n - 1
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			if sum == 0 {
				set := [3]int{nums[i], nums[j], nums[k]}
				if mp[set] == 0 {
					mp[set] = 1
					res = append(res, []int{nums[i], nums[j], nums[k]})
				}
				j++
				k--
			} else if sum < 0 {
				j++
			} else {
				k--
			}
		}
	}
	return res
}

func threeSum2(nums []int) [][]int {
	sort.Ints(nums)
	// i < j < k
	n := len(nums)
	res := [][]int{}
	for i := 0; i < n-2; i++ {
		j := i + 1
		k := n - 1
		// skip dup i
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[j], nums[k]})
				// skip dup j
				for j++; j < k && nums[j] == nums[j-1]; j++ {
				}
				// skip dup k
				for k--; j < k && nums[k] == nums[k+1]; k-- {
				}
			} else if sum < 0 {
				j++
			} else {
				k--
			}
		}
	}
	return res
}

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}
