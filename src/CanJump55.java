import java.util.Arrays;

public class CanJump55 {
    // only can jump on specific point
    /*public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] != -1) continue;
            int j = nums[i] + i;
            if (j >= n) return true;
            dp[j] = -1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1] == -1;
    }*/

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i > max) return false; // ensure max is reachable to i
            max = Math.max(max, i + nums[i]);
        }
        return max >= n - 1;
    }

    public static void main(String[] args) {
        // len = 5
        // nums = [2,3,1,1,4]
        //         0 1 2 3 4?
        //    dp = 0 0 1 1 1
        CanJump55 canJump55 = new CanJump55();
//        System.out.println(canJump55.canJump(new int[]{2,3,1,1,4}));
//        System.out.println(canJump55.canJump(new int[]{3,2,1,0,4}));
//        System.out.println(canJump55.canJump(new int[]{1, 2, 3}));
//        System.out.println(canJump55.canJump(new int[]{2,5,0,0}));
//        System.out.println(canJump55.canJump(new int[]{0,2,3}));
        System.out.println(canJump55.canJump(new int[]{1,0,1,0}));
    }
}
