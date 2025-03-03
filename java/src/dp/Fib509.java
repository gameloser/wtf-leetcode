package dp;

public class Fib509 {
//    // 1. brute force
//    public int fib(int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }

//    // 2. memo top->down
//    public int fib(int n) {
//        int[] memo = new int[n + 1];
//        return helper(memo, n);
//    }
//
//    public int helper(int[] memo, int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        if (memo[n] != 0) {
//            return memo[n];
//        }
//        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
//        return memo[n];
//    }

//    // 3. dp down->top
//    public int fib(int n) {
//        if (n == 0) return 0;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }

    // 4. dp down->top optimize
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prev = 0, curr = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }

}
