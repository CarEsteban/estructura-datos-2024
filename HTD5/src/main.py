import simpy
import random
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
def proceso(env, nombre, cpu, ram, tiempo_creacion):
    # Implementar la lógica del proceso
    yield env.timeout(tiempo_creacion)

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
    for num_proceso in NUM_PROCESOS:
        for intervalo in INTERVALOS:
            # Resetear la semilla aleatoria para reproducibilidad
            random.seed(RANDOM_SEED)

            # Crear un ambiente de simulación y ejecutar
            env = simpy.Environment()
            env.process(ejecutar_simulacion(env, num_proceso, intervalo, CPU_INSTRUCCIONES_POR_UNIDAD, MEMORIA_RAM_INICIAL, CAPACIDAD_CPU))
            env.run()

            # Aquí iría la lógica para registrar los tiempos y realizar cálculos

    # Después de correr todas las simulaciones, generar gráficas
    for key, values in TIEMPOS.items():
        # Generar gráficas con matplotlib
        plt.figure()
        plt.plot(values['procesos'], values['tiempo_promedio'])
        plt.title(f'Simulación con {key}')
        plt.xlabel('Número de procesos')
        plt.ylabel('Tiempo promedio en sistema')
        plt.savefig(f'simulacion_{key}.png')

# Llamar a la función principal para correr todo el programa
realizar_simulaciones_y_graficas()
