package main

import "fmt"

func intersection(nums1 []int, nums2 []int) []int {
	m := map[int]int{}
	var res []int
	for i := 0; i < len(nums1); i++ {
		m[nums1[i]] = 1
	}
	for i := 0; i < len(nums2); i++ {
		if _, ok := m[nums2[i]]; ok {
			res = append(res, nums2[i])
			delete(m, nums2[i]) // 细节删除
		}
	}
	return res
}

func main() {
	fmt.Println(intersection([]int{1, 2, 2, 3}, []int{1, 2}))
}
