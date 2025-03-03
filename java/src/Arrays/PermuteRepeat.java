package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// backtrack
class PermuteRepeat {
    public List<List<Integer>> permuteRepeat(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        backtrack(nums, len, 0, new LinkedList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int len, int depth, List<Integer> track, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < len; i++) {
            track.add(nums[i]);
            backtrack(nums, len, depth + 1, track, res);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermuteRepeat p = new PermuteRepeat();
        System.out.println(p.permuteRepeat(new int[]{1, 2, 3}));
    }
}