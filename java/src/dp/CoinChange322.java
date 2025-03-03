package dp;

import java.util.Arrays;

public class CoinChange322 {
//    // brute force
//    public int coinChange(int[] coins, int amount) {
//        // base case
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//
//        int res = Integer.MAX_VALUE;
//        // loop
//        for (int coin : coins) {
//            // sub problem result
//            int count = coinChange(coins, amount - coin);
//            if (count == -1) continue;
//            // state transition
//            res = Math.min(res, count + 1);
//        }
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }


//    // memo top->down
//    public int coinChange(int[] coins, int amount) {
//        int[] memo = new int[amount + 1];
//        Arrays.fill(memo, -6);
//        return helper(memo, coins, amount);
//    }
//
//    public int helper(int[] memo, int[] coins, int amount) {
//        // base case
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//        // check memo
//        if (memo[amount] != -6) return memo[amount];
//
//        int res = Integer.MAX_VALUE;
//        // loop
//        for (int coin : coins) {
//            // sub problem result
//            int count = helper(memo, coins, amount - coin);
//            if (count == -1) continue;
//            // state transition
//            res = Math.min(res, count + 1);
//        }
//        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
//        return memo[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        // init dp
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // [1,2,5] -> 11
        // dp = {0, ..., i=11...}
        for (int i = 1; i <= dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                // state transition
                // min([1,2,5] -> 10, [1,2,5] -> 9, [1,2,5] -> 6]
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
