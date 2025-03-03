import java.util.Arrays;

public class MaxSubArray53 {
//    public int maxSubArray(int[] nums) {
//        // only sum element larger than 0
//        int n = nums.length;
//        int[] dp = new int[n + 1];
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    // simplified
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(max, pre);
        }
        return max;
    }


    public static void main(String[] args) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        // nuns:   -2,1,-3,4,-1,2,1,-5,4
        //   dp: 0 -2 1 -2 4 3  5 6 1 5
        // nums:   5 4 -1 7  8
        //   dp: 0 5 9  8 15 23
        System.out.println(maxSubArray53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray53.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray53.maxSubArray(new int[]{-2,1}));
        System.out.println(maxSubArray53.maxSubArray(new int[]{1}));

    }
}
