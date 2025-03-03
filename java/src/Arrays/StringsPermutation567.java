package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringsPermutation567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> coverMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            coverMap.put(c, coverMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char cr = s2.charAt(right);
            right++;
            if (coverMap.containsKey(cr)) {
                windowMap.put(cr, windowMap.getOrDefault(cr, 0) + 1);
                if (coverMap.get(cr).equals(windowMap.get(cr))) {
                    valid++;
                }
            }
            if (right - left == s1.length()) {
                if (valid == coverMap.size()) {
                    return true;
                }
                char cl = s2.charAt(left);
                left++;
                if (coverMap.containsKey(cl)) {
                    if (coverMap.get(cl).equals(windowMap.get(cl))) {
                        valid--;
                    }
                    windowMap.put(cl, windowMap.get(cl) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringsPermutation567 solution = new StringsPermutation567();
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}
