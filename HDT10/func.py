import numpy as np
import pandas as pd

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[float('inf')] * self.V for _ in range(self.V)]
        for i in range(self.V):
            self.graph[i][i] = 0

    def add_edge(self, u, v, weight):
        self.graph[u][v] = weight

    def floyd_warshall(self):
        dist = [row[:] for row in self.graph]
        next_node = [[None if i == j or dist[i][j] == float('inf') else j for j in range(self.V)] for i in range(self.V)]
        for k in range(self.V):
            for i in range(self.V):
                for j in range(self.V):
                    if dist[i][j] > dist[i][k] + dist[k][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
                        next_node[i][j] = next_node[i][k]
        return dist, next_node

    def get_path(self, next_node, u, v):
        if next_node[u][v] is None:
            return []
        path = [u]
        while u != v:
            u = next_node[u][v]
            path.append(u)
        return path

def read_graph_from_file(filename):
    df = pd.read_csv(filename, sep=" ", header=0)
    cities = list(set(df["Ciudad1"].tolist() + df["Ciudad2"].tolist()))
    num_cities = len(cities)
    graph = Graph(num_cities)
    for index, row in df.iterrows():
        city1, city2 = row["Ciudad1"], row["Ciudad2"]
        weight = row["tiempoNormal"]  # Usando tiempoNormal para el cálculo
        graph.add_edge(cities.index(city1), cities.index(city2), weight)
    return graph, cities

def write_connection_to_file(filename, city1, city2, tiempo_normal, tiempo_lluvia, tiempo_nieve, tiempo_tormenta):
    with open(filename, 'a') as file:
        file.write(f"{city1} {city2} {tiempo_normal} {tiempo_lluvia} {tiempo_nieve} {tiempo_tormenta}\n")

def print_adjacency_matrix(graph):
    print("Adjacency Matrix:")
    for row in graph.graph:
        print(row)

def print_shortest_path(graph, city1, city2, cities):
    dist, next_node = graph.floyd_warshall()
    index1 = cities.index(city1)
    index2 = cities.index(city2)
    path = graph.get_path(next_node, index1, index2)
    path_names = [cities[i] for i in path]
    print(f"Shortest Path from {city1} to {city2}: {dist[index1][index2]}")
    print("Path:", " -> ".join(path_names))

def calculate_center_of_graph(graph):
    distances, _ = graph.floyd_warshall()
    eccentricities = [max(row) for row in distances]
    center_index = eccentricities.index(min(eccentricities))
    return center_index

def modify_graph(graph, cities, filename):
    print("\nModificar el grafo:")
    print("1. Interrupción de tráfico entre un par de ciudades")
    print("2. Establecer una conexión entre dos ciudades")
    print("3. Cambiar el clima entre un par de ciudades")
    modify_option = int(input("Ingrese una opción de modificación: "))

    if modify_option == 1:
        city1 = input("Ingrese la primera ciudad: ").strip()
        city2 = input("Ingrese la segunda ciudad: ").strip()
        if city1 in cities and city2 in cities:
            graph.add_edge(cities.index(city1), cities.index(city2), float('inf'))
            print(f"Interrupción de tráfico entre {city1} y {city2} registrada.")
        else:
            print("Una o ambas ciudades ingresadas no existen en la lista de ciudades.")
    
    elif modify_option == 2:
        city1 = input("Ingrese la primera ciudad: ").strip()
        city2 = input("Ingrese la segunda ciudad: ").strip()
        tiempo_normal = float(input("Ingrese el tiempo normal: "))
        tiempo_lluvia = float(input("Ingrese el tiempo con lluvia: "))
        tiempo_nieve = float(input("Ingrese el tiempo con nieve: "))
        tiempo_tormenta = float(input("Ingrese el tiempo con tormenta: "))
        if city1 in cities and city2 in cities:
            graph.add_edge(cities.index(city1), cities.index(city2), tiempo_normal)
            write_connection_to_file(filename, city1, city2, tiempo_normal, tiempo_lluvia, tiempo_nieve, tiempo_tormenta)
            print(f"Conexión entre {city1} y {city2} establecida y guardada en el archivo.")
        else:
            print("Una o ambas ciudades ingresadas no existen en la lista de ciudades.")
    
    elif modify_option == 3:
        city1 = input("Ingrese la primera ciudad: ").strip()
        city2 = input("Ingrese la segunda ciudad: ").strip()
        clima = input("Ingrese el clima (normal, lluvia, nieve, tormenta): ").strip().lower()
        if city1 in cities and city2 in cities:
            if clima == "normal":
                tiempo = float(input("Ingrese el tiempo normal: "))
            elif clima == "lluvia":
                tiempo = float(input("Ingrese el tiempo con lluvia: "))
            elif clima == "nieve":
                tiempo = float(input("Ingrese el tiempo con nieve: "))
            elif clima == "tormenta":
                tiempo = float(input("Ingrese el tiempo con tormenta: "))
            else:
                print("Clima no reconocido.")
                return
            graph.add_edge(cities.index(city1), cities.index(city2), tiempo)
            print(f"Clima entre {city1} y {city2} actualizado.")
        else:
            print("Una o ambas ciudades ingresadas no existen en la lista de ciudades.")
    else:
        print("Opción de modificación no válida.")
