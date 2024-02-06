import random, sorts

def generatorRandom():
    
    array = [random.randint(1,10000) for j in range(3000)]
    
    return array

numerosAleatorios = generatorRandom()

#print(sorts.gnome_sort(numerosAleatorios))
#print(sorts.heapSort(numerosAleatorios))
#print(sorts.mergeSort(numerosAleatorios))
#print(sorts.quickSort(numerosAleatorios,0,len(numerosAleatorios)-1))
#print(sorts.radixSort(numerosAleatorios))
#print(sorts.selectionSort(numerosAleatorios))
print(sorts.shellSort(numerosAleatorios))

