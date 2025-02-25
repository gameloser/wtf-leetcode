package main

import (
	"fmt"
	"math"
)

func mySqrt(x int) int {
	l, r := -1, x+1
	for l+1 < r {
		mid := l + (r-l)/2
		sq := mid * mid
		if sq <= x {
			l = mid
		} else {
			r = mid
		}
	}
	// l + 1 = r
	// left^2 <= x < right^2
	// return l
	return r
}

func main() {
	fmt.Println(math.Sqrt(0), mySqrt(0))
	fmt.Println(math.Sqrt(1), mySqrt(1))
	fmt.Println(math.Sqrt(8), mySqrt(8))
	fmt.Println(math.Sqrt(99), mySqrt(99))
	fmt.Println(math.Sqrt(100), mySqrt(100))

}
