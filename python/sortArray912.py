import random
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quick_sort(nums, 0, len(nums) - 1)
        return nums

    def partition(self, arr, l, r):
        pivot = arr[r]
        i = l - 1
        for j in range(l, r+1):
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]
        return i


    def partition_rand(self, arr, l, r):
        rand_pivot = random.randrange(l, r)
        arr[rand_pivot], arr[r] = arr[r], arr[rand_pivot]
        return self.partition(arr, l, r)


    def quick_sort(self, arr, l, r):
        if l < r:
            pi = self.partition_rand(arr, l, r)
            self.quick_sort(arr, l, pi - 1)
            self.quick_sort(arr, pi + 1, r)


if __name__ == '__main__':
    s = Solution()
    print(s.sortArray([6,7,8,3,4,5,9,1]))