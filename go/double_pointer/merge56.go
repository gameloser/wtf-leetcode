package main

import (
	"fmt"
	"sort"
)

func merge56(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	res := [][]int{}
	p1, p2 := intervals[0][0], intervals[0][1]
	for i := 1; i < len(intervals); i++ {
		if p2 >= intervals[i][0] {
			p2 = max(p2, intervals[i][1])
		} else {
			res = append(res, []int{p1, p2})
			p1, p2 = intervals[i][0], intervals[i][1]
		}
	}
	res = append(res, []int{p1, p2})
	return res
}

func main() {
	fmt.Println(merge56([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
	fmt.Println(merge56([][]int{{1, 4}, {2, 3}}))
}
