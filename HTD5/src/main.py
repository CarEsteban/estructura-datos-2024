import simpy
import random
import statistics
import matplotlib.pyplot as plt  # Importa Matplotlib para la graficación

# Configuraciones de la simulación
TIEMPO_SIMULACION = 1000  # Aumentar para permitir más tiempo de procesamiento
CAPACIDAD_RAM = 100
VELOCIDAD_CPU = 10
INSTRUCCIONES_POR_CICLO = 3
CANTIDAD_PROCESOS = [25, 50, 100, 150, 200]

def proceso(env, nombre, cpu, ram, num_instrucciones, memoria_necesaria):
    yield env.timeout(random.expovariate(1/10))  # Retraso antes de solicitar RAM
    tiempo_inicio = env.now
    with ram.get(memoria_necesaria) as req_ram:
        yield req_ram
        # Proceso obtiene RAM
        while num_instrucciones > 0:
            with cpu.request() as req_cpu:
                yield req_cpu
                # Simula ejecución de instrucciones
                ejecutadas = min(num_instrucciones, INSTRUCCIONES_POR_CICLO * VELOCIDAD_CPU)
                yield env.timeout(ejecutadas/VELOCIDAD_CPU)
                num_instrucciones -= ejecutadas
    tiempos.append(env.now - tiempo_inicio)

resultados = []
for n in CANTIDAD_PROCESOS:
    env = simpy.Environment()
    cpu = simpy.Resource(env, capacity=1)
    ram = simpy.Container(env, init=CAPACIDAD_RAM, capacity=CAPACIDAD_RAM)
    tiempos = []
    for i in range(n):
        num_instrucciones = random.randint(1, 10) * 10
        memoria_necesaria = random.randint(1, 10)
        env.process(proceso(env, f'Proceso {i}', cpu, ram, num_instrucciones, memoria_necesaria))
    env.run(until=TIEMPO_SIMULACION)
    promedio = round(statistics.mean(tiempos), 2)
    desviacion = round(statistics.stdev(tiempos), 2) if len(tiempos) > 1 else 0
    resultados.append((n, promedio, desviacion))

for resultado in resultados:
    print(f'Procesos: {resultado[0]}, Tiempo promedio: {resultado[1]}, Desviación estándar: {resultado[2]}')

# Datos para la gráfica
cantidad_procesos = [resultado[0] for resultado in resultados]
tiempo_promedio = [resultado[1] for resultado in resultados]

# Creación de la gráfica
plt.figure(figsize=(10, 6))
plt.plot(cantidad_procesos, tiempo_promedio, marker='o', linestyle='-', color='b')
plt.title('Tiempo promedio de ejecución por cantidad de procesos')
plt.xlabel('Cantidad de Procesos')
plt.ylabel('Tiempo Promedio (s)')
plt.grid(True)
plt.xticks(cantidad_procesos)

# Mostrar la gráfica
plt.show()
