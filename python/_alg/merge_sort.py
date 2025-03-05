
def merge_sort(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)


def merge(arr1, arr2):
    n1 = len(arr1)
    n2 = len(arr2)
    res = []
    i, j = 0, 0
    while i < n1 and j < n2:
        if arr1[i] < arr2[j]:
            res.append(arr1[i])
            i += 1
        else:
            res.append(arr2[j])
            j += 1

    res += arr1[i:]
    res += arr2[j:]
    return res


if __name__ == '__main__':
    arr = [5, 2, 3, 1]
    print(merge_sort(arr))