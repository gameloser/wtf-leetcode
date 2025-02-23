package main

import (
	"fmt"
	"strconv"
	"strings"
)

func restoreIpAddresses(s string) []string {
	res := []string{}
	// start = [0, length]
	var dfs func(track []string, start int)

	dfs = func(track []string, start int) {
		if len(track) == 4 {
			if start == len(s) {
				res = append(res, strings.Join(track, "."))
			}
			return
		}
		for l := 1; l <= 3; l++ {
			if start+l > len(s) {
				return
			}
			if l > 1 && s[start] == '0' {
				return
			}
			str := s[start : start+l]
			if i, _ := strconv.ParseInt(str, 10, 0); i > 255 {
				return
			}
			track = append(track, str)
			dfs(track, start+l)
			track = track[:len(track)-1]
		}
	}
	dfs([]string{}, 0)
	return res
}

func main() {
	fmt.Println(restoreIpAddresses("25525511135"))
}
