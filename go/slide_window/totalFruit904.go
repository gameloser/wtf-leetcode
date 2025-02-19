package main

import "fmt"

// 题意转化：找一个最长连续子数组，满足子数组中至多有两种数字。返回子数组的长度。
func totalFruit(fruits []int) int {
	k := 2
	l := 0
	mp := map[int]int{}
	res := 0
	for r, fruit := range fruits {
		mp[fruit]++
		for len(mp) > k {
			mp[fruits[l]]--
			if mp[fruits[l]] == 0 {
				delete(mp, fruits[l])
			}
			l++
		}
		res = max(res, r-l+1)
	}
	return res
}

func main() {
	fmt.Println(totalFruit([]int{1, 2, 1}))
	fmt.Println(totalFruit([]int{0, 1, 2, 2}))
	fmt.Println(totalFruit([]int{1, 2, 3, 2, 2}))

	//mp := map[int]int{}
	//mp[1] = 1
	//fmt.Println(len(mp))
	//delete(mp, 1)
	//fmt.Println(len(mp))
}
