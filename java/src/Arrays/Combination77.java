package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Combination77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res =  new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int n, int k, int start, List<Integer> track, List<List<Integer>> res) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track, res);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination77 combination = new Combination77();
        System.out.println(combination.combine(4, 2));
    }
}
