import simpy
import random
import statistics

# Configuraciones de la simulación
TIEMPO_SIMULACION = 100
NUM_PROCESOS = 25  # Varía este número para 50, 100, 150, 200
CAPACIDAD_RAM = 100  # Ajusta según necesites
VELOCIDAD_CPU = 10  # Ajusta según necesites
INSTRUCCIONES_POR_CICLO = 3

tiempos = []

def proceso(nombre, env, cpu, ram, num_instrucciones, memoria_necesaria):
    # Registro de llegada
    tiempo_llegada = env.now
    print(f'{nombre} llega a {tiempo_llegada}')
    with ram.get(memoria_necesaria) as req:
        yield req
        # Inicio de ejecución
        print(f'{nombre} obtuvo memoria a {env.now}, instrucciones: {num_instrucciones}, memoria necesaria: {memoria_necesaria}')
        while num_instrucciones > 0:
            with cpu.request() as req_cpu:
                yield req_cpu
                # Ejecuta instrucciones
                ejecutadas = min(num_instrucciones, INSTRUCCIONES_POR_CICLO)
                yield env.timeout(ejecutadas / VELOCIDAD_CPU)
                num_instrucciones -= ejecutadas
                print(f'{nombre} ejecutó {ejecutadas} instrucciones. Restan {num_instrucciones} a {env.now}')
                if num_instrucciones > 0:
                    yield env.timeout(1)  # Simula espera por E/S
        print(f'{nombre} terminó a {env.now}')
        tiempos.append(env.now - tiempo_llegada)

env = simpy.Environment()
ram = simpy.Container(env, CAPACIDAD_RAM, init=CAPACIDAD_RAM)
cpu = simpy.Resource(env, capacity=1)

for i in range(NUM_PROCESOS):
    t_instrucciones = random.randint(1, 10)
    mem_necesaria = random.randint(1, 10)
    env.process(proceso(f'Proceso {i}', env, cpu, ram, t_instrucciones, mem_necesaria))

env.run(until=TIEMPO_SIMULACION)

# Análisis de resultados
print(f'Tiempo promedio: {statistics.mean(tiempos)}')
print(f'Desviación estándar: {statistics.stdev(tiempos)}')
