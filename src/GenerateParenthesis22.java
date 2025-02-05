import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, n);
        return res;
    }

    void backtrack(List<String> res, List<String> track, int left, int right) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(String.join("", track));
            return;
        }
        track.add("(");
        backtrack(res, track, left - 1, right);
        track.remove(track.size() - 1);
        track.add(")");
        backtrack(res, track, left, right - 1);
        track.remove(track.size() - 1);
    }

    public static void main(String[] args) {
        // ["((()))","(()())","(())()","()(())","()()()"]
        // n = 3
        GenerateParenthesis22 gen = new GenerateParenthesis22();
        System.out.println(gen.generateParenthesis(3));
    }
}
