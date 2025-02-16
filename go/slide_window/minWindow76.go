package main

import "fmt"

func minWindow(s string, t string) string {
	needT := [128]int{}
	windowS := [128]int{}
	kind := 0
	for _, c := range t {
		if needT[c] == 0 {
			kind++
		}
		needT[c]++
	}
	ml, mr := 0, len(s)
	l := 0
	for r, c := range s {
		// r-> only find for needed char make string t
		if needT[c] != 0 {
			windowS[c]++
			if windowS[c] == needT[c] {
				kind--
			}
		}
		// l <- shrink window size for min window contains string t
		for kind == 0 {
			// record max len string
			if r-l < mr-ml {
				ml, mr = l, r
			}
			// remove char from left l
			d := s[l]
			l++
			if needT[d] != 0 {
				if windowS[d] == needT[d] {
					kind++
				}
				windowS[d]--
			}
		}
	}
	// bound case
	if mr-ml == len(s) {
		return ""
	}
	return s[ml : mr+1]
}

func main() {
	fmt.Println(minWindow("ADOBECODEBANC", "ABC"))
	fmt.Println(minWindow("a", "a"))
	fmt.Println(minWindow("ab", "aa"))
}
