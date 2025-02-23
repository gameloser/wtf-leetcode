package main

func isValid(s string) bool {
	mp := map[rune]rune{')': '(', ']': '[', '}': '{'}
	stack := []rune{}
	for _, c := range s {
		if mp[c] == 0 {
			stack = append(stack, c) // left bracket
		} else {
			// no more left bracket to match OR mismatch
			if len(stack) == 0 || stack[len(stack)-1] != mp[c] {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0
}
