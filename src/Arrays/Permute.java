package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// backtrack
class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return res;
    }

    public void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}