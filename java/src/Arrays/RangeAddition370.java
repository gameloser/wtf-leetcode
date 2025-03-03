package Arrays;

import Arrays.diff.Difference;

import java.util.Arrays;

public class RangeAddition370 {
//    public int[] getModifiedArray(int length, int[][] updates) {
//        int[] nums = new int[length];
//        Difference difference = new Difference(nums);
//        for (int[] update : updates) {
//            difference.increment(update[0], update[1], update[2]);
//        }
//        difference.revert();
//        return difference.result;
//    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update: updates){
            res[update[0]] += update[2];
            if (update[1] + 1 < length){
                res[update[1] + 1] -= update[2];
            }
        }
        for (int i = 1; i < length; i++){
            res[i] += res[i - 1];
        }
        return res;
    }

}