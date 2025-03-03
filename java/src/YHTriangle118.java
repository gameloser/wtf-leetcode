import java.util.ArrayList;
import java.util.List;

public class YHTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        // base
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        if (numRows == 1) return res;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int left = j - 1 < 0 ? 0 : row.get(j - 1);
                int right = j > i - 1 - 1 ? 0: row.get(j);
                temp.add(left + right);
            }
            row = temp;
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        YHTriangle118 y = new YHTriangle118();
        System.out.println(y.generate(5));
    }
}
