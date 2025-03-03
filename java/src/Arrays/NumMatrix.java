package Arrays;

public class NumMatrix {
    /*
    *  f
    *   0    | 0            |   0
    *   0    | f(i-1, j-1)  |   f(i-1, j)
    *   0    | f(i, j-1)    |   f(i, j) , matrix(i-1, j-1)
    * f[i][j] records the elements sum of matrix[0, 0, i-1, j-1]
    *
    * f(i, j) = matrix(i-1, j-1) + f(i-1, j) + f(i, j-1) - f(i-1, j-1)
     * */
    private final int[][] f;

    public NumMatrix(int[][] matrix) {
        int r = matrix.length + 1;
        int c = matrix[0].length + 1;
        f = new int[r][c];
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                f[i][j] = matrix[i - 1][j - 1] + f[i - 1][j] + f[i][j - 1] - f[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*
        *       |              |
        *       | (row1, col1) |
        *       |              | (row2, col2)
        *
        * f(int row1, int col1, int row2, int col2)
        * = f(row2, col2) - f(row1-1, col2) - f(row2, col1-1) + f(row1-1, col1-1)
        * */
        return f[row2+1][col2+1] - f[row1][col2+1] - f[row2+1][col1] + f[row1][col1];
    }

    public static void main(String[] args) {

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */