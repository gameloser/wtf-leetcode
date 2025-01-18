package Arrays;

public class CarPooling1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int len = 0;
        for (int[] trip : trips){
            if (trip[2] > len) len = trip[2];
        }
        int[] res = new int[len + 1];
        for (int[] trip : trips) {
            res[trip[1]] += trip[0];
            res[trip[2]] -= trip[0];
        }
        if (res[0] > capacity) return false;
        for (int i = 1; i < len + 1; i++) {
            res[i] += res[i - 1];
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // [[2,1,5],[3,3,7]]
        CarPooling1094 c = new CarPooling1094();
        System.out.println(c.carPooling(new int[][]{
                {9,0,1}, {3,3,7}
        }, 4));

        //
    }
}
