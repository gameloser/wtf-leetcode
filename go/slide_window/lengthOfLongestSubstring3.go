package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	l := 0
	m := map[int]int{}
	res := 0
	for r, c := range s {
		m[int(c)]++
		for m[int(c)] > 1 {
			m[int(s[l])]--
			l++
		}
		res = max(res, r-l+1)
	}
	return res
}

func lengthOfLongestSubstring2(s string) int {
	l := 0
	m := [128]int{}
	res := 0
	for r, c := range s {
		m[c]++
		for m[c] > 1 {
			m[s[l]]--
			l++
		}
		res = max(res, r-l+1)
	}
	return res
}

func main() {

	// 2
	//fmt.Println(lengthOfLongestSubstring("aab"))
	// 3
	//fmt.Println(lengthOfLongestSubstring("abcabcbb"))
	// 3
	fmt.Println(lengthOfLongestSubstring2("pwwkew"))
}
