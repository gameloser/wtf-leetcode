package Arrays.diff;

import java.util.Arrays;

public class Difference {
    /*
    * num[i...j] + k  ~ diff[i] += k diff[j+1] -= k
    * */
    public int[] diff;
    public int[] result;
    /*
     *  nums:  8,  2,  6,  3,  1
     *   dff:  8, -6,  4, -3, -2
     * */
    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }
    /*  i=1, j=3, k=3
     *  nums:  8,  2,  6,  3,   1
     *   dff:  8, -3,  4, -3,  -5
     * */
    public void increment(int i, int j, int k) {
        diff[i] += k;
        if (j + 1 < diff.length)
            diff[j+1] -= k;
    }
    /*
     * result:  8,  5,  9,  6,   1
     *    dff:  8, -3,  4, -3,  -2
     * */
    public void revert() {
        result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i-1] + diff[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 6, 3, 1};
        Difference difference = new Difference(nums);
        System.out.println(Arrays.toString(nums));
        difference.increment(1, 3, 3);
        System.out.println(Arrays.toString(difference.diff));
        difference.revert();
        System.out.println(Arrays.toString(difference.result));
    }

}
