import unittest

def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

def quicksort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        quicksort(arr, low, pi - 1)
        quicksort(arr, pi + 1, high)

class TestQuicksort(unittest.TestCase):

    def test_quicksort(self):
        arr = [3, 6, 8, 10, 1, 2, 1]
        quicksort(arr, 0, len(arr) - 1)
        self.assertEqual(arr, [1, 1, 2, 3, 6, 8, 10])
        print("lista: ", arr)

    def test_empty_list(self):
        arr = []
        quicksort(arr, 0, len(arr) - 1)
        self.assertEqual(arr, [])

if __name__ == '__main__':
    unittest.main()