package Algorithm.search;

import java.util.Arrays;

public class BinarySearch {
    // value == target
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    // largest nums[i] <= target
    public int right_bound_close(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return ans;
    }

    // return right [-1...length-1]
    public int upper_bound_close(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return right;
    }

    // least nums[i] >= target
    public int left_bound_close(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    // return left [0...length]
    public int lower_bound_close(int[] nums, int target) {
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

    private int upper_bound_open(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] <= target
            // nums[right] > target
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid; // 二分范围缩小到 (left, mid)
            } else {
                left = mid; // 二分范围缩小到 (mid, right)
            }
        }
        return right;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] nums = new int[]{-1,0,0,0};
//        int target = -1;
//        // >= target
//        System.out.println(b.lower_bound_search(nums, target));
//        // > target
//        System.out.println(b.lower_bound_search(nums, target + 1));
//        // <= target
//        System.out.println(b.upper_bound_search(nums, target));
//        // < target
//        System.out.println(b.upper_bound_search(nums, target - 1));
//
//        target = 11;
//        // >= target
//        System.out.println(b.lower_bound_search(nums, target));
//        // > target
//        System.out.println(b.lower_bound_search(nums, target + 1));
//        // <= target
//        System.out.println(b.upper_bound_search(nums, target));
//        // < target
//        System.out.println(b.upper_bound_search(nums, target - 1));
        int target = 0;
        System.out.println(b.left_bound_close(nums, target));
        System.out.println(b.upper_bound_close(nums, target));
        System.out.println(b.upper_bound_open(nums, target));
    }
}
