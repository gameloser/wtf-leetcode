import heapq
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return sorted(nums)

    def heapify(self, nums, heap_len, root):
        i = root
        largest = i
        l = 2 * i + 1
        r = 2 * i + 2
        if l < heap_len and nums[i] < nums[l]:
            largest = l
        if r < heap_len and nums[largest] < nums[r]:
            largest = r



if __name__ == '__main__':
    s = Solution()
    print(s.sortArray([6,7,8,3,4,5,9,1]))