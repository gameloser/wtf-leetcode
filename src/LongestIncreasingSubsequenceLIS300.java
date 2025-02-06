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
    // g[i]: length i+1 of IS for the smallest number
    public int lengthOfLIS(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int num: nums) {
            int j = binSearch(g, num);
        }
        return -1;
    }

    public int binSearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else if (nums.get(mid) > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    

    private int lowerBound(List<Integer> g, int target) {
        int left = -1, right = g.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (g.get(mid) < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // 或者 left+1
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceLIS300 lis = new LongestIncreasingSubsequenceLIS300();
//        System.out.println(lis.lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9}));

//        System.out.println(lis.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
//        System.out.println(lis.lengthOfLIS(new int[]{0}));

        System.out.println(lis.lowerBound(Arrays.asList(1,2,3,3,4,10), 8));
    }
}
