package main

import (
	"fmt"
	"math"
)

func judgeSquareSum(c int) bool {
	// b = sqrt(c-a^2)
	for a := 0; a*a <= c; a++ {
		b := math.Sqrt(float64(c - a*a))
		if b == math.Floor(b) {
			return true
		}
	}
	return false
}

func judgeSquareSum2(c int) bool {
	// a, b [0, sqrt(c)]
	// a <= b <= sqrt(c)
	a, b := 0, int(math.Sqrt(float64(c)))
	for a <= b {
		sum := a*a + b*b
		if sum == c {
			return true
		} else if sum > c {
			b--
		} else {
			a++
		}
	}
	return false
}

func main() {
	fmt.Println(judgeSquareSum2(3))
	fmt.Println(judgeSquareSum2(10))

}
