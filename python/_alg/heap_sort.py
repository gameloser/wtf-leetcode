from typing import List


def heapify(self, nums, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and nums[largest] < nums[l]:
        largest = l
    if r < n and nums[largest] < nums[r]:
        largest = r
    if largest != i:
        nums[i], nums[largest] = nums[largest], nums[i]
        self.heapify(nums, n, largest)


def heap_sort(self, nums: List[int]) -> List[int]:
    n = len(nums)
    # build max heap
    for i in range(n // 2 - 1, -1, -1):
        self.heapify(nums, n, i)
    # exchange top with bottom node, and heapify from nums[0] to restore a max heap
    for i in range(n - 1, 0, -1):
        nums[0], nums[i] = nums[i], nums[0]
        self.heapify(nums, i, 0)
    return nums

