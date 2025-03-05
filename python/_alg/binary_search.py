from bisect import bisect_left


def binary_search(arr, target):
    l, r = 0, len(arr) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            l = mid + 1
        elif arr[mid] > target:
            r = mid - 1
    return -1


# return range [0, length]
def lower_bound_close(arr, target):
    l, r = 0, len(arr) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if arr[mid] >= target:
            r = mid - 1
        else:
            l = mid + 1
    return l


# return range [0, length]
def lower_bound_open(arr, target):
    l, r = -1, len(arr)
    while l + 1 < r:
        mid = l + (r - l) // 2
        if arr[mid] >= target:
            r = mid
        else:
            l = mid
    return r


if __name__ == "__main__":
    # Finding the greatest value smaller than x.
    arr = [1, 2, 3, 3, 3, 3, 5]
    for func in [binary_search, bisect_left, lower_bound_open, lower_bound_close]:
        for x in [3, 4, -1, 10]:
            print(func(arr, x))
        print("\n")
