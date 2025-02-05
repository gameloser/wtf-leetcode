import java.util.List;

public class LongestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        * 1. dp[i][j] =  max ~ text1[0...i-1] text2[0...j-1]
        * 2. choice
        *    .....x
        *    ...x
        *    1). text1[i] == text2[j], dp[i][j] = dp[i - 1][j - 1] + 1;
        *    .....x
        *    ...y
        *    2). text1[i] != text2[j], case ...x before equals ...y - 1; case ...x -1 before equals ...y;
        *   " a b c d e
        * " 0 0 0 0 0 0
        * a 0 1 0 0 0 0
        * c 0 0 0 0 0 0
        * e 0 0 0 0 0 0
        * max = 3
        *
        * */
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence1143 longestCommonSubsequence = new LongestCommonSubsequence1143();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "def"));
        // 2
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("ezupkr", "ubmrapg"));

    }
}
