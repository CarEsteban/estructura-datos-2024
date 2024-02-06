def partition(arr, low, high):
    # Tomamos el último elemento como pivote
    pivot = arr[high]
    i = low - 1  # Índice del elemento más pequeño

    for j in range(low, high):
        # Si el elemento actual es menor o igual que el pivote
        if arr[j] <= pivot:
            # Incrementamos el índice del elemento más pequeño
            i += 1
            # Intercambiamos arr[i] con arr[j]
            arr[i], arr[j] = arr[j], arr[i]

    # Intercambiamos arr[i+1] con arr[high] (el pivote)
    arr[i+1], arr[high] = arr[high], arr[i+1]
    return i+1

def quicksort(arr, low, high):
    if low < high:
        # Encuentra el índice del pivote después de la partición
        pi = partition(arr, low, high)

        # Ordena los elementos antes y después del pivote
        quicksort(arr, low, pi-1)
        quicksort(arr, pi+1, high)

# Ejemplo de uso:
lista = [3, 6, 8, 10, 1, 2, 1]
print("Lista original:", lista)
quicksort(lista, 0, len(lista) - 1)
print("Lista ordenada:", lista)