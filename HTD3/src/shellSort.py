
#La última línea devuelve la lista ordenada.

def shell_sort(arr): #La primera línea define una función llamada shell_sort que toma una lista de números como entrada.
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

# Ejemplo de uso
arr = [12, 34, 54, 2, 3]
print("Lista original: ", arr)
shell_sort(arr)
print("Lista ordenada: ", arr)
