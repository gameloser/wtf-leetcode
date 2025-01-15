package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// backtrack
class Permute47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        backtrack(nums, len, 0, used, new LinkedList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int len, int depth, boolean[] used, List<Integer> track, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // Here used[i-1]=false means previous permutation nums[i-1] is already done,
            // so no need any more dup action for nums[i],
            // as permutation collections starting at num[i-1] is exactly same as that starts at num[i]
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, len, depth + 1, used, track, res);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute47 p = new Permute47();
        System.out.println(p.permuteUnique(new int[]{1, 1, 3}));
    }

}