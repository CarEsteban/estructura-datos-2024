import random, sorts, timeit

def generatorRandom():
    
    array = [random.randint(1,10000) for j in range(2792)]
    

    return array

def run_algorithms(numerosAleatorios, ascDescBoolean):

    start_time = timeit.default_timer()
    sorts.quickSort(numerosAleatorios, 0, len(numerosAleatorios) - 1, ascDescBoolean)
    print("quickSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.gnomeSort(numerosAleatorios, ascDescBoolean)
    print("gnomeSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.heapSort(numerosAleatorios, ascDescBoolean)
    print("heapSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.mergeSort(numerosAleatorios, ascDescBoolean)
    print("mergeSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.radixSort(numerosAleatorios, ascDescBoolean)
    print("radixSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.selectionSort(numerosAleatorios, ascDescBoolean)
    print("selectionSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.shellSort(numerosAleatorios, ascDescBoolean)
    print("shellSort:", timeit.default_timer() - start_time, "seconds")

selection = int(input("Desea orden ascendente(1) o descendente(0)?\n"))
if selection == 1:
    ascDescBoolean =  True
elif selection==0:
    ascDescBoolean=False
else:
    print("no existe")


numerosAleatorios = generatorRandom()


#print(sorts.quickSort(numerosAleatorios,0,len(numerosAleatorios)-1,ascDescBoolean))
print(sorts.gnomeSort(numerosAleatorios,ascDescBoolean))
#print(sorts.heapSort(numerosAleatorios,ascDescBoolean))
#print(sorts.mergeSort(numerosAleatorios,ascDescBoolean))
#print(sorts.radixSort(numerosAleatorios,ascDescBoolean))
#print(sorts.selectionSort(numerosAleatorios,ascDescBoolean))
#print(sorts.shellSort(numerosAleatorios,ascDescBoolean))


run_algorithms(numerosAleatorios,ascDescBoolean)