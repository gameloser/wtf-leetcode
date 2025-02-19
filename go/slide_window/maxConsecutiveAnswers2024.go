package main

import "fmt"

func maxConsecutiveAnswers(answerKey string, k int) int {
	l := 0
	ctT, ctF := 0, 0 // count to fill T/F
	res := 0
	for r, c := range answerKey {
		if c == 'T' {
			ctT++
		} else {
			ctF++
		}
		for ctT > k && ctF > k {
			if answerKey[l] == 'T' {
				ctT--
			} else {
				ctF--
			}
			l++
		}
		res = max(res, r-l+1)
	}
	return res
}

func main() {
	// 4
	fmt.Println(maxConsecutiveAnswers("TTFFF", 2))
	// 3
	fmt.Println(maxConsecutiveAnswers("TFFT", 1))

}
