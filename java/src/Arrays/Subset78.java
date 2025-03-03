package Arrays;

import java.util.ArrayList;
import java.util.List;

class Subset78 {
    // traverse
    /*public List<List<Integer>> subsets(int[] nums) {
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
    }*/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void dfs(int[] nums, int i, List<Integer> track, List<List<Integer>> res) {
        if(nums.length == i) {
            res.add(new ArrayList<>(track));
            return;
        }
        // choose i
        track.add(nums[i]);
        dfs(nums, i + 1, track, res);
        track.remove(track.size() - 1);
        // not choose, go to i + 1
        dfs(nums, i + 1, track, res);
    }

    public static void main(String[] args) {
        Subset78 subset = new Subset78();
        System.out.println(subset.subsets(new int[]{1, 2, 3}));
    }
}