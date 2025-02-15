package main

import (
	"fmt"
)

func findMedianSortedArrays(a []int, b []int) float64 {
	if len(a) > len(b) {
		a, b = b, a
	}

	m, n := len(a), len(b)
	// 循环不变量：a[l] <= b[j+1]
	// 循环不变量：a[r] > b[j+1]

	fmt.Println(m, n)
	return 0
}

func main() {
	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{2}))
}
