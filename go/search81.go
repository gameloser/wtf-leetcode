package main

func search81(nums []int, target int) bool {
	l, r := -1, len(nums)
	n := len(nums)
	for l+1 < r { // exit when l == r
		mid := l + (r-l)/2
		if nums[mid] == target {
			return true
		}
		if nums[l+1] == nums[mid] && nums[mid] == nums[r-1] {
			l++
			r--
		} else if nums[l+1] <= nums[mid] { //前半段
			if nums[l+1] <= target && target < nums[mid] { // [0...target...mid)
				r = mid
			} else {
				l = mid
			}
		} else { //后半段
			if nums[mid] < target && target <= nums[n-1] { // (mid...target...n-1]
				l = mid
			} else {
				r = mid
			}
		}
	}
	return false
}
