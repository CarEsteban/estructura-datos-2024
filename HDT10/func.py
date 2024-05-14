import numpy as np
import pandas as pd

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[float('inf')] * self.V for _ in range(self.V)]

    def add_edge(self, u, v, weight):
        self.graph[u][v] = weight

    def floyd_warshall(self):
        dist = self.graph
        for k in range(self.V):
            for i in range(self.V):
                for j in range(self.V):
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        return dist

def read_graph_from_file(filename):
    df = pd.read_csv(filename, sep=" ", header=0)
    cities = list(set(df["Ciudad1"].tolist() + df["Ciudad2"].tolist()))
    num_cities = len(cities)
    graph = Graph(num_cities)
    for index, row in df.iterrows():
        city1, city2 = row["Ciudad1"], row["Ciudad2"]
        times = [row["tiempoNormal"], row["tiempoLluvia"], row["tiempoNieve"], row["tiempoTormenta"]]
        graph.add_edge(cities.index(city1), cities.index(city2), times)
    return graph, cities

def print_adjacency_matrix(graph):
    print("Adjacency Matrix:")
    for row in graph.graph:
        print(row)

def print_shortest_path(graph, city1, city2):
    print("Shortest Path from", city1, "to", city2)
    print("Normal Time:", graph.graph[city1][city2])

def calculate_center_of_graph(graph):
    distances = graph.floyd_warshall()
    eccentricities = [max(row) for row in distances]
    center_index = eccentricities.index(min(eccentricities))
    return center_index

# Lectura del archivo y construcción del grafo
graph, cities = read_graph_from_file("HDT10\logistica.txt")

# Prueba de las funciones
print_adjacency_matrix(graph)
print_shortest_path(graph, 0, 1)
print("Center of the graph:", cities[calculate_center_of_graph(graph)])
