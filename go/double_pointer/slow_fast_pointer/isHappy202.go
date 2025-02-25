package main

import "fmt"

func isHappy(n int) bool {
	mp := map[int]bool{}
	for i := sumOfSq(n); !mp[i]; i = sumOfSq(i) {
		mp[i] = true
		if mp[1] {
			return true
		}
	}
	return false
}

func sumOfSq(n int) int {
	sum := 0
	num := n
	for num > 0 {
		sum += (num % 10) * (num % 10)
		num /= 10
	}
	return sum
}

func isHappy2(n int) bool {
	slow, fast := n, n
	do := func() {
		slow = sumOfSq(slow)
		fast = sumOfSq(fast)
		fast = sumOfSq(fast)
	}
	for do(); slow != fast; do() {
	}
	return slow == 1
}

func main() {
	fmt.Println(isHappy2(10))
	fmt.Println(isHappy2(101))

}
