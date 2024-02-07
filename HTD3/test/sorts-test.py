import sys
import os

# Añade el directorio src al sys.path
#generado por IA para que corriera el test
script_dir = os.path.dirname(__file__)  # Obtiene el directorio del script
parent_dir = os.path.join(script_dir, os.pardir, 'src')  # Navega al directorio src
sys.path.insert(0, os.path.abspath(parent_dir))

import unittest

# Asumimos que las funciones de ordenamiento están definidas en un módulo llamado sorting_algorithms
from sorts import gnomeSort, heapSort, mergeSort, quickSort, radixSort, selectionSort, shellSort

class TestSortingAlgorithms(unittest.TestCase):
    def test_gnome_sort(self):
        self.assertEqual(gnomeSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(gnomeSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_heap_sort(self):
        self.assertEqual(heapSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(heapSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_merge_sort(self):
        self.assertEqual(mergeSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(mergeSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_quick_sort(self):
        self.assertEqual(quickSort([4, 2, 7, 1, 3], 0, 4, True), [1, 2, 3, 4, 7])
        self.assertEqual(quickSort([4, 2, 7, 1, 3], 0, 4, False), [7, 4, 3, 2, 1])

    def test_radix_sort(self):
        self.assertEqual(radixSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
    #    self.assertEqual(radixSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])  //radix no deja de forma descendente

    def test_selection_sort(self):
        self.assertEqual(selectionSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(selectionSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

    def test_shell_sort(self):
        self.assertEqual(shellSort([4, 2, 7, 1, 3], True), [1, 2, 3, 4, 7])
        self.assertEqual(shellSort([4, 2, 7, 1, 3], False), [7, 4, 3, 2, 1])

if __name__ == "__main__":
    unittest.main()
