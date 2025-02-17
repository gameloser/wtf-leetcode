package main

func findDuplicate2(nums []int) int {
	m := map[int]int{}
	for _, v := range nums {
		if _, ok := m[v]; !ok {
			m[v] = 0
		} else {
			return v
		}
	}
	return -1
}

// fast slow pointer
// 1 -> 3 -> 2 -> 4 -> 2
func findDuplicate(nums []int) int {
	slow, fast := 0, 0
	// init; condition; update
	for slow, fast = nums[slow], nums[nums[fast]]; slow != fast; slow, fast = nums[slow], nums[nums[fast]] {
	}
	slow = 0
	for slow != fast {
		slow = nums[slow]
		fast = nums[fast]
	}
	return slow
}
