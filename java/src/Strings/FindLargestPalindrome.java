package Strings;

public class FindLargestPalindrome {

    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            longest = longest.length() > s1.length() ? longest : s1;
            longest = longest.length() > s2.length() ? longest : s2;
        }
        return longest;
    }

    // find the longest palindrome in s
    public String palindrome(String s, int l, int r) {
        while (l > -1 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--; r++;
            } else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        FindLargestPalindrome f = new FindLargestPalindrome();
        System.out.println(f.palindrome(
                "babad", 0, 1
        ));
        System.out.println(f.longestPalindrome("babad"));
    }
}