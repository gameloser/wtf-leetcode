package main

func findPeakElement(nums []int) int {
	l := 0
	r := len(nums) - 1 - 1 // out of index mid + 1
	for l <= r {
		mid := l + (r-l)/2
		if nums[mid] < nums[mid+1] {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return l
}
