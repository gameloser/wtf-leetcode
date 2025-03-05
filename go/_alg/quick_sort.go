package main

import (
	"fmt"
	"math/rand"
)

func quickSort(nums []int) []int {
	if len(nums) < 2 {
		return nums
	}
	pos := partition(nums)
	quickSort(nums[:pos])
	quickSort(nums[pos+1:])
	return nums
}

func partitionRandom(nums []int, l, r int) int {
	nr := l + rand.Intn(r-l+1)
	nums[r], nums[nr] = nums[nr], nums[r]
	return partition(nums)
}

func partition(nums []int) int {
	l, r := 0, len(nums)-1
	pivot := nums[r]
	p := l - 1
	for i := l; i <= r; i++ {
		if nums[i] <= pivot {
			p++
			// swap
			nums[p], nums[i] = nums[i], nums[p]
		}
	}
	return p
}

func main() {
	nums := []int{5, 4, 3, 2, 1}
	//fmt.Println(partition(nums, 0, len(nums)-1))
	//fmt.Println(nums)
	quickSort(nums)
	fmt.Println(nums)
}
