def gnome_sort(arr):
    """
GNOME SORT
    """
    index = 0
    while index < len(arr):
        if index == 0 or arr[index] >= arr[index - 1]:
            index += 1
        else:
            arr[index], arr[index - 1] = arr[index - 1], arr[index]
            index -= 1
    return arr

if __name__ == "__main__":

    unsorted_list = [5, 2, 9, 1, 4, 3, 6]
    print("Lista desordenada:", unsorted_list)


    sorted_list = gnome_sort(unsorted_list)
    print("Lista ordenada:", sorted_list)
