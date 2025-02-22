package main

import (
	"fmt"
	"slices"
	"sort"
)

type User struct {
	Name string
	Age  int
}

func main() {
	// sort int
	numsInt := []int{1, 5, 3, 2}
	sort.Ints(numsInt)
	fmt.Println(numsInt)
	// slices sort
	numsInt = []int{1, 5, 3, 2}
	slices.SortFunc(numsInt, func(a, b int) int {
		return a - b
	})
	fmt.Println(numsInt)
	// reserve
	sort.Sort(sort.Reverse(sort.IntSlice(numsInt)))
	fmt.Println(numsInt)

	// sort string
	numsStr := []string{"e", "f", "a", "b"}
	sort.Strings(numsStr)
	fmt.Println(numsStr)

	// sort custom struct list by Age
	users := []User{
		{Name: "Alice", Age: 30},
		{Name: "Bob", Age: 40},
		{Name: "Eve", Age: 20},
	}
	sort.Slice(users, func(i, j int) bool {
		return users[i].Age < users[j].Age
	})
	fmt.Println(users)

	// sort 2d arr by first value
	arr2d := [][]int{
		{2, 7},
		{3, 5},
		{1, 3},
	}
	sort.Slice(arr2d, func(i, j int) bool {
		return arr2d[i][0] < arr2d[j][0]
	})
	fmt.Println(arr2d)
	arr2d = [][]int{
		{2, 7},
		{3, 5},
		{1, 3},
	}
	slices.SortFunc(arr2d, func(a, b []int) int {
		return a[0] - b[0]
	})
	fmt.Println(arr2d)

	// search
	arr := []int{1, 3, 5, 5, 7, 11, 12, 13}
	// The slice must be sorted in ascending order.
	fmt.Println(sort.SearchInts(arr, 3))
	// find the lower bound: 最左边的(第一个)大于等于x的数
	fmt.Println(sort.SearchInts(arr, 4))
	// Search uses binary search to find and return the smallest index i
	// in [0, n) at which f(i) is true, assuming that on the range [0, n),
	// f(i) == true implies f(i+1) == true.
	fmt.Println(sort.Search(len(arr), func(i int) bool { return arr[i] >= 4 }))

	// return range [0, arr.length] !!!
	fmt.Println(sort.SearchInts(arr, 0))
	fmt.Println(sort.SearchInts(arr, 100))

	// sort string
	str := "overjav"
	s1 := []byte(str)
	slices.Sort(s1)
	sortedStr := string(s1)
	fmt.Println(sortedStr)

	s2 := []byte(str)
	sort.Slice(s2, func(i, j int) bool {
		return s2[i] < s2[j]
	})
	sortedStr2 := string(s2)
	fmt.Println(sortedStr2)
}
