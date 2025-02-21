package main

import (
	"fmt"
	"math"
)

// O(m+n)
func findMedianSortedArrays(a []int, b []int) float64 {
	if len(a) > len(b) {
		a, b = b, a
	}
	// i + j = ( m + n + 1 ) / 2
	// a[i] <= b[j+1]
	// a[i+1] > b[j]
	m, n := len(a), len(b)
	a = append([]int{math.MinInt}, append(a, math.MaxInt)...)
	b = append([]int{math.MinInt}, append(b, math.MaxInt)...)

	i, j := 0, (m+n+1)/2
	for {
		if a[i] <= b[j+1] && a[i+1] > b[j] {
			max1 := max(a[i], b[j])
			min2 := min(a[i+1], b[j+1])
			if (m+n)%2 == 0 {
				return float64(max1+min2) / 2
			} else {
				return float64(max1)
			}
		}
		i++
		j--
	}
}

func findMedianSortedArrays2(a []int, b []int) float64 {
	if len(a) > len(b) {
		a, b = b, a
	}
	// i + j = ( m + n + 1 ) / 2
	// a[i] <= b[j+1]
	// a[i+1] > b[j]
	m, n := len(a), len(b)
	a = append([]int{math.MinInt}, append(a, math.MaxInt)...)
	b = append([]int{math.MinInt}, append(b, math.MaxInt)...)

	l, r := 0, m+1
	for l+1 < r {
		i := l + (r-l)/2
		j := (m+n+1)/2 - i
		if a[i] <= b[j+1] {
			l = i
		} else {
			r = i
		}
	}
	// l = r - 1
	i := l
	j := (m+n+1)/2 - i
	max1 := max(a[i], b[j])
	min2 := min(a[i+1], b[j+1])
	if (m+n)%2 == 0 {
		return float64(max1+min2) / 2
	} else {
		return float64(max1)
	}
}

func main() {
	fmt.Println(findMedianSortedArrays2([]int{1, 3}, []int{2}))
	fmt.Println(findMedianSortedArrays2([]int{1, 2}, []int{3, 4}))
}
