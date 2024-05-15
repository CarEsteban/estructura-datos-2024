import unittest
from func import Graph, read_graph_from_file, print_shortest_path, calculate_center_of_graph, print_adjacency_matrix
import io
import sys

class TestGraph(unittest.TestCase):
    def setUp(self):
        self.graph = Graph(4)
        self.graph.add_edge(0, 1, 3)
        self.graph.add_edge(1, 2, 1)
        self.graph.add_edge(2, 3, 2)
        self.graph.add_edge(0, 3, 10)

    def test_floyd_warshall(self):
        dist, next_node = self.graph.floyd_warshall()
        self.assertEqual(dist[0][3], 6)  # Shortest path from 0 to 3

    def test_get_path(self):
        dist, next_node = self.graph.floyd_warshall()
        path = self.graph.get_path(next_node, 0, 3)
        self.assertEqual(path, [0, 1, 2, 3])  # Path from 0 to 3

    def test_calculate_center_of_graph(self):
        center = calculate_center_of_graph(self.graph)
        self.assertEqual(center, 0)  # Center node of the graph

    def test_adjacency_matrix(self):
        expected_output = [
            [0, 3, float('inf'), 10],
            [float('inf'), 0, 1, float('inf')],
            [float('inf'), float('inf'), 0, 2],
            [float('inf'), float('inf'), float('inf'), 0]
        ]
        self.assertEqual(self.graph.graph, expected_output)

    def test_print_adjacency_matrix(self):
        captured_output = io.StringIO()          # Create StringIO object
        sys.stdout = captured_output             # Redirect stdout.
        print_adjacency_matrix(self.graph)       # Call function.
        sys.stdout = sys.__stdout__              # Reset redirect.
        output = captured_output.getvalue().strip().split("\n")
        expected_output = [
            "Adjacency Matrix:",
            "[0, 3, inf, 10]",
            "[inf, 0, 1, inf]",
            "[inf, inf, 0, 2]",
            "[inf, inf, inf, 0]"
        ]
        self.assertEqual(output, expected_output)

if __name__ == '__main__':
    unittest.main()
