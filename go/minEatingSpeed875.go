package main

import (
	"fmt"
)

func minEatingSpeed(piles []int, h int) int {
	// max speed
	maxSpeed := 0
	for i := 0; i < len(piles); i++ {
		if piles[i] > maxSpeed {
			maxSpeed = piles[i]
		}
	}

	computeTime := func(piles []int, speed int) int {
		// ceil(pile / speed) <=> floor((pile + speed - 1)/speed) <=> floor((pile - 1)/speed) + 1
		sum := 0
		for i := 0; i < len(piles); i++ {
			sum += (piles[i] + speed - 1) / speed
		}
		return sum
	}

	l, r := 1, maxSpeed
	for l <= r {
		mid := l + (r-l)/2
		hour := computeTime(piles, mid)
		if hour <= h {
			r = mid - 1
		} else if hour > h {
			l = mid + 1
		}
	}

	return l
}

func main() {
	// [3,6,7,11]
	arr := []int{3, 6, 7, 11}
	fmt.Println(minEatingSpeed(arr, 8))

	arr = []int{30, 11, 23, 4, 20}
	fmt.Println(minEatingSpeed(arr, 5))

	arr = []int{30, 11, 23, 4, 20}
	fmt.Println(minEatingSpeed(arr, 6))
}
