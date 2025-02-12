package main

func searchMatrix(matrix [][]int, target int) bool {
	// a[11] <=> maxtrix[2][3] -> maxtrix[11/4][11 mod 4]
	// a[5] <=> maxtrix[1][2] -> maxtrix[5/4][5 mod 4]
	// a[i] -> maxtrix[i/n][i mod n], mxn
	m, n := len(matrix), len(matrix[0])
	l, r := 0, m*n-1
	for l <= r {
		mid := l + (r-l)/2
		if target < matrix[mid/n][mid%n] {
			r = mid - 1
		} else if target > matrix[mid/n][mid%n] {
			l = mid + 1
		} else {
			return true
		}
	}
	return false
}

func searchMatrix2(matrix [][]int, target int) bool {
	//m, n := len(matrix), len(matrix[0])
	//l, r := 0, m*n-1
	//row := sort.Search(len(matrix), func(i int) bool { return matrix[i][0] > target }) - 1
	return false
}

func main() {
	searchMatrix([][]int{{1, 2, 4}}, 1)
}
