package main

func findLength(nums1 []int, nums2 []int) int {
	m, n := len(nums1), len(nums2)
	// dp[i][j] for longest common sub-array including i,j
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}
	res := 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if nums1[i-1] == nums2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			}
			res = max(res, dp[i][j])
		}
	}
	return res
}
