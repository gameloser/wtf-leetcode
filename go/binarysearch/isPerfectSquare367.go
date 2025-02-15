package main

func isPerfectSquare(num int) bool {
	l, r := 1, num
	for l <= r {
		mid := l + (r-l)/2
		sq := mid * mid
		if sq == num {
			return true
		} else if sq < num {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return false
}
