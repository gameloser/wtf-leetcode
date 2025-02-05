import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses32 {
    /*public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        stack.push(-1);// add 1 ')' as 隔板
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    sum = Math.max(sum, i - stack.peek());
                } else {
                    // always keep 1 ')' as 隔板
                    stack.push(i);
                }
            }
        }
        return sum;
    }*/

    /*public int longestValidParentheses(String s) {
        int n = s.length();
        // 0 - n-1
        // 0 - n-2, 1 - n-1
        for (int j = n - 1; j > 0; j--) {
            for (int i = 0; i < n - j; i++) {
                if (isValid(s.substring(i, i + j + 1))) {
                    return j + 1;
                }
            }
        }
        return 0;
    }
    boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == ')') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }*/

    public int longestValidParentheses(String s) {
        // dp
        return -1;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 solution = new LongestValidParentheses32();
        // 2
        System.out.println(solution.longestValidParentheses(")))())"));
        // 4
        System.out.println(solution.longestValidParentheses(")()())"));
        // 6
        System.out.println(solution.longestValidParentheses("()(())"));
        // 2
        System.out.println(solution.longestValidParentheses("()(()"));
        // 4
        System.out.println(solution.longestValidParentheses(")()())"));

//        solution.longestValidParentheses("())))");
    }
}
