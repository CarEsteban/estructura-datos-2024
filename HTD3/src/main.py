import random, sorts, timeit

def generatorRandom():
    
    array = [random.randint(1,10000) for j in range(10)]
    

    return array

#Se le pidió a la IA que creara una función para medir el tiempo, ya que Austin Profiler no funcionaba
def run_algorithms(ascDescBoolean):
    numerosAleatorios = generatorRandom()
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
    
    
def run_algorithmsDoubleOrden(ascDescBoolean):
    numerosAleatorios = generatorRandom()
    start_time = timeit.default_timer()
    sorts.quickSort(numerosAleatorios, 0, len(numerosAleatorios) - 1, ascDescBoolean)
    print("quickSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.gnomeSort(numerosAleatorios, ascDescBoolean)
    sorts.gnomeSort(numerosAleatorios, ascDescBoolean)
    print("gnomeSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.heapSort(numerosAleatorios, ascDescBoolean)
    sorts.heapSort(numerosAleatorios, ascDescBoolean)
    print("heapSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.mergeSort(numerosAleatorios, ascDescBoolean)
    sorts.mergeSort(numerosAleatorios, ascDescBoolean)
    print("mergeSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.radixSort(numerosAleatorios, ascDescBoolean)
    sorts.radixSort(numerosAleatorios, ascDescBoolean)
    print("radixSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.selectionSort(numerosAleatorios, ascDescBoolean)
    sorts.selectionSort(numerosAleatorios, ascDescBoolean)
    print("selectionSort:", timeit.default_timer() - start_time, "seconds")

    start_time = timeit.default_timer()
    sorts.shellSort(numerosAleatorios, ascDescBoolean)
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
#1print(sorts.gnomeSort(numerosAleatorios,ascDescBoolean))
#print(sorts.heapSort(numerosAleatorios,ascDescBoolean))
#print(sorts.mergeSort(numerosAleatorios,ascDescBoolean))
#print(sorts.radixSort(numerosAleatorios,ascDescBoolean))
#print(sorts.selectionSort(numerosAleatorios,ascDescBoolean))
#print(sorts.shellSort(numerosAleatorios,ascDescBoolean))


run_algorithmsDoubleOrden(ascDescBoolean)
#run_algorithms(ascDescBoolean)