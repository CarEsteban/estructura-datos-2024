import simpy
import random
import numpy as np
import matplotlib.pyplot as plt

# Configuraciones iniciales de la simulación
RANDOM_SEED = 42
NUM_PROCESOS = [25, 50, 100, 150, 200]  # Diferentes números de procesos
INTERVALOS = [10, 5, 1]  # Intervalos de creación de procesos
CPU_INSTRUCCIONES_POR_UNIDAD = 3  # Velocidad inicial del CPU
MEMORIA_RAM_INICIAL = 100  # Cantidad inicial de memoria RAM
CAPACIDAD_CPU = 1  # Un solo CPU al principio
TIEMPOS = {}  # Diccionario para guardar los resultados

# Definimos una semilla para poder reproducir los resultados
random.seed(RANDOM_SEED)

# Función para crear los procesos

def proceso(env, nombre, cpu, ram, numero_instrucciones, intervalo):
    memoria_requerida = random.randint(1, 10)
    
    # NEW: El proceso llega y solicita memoria
    yield ram.get(memoria_requerida)
    print(f'{env.now}: El proceso {nombre} ha llegado al sistema y ha obtenido {memoria_requerida} de RAM')
    
    # READY: El proceso está listo para ser atendido por el CPU
    with cpu.request() as req:
        yield req
        # RUNNING: El CPU atiende al proceso
        while numero_instrucciones > 0:
            print(f'{env.now}: El proceso {nombre} está en ejecución')
            # Ejecutar el proceso tantas veces como instrucciones por unidad de tiempo permita el CPU
            yield env.timeout(1)
            numero_instrucciones -= min(numero_instrucciones, cpu_instrucciones_por_unidad)
            print(f'{env.now}: Al proceso {nombre} le quedan {numero_instrucciones} instrucciones')
            
            # Verificar si el proceso ha terminado
            if numero_instrucciones <= 0:
                print(f'{env.now}: El proceso {nombre} ha terminado')
                break
            
            # Simular I/O operation de manera aleatoria
            if random.randint(1, 21) == 1:
                print(f'{env.now}: El proceso {nombre} está en waiting por I/O')
                yield env.timeout(1)  # Tiempo que pasa haciendo I/O
    
    # El proceso ha terminado y libera la memoria RAM
    yield ram.put(memoria_requerida)
    print(f'{env.now}: El proceso {nombre} ha liberado {memoria_requerida} de RAM y ha salido del sistema')


# Función para correr la simulación
def ejecutar_simulacion(env, num_procesos, intervalo, cpu_instrucciones_por_unidad, memoria_ram_inicial, capacidad_cpu):
    # Crear recursos: CPU y RAM
    cpu = simpy.Resource(env, capacidad_cpu)
    ram = simpy.Container(env, init=memoria_ram_inicial, capacity=memoria_ram_inicial)

    # Crear los procesos
    for i in range(num_procesos):
        tiempo_creacion = random.expovariate(1.0 / intervalo)
        env.process(proceso(env, f'Proceso {i}', cpu, ram, tiempo_creacion))

# Función para realizar la simulación con distintas configuraciones y generar gráficas
def realizar_simulaciones_y_graficas():
    global tiempos_procesos
    resultados = {}

    for num_procesos in [25, 50, 100, 150, 200]:  # Diferentes cantidades de procesos
        tiempos_procesos = {}  # Diccionario para registrar tiempos de cada proceso

        # Correr la simulación para cada intervalo
        for intervalo in INTERVALOS:
            env = simpy.Environment()
            env.process(ejecutar_simulacion(env, num_procesos, intervalo))
            env.run()

        # Calcular estadísticas
        tiempos_totales = list(tiempos_procesos.values())
        promedio = np.mean(tiempos_totales)
        desviacion_std = np.std(tiempos_totales)
        resultados[num_procesos] = {'promedio': promedio, 'desviacion_std': desviacion_std}

        # Graficar
        plt.errorbar(resultados.keys(), [r['promedio'] for r in resultados.values()], 
                     yerr=[r['desviacion_std'] for r in resultados.values()], fmt='-o')
    
    plt.title('Tiempo promedio y desviación estándar por número de procesos')
    plt.xlabel('Número de procesos')
    plt.ylabel('Tiempo promedio en el sistema')
    plt.show()

# Llamar a la función principal para correr todo el programa
realizar_simulaciones_y_graficas()
