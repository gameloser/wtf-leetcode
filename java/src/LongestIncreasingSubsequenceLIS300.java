import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequenceLIS300 {
    /*
    * for 0...i in nums
    * dp[0...j], j <= i; max LIS [0...j]
    * dp[j] = max(dp[j]) + 1
    * */
    /*public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/

    /*// dfs
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(memo, nums, i));
        }
        return res;
    }

    int dfs(int[] memo, int[] nums, int i) {
        // check memo
        if (memo[i] != 0) return memo[i];
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(memo, nums, j));
            }
        }
        memo[i] = res + 1;
        return res + 1;
    }*/

    // greedy + binary
    // f[i]: length of array end element of nums[i]
    // g[i]: length i+1 of IS for the smallest number of end element
    public int lengthOfLIS(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int num: nums) {
            int j = lower_bound_search(g, num);
            if (j == g.size()) {
                g.add(num);
            } else {
                g.set(j, num);
            }
        }
        return g.size();
    }

    public int lower_bound_search(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= target) {
                right = mid - 1;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceLIS300 lis = new LongestIncreasingSubsequenceLIS300();
//        System.out.println(lis.lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9}));

        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
//        System.out.println(lis.lengthOfLIS(new int[]{0}));
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(4);
//        System.out.println(lis.lower_bound_search(nums, 5));
    }
}
