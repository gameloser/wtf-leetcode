import java.util.ArrayDeque;
import java.util.Deque;

public class CatchRain42 {
//    public int trap(int[] height) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                int top = stack.pop();
//                // no need, coz no left wall to keep rain
//                // comparison needs among 3 walls
//                // stack needs at least 2 walls to following step to keep rain
//                if (stack.isEmpty()) break;
//                int d = i - stack.peek() - 1;
//                int h = Math.min(height[i], height[stack.peek()]) - height[top];
//                sum += h * d;
//            }
//            stack.push(i);
//        }
//        return sum;
//    }

    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 1 - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        CatchRain42 c = new CatchRain42();
        System.out.println(c.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //
    }
}
