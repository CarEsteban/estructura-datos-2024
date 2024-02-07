import random, sorts

def generatorRandom():
    
    array = [random.randint(1,10000) for j in range(10)]
    

    return array

numerosAleatorios = generatorRandom()
ascDescBoolean = False

if __name__ == "__main__":
    print(sorts.quickSort(numerosAleatorios,0,len(numerosAleatorios)-1,ascDescBoolean))
    print(sorts.gnomeSort(numerosAleatorios,ascDescBoolean))
    print(sorts.heapSort(numerosAleatorios,ascDescBoolean))
    print(sorts.mergeSort(numerosAleatorios,ascDescBoolean))
    print(sorts.radixSort(numerosAleatorios,ascDescBoolean))
    print(sorts.selectionSort(numerosAleatorios,ascDescBoolean))
    print(sorts.shellSort(numerosAleatorios,ascDescBoolean))

