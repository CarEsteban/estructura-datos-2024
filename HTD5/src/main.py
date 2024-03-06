import simpy
import random
import statistics

# Configuraciones iniciales
CAPACIDAD_RAM = 100
VELOCIDAD_CPU = 10
INSTRUCCIONES_POR_CICLO = 3
TIEMPO_SIMULACION = 100
CANTIDAD_PROCESOS = [25, 50, 100, 150, 200]  # Procesos a simular

resultados = []

def proceso(nombre, env, cpu, ram, num_instrucciones, memoria_necesaria):
    tiempo_llegada = env.now
    with ram.get(memoria_necesaria) as req:
        yield req
        inicio = env.now
        while num_instrucciones > 0:
            with cpu.request() as req_cpu:
                yield req_cpu
                ejecutadas = min(num_instrucciones, INSTRUCCIONES_POR_CICLO)
                yield env.timeout(ejecutadas / VELOCIDAD_CPU)
                num_instrucciones -= ejecutadas
            if num_instrucciones > 0:
                yield env.timeout(1)  # Simula espera por E/S
        tiempos.append(env.now - inicio)

for num_procesos in CANTIDAD_PROCESOS:
    env = simpy.Environment()
    ram = simpy.Container(env, CAPACIDAD_RAM, init=CAPACIDAD_RAM)
    cpu = simpy.Resource(env, capacity=1)
    tiempos = []

    for i in range(num_procesos):
        t_instrucciones = random.randint(1, 10)
        mem_necesaria = random.randint(1, 10)
        env.process(proceso(f'Proceso {i}', env, cpu, ram, t_instrucciones, mem_necesaria))

    env.run(until=TIEMPO_SIMULACION)
    promedio = round(statistics.mean(tiempos), 2)
    desviacion = round(statistics.stdev(tiempos), 2) if len(tiempos) > 1 else 0
    resultados.append((num_procesos, promedio, desviacion))

for resultado in resultados:
    print(f'Procesos: {resultado[0]}, Tiempo promedio: {resultado[1]}, Desviación estándar: {resultado[2]}')
