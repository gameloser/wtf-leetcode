package main

import (
	"slices"
)

// O(nklogk)
func groupAnagrams(strs []string) [][]string {
	mp := map[string][]string{}
	for _, str := range strs {
		s := []byte(str)
		slices.Sort(s)
		sortedStr := string(s)
		mp[sortedStr] = append(mp[sortedStr], str)
	}
	//return slices.Collect(maps.Values(mp))
	ans := [][]string{}
	for _, str := range mp {
		ans = append(ans, str)
	}
	return ans
}

// O(nkk)
func groupAnagrams2(strs []string) [][]string {
	mp := map[[26]int][]string{}
	for _, str := range strs {
		key := [26]int{}
		for _, c := range str {
			key[c-'a']++
		}
		mp[key] = append(mp[key], str)
	}
	ans := [][]string{}
	for _, str := range mp {
		ans = append(ans, str)
	}
	return ans
}
