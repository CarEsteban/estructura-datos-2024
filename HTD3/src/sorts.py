# Codigos generados por IA, proporcionados por compañeros de clase

def gnome_sort(arr):
    index = 0
    while index < len(arr):
        if index == 0 or arr[index] >= arr[index - 1]:
            index += 1
        else:
            arr[index], arr[index - 1] = arr[index - 1], arr[index]
            index -= 1
    return arr

def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    # Verifica si el hijo izquierdo del nodo existe y es mayor que el nodo actual
    if left < n and arr[largest] < arr[left]:
        largest = left

    # Verifica si el hijo derecho del nodo existe y es mayor que el nodo actual
    if right < n and arr[largest] < arr[right]:
        largest = right

    # Cambia y sigue heapifying si la raíz no es el mayor
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap
        heapify(arr, n, largest)
        
def heapSort(arr):
    n = len(arr)

    # Construye un montículo máximo
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extrae elementos uno por uno
    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)
        
    return arr

def mergeSort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        mergeSort(left_half)
        mergeSort(right_half)

        i = j = k = 0

        # Comparación y fusión de las dos mitades ordenadas
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        # Verificar elementos restantes en ambas mitades
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

    return arr

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

def quickSort(arr, low, high):
    if low < high:
        # Encuentra el índice del pivote después de la partición
        pi = partition(arr, low, high)

        # Ordena los elementos antes y después del pivote
        quickSort(arr, low, pi-1)
        quickSort(arr, pi+1, high)
        
    return arr

def countingSort(arr, place):
    size = len(arr)
    output = [0] * size
    count = [0] * 10

    for i in range(0, size):
        index = arr[i] // place
        count[index % 10] += 1

    for i in range(1, 10):
        count[i] += count[i - 1]

    i = size - 1
    while i >= 0:
        index = arr[i] // place
        output[count[index % 10] - 1] = arr[i]
        count[index % 10] -= 1
        i -= 1

    for i in range(0, size):
        arr[i] = output[i]


def radixSort(arr):
    max_element = max(arr)

    place = 1
    while max_element // place > 0:
        countingSort(arr, place)
        place *= 10
        
    return arr

def selectionSort(arr, ascending=True):
    n = len(arr)

    for i in range(n):
        # Encontrar el índice extremo en el resto de la lista
        extreme_index = i
        for j in range(i+1, n):
            if ascending:
                condition = arr[j] < arr[extreme_index]
            else:
                condition = arr[j] > arr[extreme_index]

            if condition:
                extreme_index = j

        # Intercambiar el elemento extremo encontrado con el primer elemento no ordenado
        arr[i], arr[extreme_index] = arr[extreme_index], arr[i]
    return arr


def shellSort(arr): #La primera línea define una función llamada shell_sort que toma una lista de números como entrada.
    n = len(arr) #n = longitud de la lista
    gap = n // 2 #gap que se inicializa con la mitad de la longitud de la lista de entrada.
    while gap > 0: #Este bucle divide la lista en sub-listas más pequeñas y las ordena utilizando el algoritmo de ordenación por inserción.
        for i in range(gap, n): #El bucle for itera sobre los elementos de la lista y utiliza el algoritmo de ordenación por inserción para ordenar las sub-listas.
            temp = arr[i] #define una variable temporal temp que almacena el valor del elemento actual
            j = i #define una variable j que se inicializa con el índice del elemento actual.
            while j >= gap and arr[j - gap] > temp: #El bucle while se ejecuta mientras j sea mayor o igual que gap y el elemento anterior sea mayor que el elemento actual. 
                #Este bucle mueve los elementos mayores a la derecha para hacer espacio para el elemento actual.

                arr[j] = arr[j - gap] #Esta y las siguientes lineas insertan el elemento actual en su posición correcta en la sub-lista.
                j -= gap
            arr[j] = temp 
        gap //= 2 #divide gap por 2 para reducir el tamaño de las sub-listas.
    return arr #La última línea devuelve la lista ordenada.
