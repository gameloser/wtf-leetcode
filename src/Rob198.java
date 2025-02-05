public class Rob198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        //   2,7,9,3, 1
        // 0 2 7 11 11 12
        Rob198 rob = new Rob198();
        System.out.println(rob.rob(new int[]{1,2,3,1}));
        System.out.println(rob.rob(new int[]{ 2,7,9,3, 1}));
    }
}
