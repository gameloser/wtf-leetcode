package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, new ArrayList<>(), 0, target, res);
        return res;
    }


    public void backtrack(int[] candidates, int start, List<Integer> track, int trackSum, int target, List<List<Integer>> res) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        } else if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            trackSum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, i + 1, track, trackSum, target, res);
            trackSum -= candidates[i];
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination40 combination = new Combination40();
        System.out.println(combination.combinationSum2(new int[]{1, 1, 3}, 3));
    }
}
