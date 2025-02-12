package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LeastCoverageSubstring76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> coverMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for(char c : t.toCharArray()){
            coverMap.put(c, coverMap.getOrDefault(c, 0) + 1);
        }
        // [left, right) 左闭右开
        int left = 0, right = 0;
        int valid = 0;
        // 最小覆盖字串 的起始索引和最小长度
        int start = 0, maxLen = s.length() + 1;
        while (right < s.length()){
            char cr = s.charAt(right);
            // 扩大窗口，向窗口右侧移入 char cr
            right++;
            // 如果char是在coverMap里的key，更新map增加
            if(coverMap.containsKey(cr)){
                windowMap.put(cr, windowMap.getOrDefault(cr, 0) + 1);
                if(coverMap.get(cr).equals(windowMap.get(cr))){
                    valid++;
                }
            }
            // 根据valid长度，判断是否要收缩窗口左侧
            while(valid == coverMap.size()){
                // 更新最小覆盖字串
                if(right - left <= maxLen){
                    start = left;
                    maxLen = right - left;
                }
                // 收缩窗口，从窗口左侧移出 char cl
                char cl = s.charAt(left);
                left++;
                // 如果char是在coverMap里的key，更新map减除
                if(coverMap.containsKey(cl)){
                    if(coverMap.get(cl).equals(windowMap.get(cl))){
                        valid--;
                    }
                    windowMap.put(cl, windowMap.get(cl) - 1);
                }
            }
        }
        boolean b = maxLen != s.length() + 1;
        // 返回最小覆盖字串 [start, start + maxLen)
        return b ? s.substring(start, start + maxLen) : "";
    }

    public static void main(String[] args) {
        LeastCoverageSubstring76 solution = new LeastCoverageSubstring76();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
