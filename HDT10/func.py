import numpy as np

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
    with open(filename, 'r') as file:
        lines = file.readlines()
    num_cities = len(lines)
    graph = Graph(num_cities)
    for line in lines:
        data = line.split()
        city1, city2 = data[0], data[1]
        times = list(map(int, data[2:]))
        graph.add_edge(cities.index(city1), cities.index(city2), times)
    return graph

def print_adjacency_matrix(graph):
    print("Adjacency Matrix:")
    for row in graph.graph:
        print(row)

def print_shortest_path(graph, city1, city2):
    print("Shortest Path from", city1, "to", city2)
    print("Normal Time:", graph.graph[city1][city2][0])
    print("Rainy Time:", graph.graph[city1][city2][1])
    print("Snowy Time:", graph.graph[city1][city2][2])
    print("Storm Time:", graph.graph[city1][city2][3])

def calculate_center_of_graph(graph):
    distances = graph.floyd_warshall()
    eccentricities = [max(row) for row in distances]
    center_index = eccentricities.index(min(eccentricities))
    return center_index