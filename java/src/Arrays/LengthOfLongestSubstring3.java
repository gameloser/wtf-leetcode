package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char cr = s.charAt(right);
            right++;
            windowMap.put(cr, windowMap.getOrDefault(cr, 0) + 1);
            while (windowMap.getOrDefault(cr, 0) > 1) {
                char cl = s.charAt(left);
                left++;
                windowMap.put(cl, windowMap.get(cl) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring3 obj = new LengthOfLongestSubstring3();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
