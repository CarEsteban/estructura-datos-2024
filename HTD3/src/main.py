import random, sorts

def generatorRandom():
    
    array = [random.randint(1,10000) for j in range(10)]
    

    return array

numerosAleatorios = generatorRandom()

if __name__ == "__main__":
    print(sorts.quickSort(numerosAleatorios,0,len(numerosAleatorios)-1))
    print(sorts.gnome_sort(numerosAleatorios))
    print(sorts.heapSort(numerosAleatorios))
    print(sorts.mergeSort(numerosAleatorios))
    print(sorts.radixSort(numerosAleatorios))
    print(sorts.selectionSort(numerosAleatorios))
    print(sorts.shellSort(numerosAleatorios))

