package main

import "fmt"

func findPeakGrid(mat [][]int) []int {
	l, r := -1, len(mat)-1
	for l+1 < r {
		mid := l + (r-l)/2
		i := indexOfMax(mat[mid])
		if mat[mid][i] < mat[mid+1][i] {
			l = mid
		} else {
			r = mid
		}
	}
	return []int{r, indexOfMax(mat[r])}
}

//func indexOfMax(arr []int) int {
//	maxIndex := 0
//	for i := 0; i < len(arr); i++ {
//		if arr[i] > arr[maxIndex] {
//			maxIndex = i
//		}
//	}
//	return maxIndex
//}

func indexOfMax(a []int) (idx int) {
	for i, x := range a {
		if x > a[idx] {
			idx = i
		}
	}
	return
}

func main() {
	fmt.Println(findPeakGrid([][]int{{70, 50, 40, 30, 20}, {100, 1, 2, 3, 4}}))
	//fmt.Println(indexOfMax([]int{1, 2, 1, -1, 4}))
}
