package BinarySearch;

import java.util.Arrays;

public class SuccessfulPairs2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        for (int i = 0; i < n; i++) {
            /*
            * Notice: ceil( a / b ) = floor( (a+b-1) / b ) = floor( (a-1) / b ) + 1
            * xy >= success <=> y >= ceil(success / x) <=> y >= floor( (success-1) / x) + 1
            */
            // int target = (int) Math.ceil((double) success / spells[i]);
            long target = (success - 1) / spells[i] + 1;
            if (target <= potions[m - 1]) { // 防止 long 转成 int 截断
                spells[i] = m - lower_bound(potions, (int) target);
            } else {
                spells[i] = 0;
            }
        }
        return spells;
    }

    public int lower_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SuccessfulPairs2300 s = new SuccessfulPairs2300();
        int[] spells = new int[]{5,1,3};
        int[] portions = {1,2,3,4,5};
        int success = 7;
        System.out.println(Arrays.toString(s.successfulPairs(spells, portions, success)));
        System.out.println();
        spells = new int[]{3,1,2};
        portions = new int[]{8,5,8};
        success = 16;
        System.out.println(Arrays.toString(s.successfulPairs(spells, portions, success)));

    }
}
