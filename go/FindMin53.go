package main

// 红蓝染色法
func findMin(nums []int) int {
	l := 0
	r := len(nums) - 1 - 1 // out of index mid + 1
	for l <= r {
		mid := l + (r-l)/2
		if nums[mid] > nums[len(nums)-1] {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return nums[l]
}

// binary variation
func findMin2(nums []int) int {
	l := -1
	r := len(nums) - 1
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if nums[mid] < nums[r] {
			r = mid
		} else {
			l = mid
		}
	}
	return nums[r]
}
