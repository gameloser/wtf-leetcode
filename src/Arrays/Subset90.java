package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subset90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        // Algorithm.sort, make sure the same values close together
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> res) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            // cut second dup branch, only traverse the first branch
            if (i > start && nums[i] == nums[i - 1]) continue;
            track.add(nums[i]);
            backtrack(nums, i + 1, track, res);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset90 subset = new Subset90();
        System.out.println(subset.subsetsWithDup(new int[]{1, 2, 3}));
    }
}