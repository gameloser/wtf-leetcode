package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] board = new String[n][n];
        int len = board.length;
        for (String[] row : board) {
            Arrays.fill(row, ".");
        }
        backtrack(board, len, 0, res);
        return res;
    }

    public void backtrack(String[][] board, int len, int row, List<List<String>> res) {
        if (row == len) {
            List<String> list = new ArrayList<>();
            for (String[] s : board) {
                list.add(String.join("", s));
            }
            res.add(list);
        }
        for (int i = 0; i < len; i++) {
            if (!isValid(board, len, row, i)) {
                continue;
            }
            board[row][i] = "Q";
            backtrack(board, len, row + 1, res);
            board[row][i] = ".";
        }
    }

    private boolean isValid(String[][] board, int len, int row, int col) {
        // top
        for (int i = 0; i < row; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }
        // top left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        // top right
        for (int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[][] board = new String[][]{
                {"Q", ".", "3"},
                {"2", "4", "5"},
                {"3", "6", "7"},
        };


        List<List<String>> res = new ArrayList<>();

//        for (String[] s : board) {
//            res.add(List.of(String.join("", s)));
//        }
        NQueen solver = new NQueen();
        System.out.println();
    }

}
