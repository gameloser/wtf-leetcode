package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// backtrack
class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        backtrack(nums, len, 0, used, new LinkedList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int len, int depth, boolean[] used, List<Integer> track, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, len, depth + 1, used, track, res);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute46 p = new Permute46();
        System.out.println(p.permute(new int[]{1, 2, 3}));
    }
}