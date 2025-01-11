package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// backtrack
class Permute {
//    List<List<Integer>> res = new LinkedList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        backtrack(nums, new LinkedList<>());
//        return res;
//    }
//
//    public void backtrack(int[] nums, List<Integer> track) {
//        if (track.size() == nums.length) {
//            res.add(new LinkedList<>(track));
//            return;
//        }
//        for (int num : nums) {
//            if (track.contains(num)) {
//                continue;
//            }
//            track.add(num);
//            backtrack(nums, track);
//            track.remove(track.size() - 1);
//        }
//    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, used, new LinkedList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> track, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, track, res);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}