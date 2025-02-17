package main

import "fmt"

func maxVowels(s string, k int) int {
	res := 0
	ct := 0
	isVowel := func(c int) bool {
		if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
			return true
		}
		return false
	}
	for i, c := range s {
		if isVowel(int(c)) {
			ct++
		}
		if i >= k {
			if isVowel(int(s[i-k])) {
				ct--
			}
		}
		res = max(res, ct)
	}
	return res
}

func main() {
	fmt.Println(maxVowels("abciiidef", 3))
}
