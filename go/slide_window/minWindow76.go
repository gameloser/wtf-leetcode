package main

import "fmt"

//func minWindow(s string, t string) string {
//	var cns, cnt [128]int
//	for _, c := range t {
//		cnt[c]++
//	}
//	for r, c := range s {
//		if cnt[c] != 0 {
//			cnt[c]--
//		}
//	}
//}

func main() {
	var cnt [128]int
	cnt[10]--
	fmt.Println(cnt)
}
