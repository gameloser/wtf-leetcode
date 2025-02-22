package main

import "fmt"

// map
func longestConsecutive(nums []int) int {
	mp := map[int]bool{}
	for _, num := range nums {
		mp[num] = true
	}
	ans := 0
	for num, _ := range mp {
		if !mp[num-1] {
			tmp := 0
			for i := num; ; i++ {
				if mp[i] {
					tmp++
				} else {
					break
				}
			}
			ans = max(ans, tmp)
		}
	}
	return ans
}

func main() {
	fmt.Println(longestConsecutive([]int{100, 4, 200, 1, 3, 2}))
}
