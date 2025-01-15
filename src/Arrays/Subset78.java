package Arrays;

import java.util.ArrayList;
import java.util.List;

class Subset78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> res) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track, res);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset78 subset = new Subset78();
        System.out.println(subset.subsets(new int[]{1, 2, 3}));
    }
}