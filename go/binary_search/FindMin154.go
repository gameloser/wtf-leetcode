package main

// lower bound open
func findMin3(nums []int) int {
	l := -1
	r := len(nums) - 1
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if nums[mid] > nums[r] {
			l = mid
		} else if nums[mid] < nums[r] {
			r = mid
		} else {
			r--
		}
	}
	return nums[r]
}
