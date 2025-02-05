package dp;

public class MinDistance72 {
//    public int minDistance(String word1, String word2) {
//        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
//        return dp(memo, word1, word2, word1.length() - 1, word2.length() - 1);
//    }
    /*
    * dp(i, j) min distance of word1[0...i] to word2[0...j]
    * h o r a e <- i
    *     r s e <- j
    * */
    /*public int dp(int[][] memo, String w1, String w2, int i, int j) {
        // base case
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (memo[i][j] != 0) return memo[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            memo[i][j] = dp(memo, w1, w2, i - 1, j - 1);
        } else {
            // min of
            // insert   dp(i, j - 1)
            // delete   dp(i - 1, j)
            // replace  dp(i - 1, j - 1)
            memo[i][j] = Math.min(
                    Math.min(
                            dp(memo, w1, w2, i, j - 1) + 1,
                            dp(memo, w1, w2, i - 1, j) + 1
                    ),      dp(memo, w1, w2, i - 1, j - 1) + 1
            );
        }
        return memo[i][j];
    }*/


    /*
    * traverse down->top
    * dp(i, j) min distance of word1[0...i-1] to word2[0...j-1]
    *  word1[0...i-1] -> [1...i]
    *  word2[0...j-1] -> [1...j]
    *     | "" h o r a e
    *  "" | 0  1 2 3 4 5
    *   r | 1
    *   s | 2
    *   e | 3
    *
    * "" for base case
    * */
    public int minDistance(String word1, String word2) {
        // init dp
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,
                            dp[i - 1][j] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
