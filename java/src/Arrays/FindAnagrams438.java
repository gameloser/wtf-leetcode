package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> coverMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            coverMap.put(c, coverMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char cr = s.charAt(right);
            right++;
            if (coverMap.containsKey(cr)) {
                windowMap.put(cr, windowMap.getOrDefault(cr, 0) + 1);
                if (coverMap.get(cr).equals(windowMap.get(cr))) {
                    valid++;
                }
            }
            if (right - left == p.length()) {
                if (valid == coverMap.size()) {
                    res.add(left);
                }
                char cl = s.charAt(left);
                left++;
                if (coverMap.containsKey(cl)) {
                    if (coverMap.get(cl).equals(windowMap.get(cl))) {
                        valid--;
                    }
                    windowMap.put(cl, windowMap.get(cl) - 1);
                }
            }
        }
        return res;
    }
}
