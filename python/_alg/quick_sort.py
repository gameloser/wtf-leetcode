import random


def partition(arr, l, r):
    pivot = arr[r]
    i = l - 1
    for j in range(l, r+1):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    return i


def partition_rand(arr, l, r):
    rand_pivot = random.randrange(l, r)
    arr[rand_pivot], arr[r] = arr[r], arr[rand_pivot]
    return partition(arr, l, r)


def quick_sort(arr, l, r):
    if l < r:
        pi = partition_rand(arr, l, r)
        quick_sort(arr, l, pi - 1)
        quick_sort(arr, pi + 1, r)


if __name__ == '__main__':
    arr = [5, 4, 3, 2, 1]
    quick_sort(arr, 0, 4)
    print(arr)
