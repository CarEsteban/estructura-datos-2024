import sys
import os

# Añade el directorio src al sys.path
#generado por IA para que corriera el test
script_dir = os.path.dirname(__file__)  # Obtiene el directorio del script
parent_dir = os.path.join(script_dir, os.pardir, 'src')  # Navega al directorio src
sys.path.insert(0, os.path.abspath(parent_dir))

import unittest

# Asumimos que las funciones de ordenamiento están definidas en un módulo llamado sorting_algorithms
from main import generatorRandom


class TestGeneratorRandom(unittest.TestCase):
    def test_generator_random(self):
        array = generatorRandom()
        
        # Verificar que el resultado es una lista
        self.assertIsInstance(array, list)
        
        # Verificar que la lista tiene 10 elementos
        self.assertEqual(len(array), 10)
        
        # Verificar que todos los elementos son enteros y están en el rango correcto
        for item in array:
            self.assertIsInstance(item, int)
            self.assertTrue(1 <= item <= 10000)

if __name__ == "__main__":
    unittest.main()