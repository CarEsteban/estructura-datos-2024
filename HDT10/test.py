import unittest
from func import Graph, read_graph_from_file, print_shortest_path, calculate_center_of_graph

class TestGraph(unittest.TestCase):
    def setUp(self):
        self.graph = Graph(4)
        self.graph.add_edge(0, 1, 3)
        self.graph.add_edge(1, 2, 1)
        self.graph.add_edge(2, 3, 2)
        self.graph.add_edge(0, 3, 10)

    def test_floyd_warshall(self):
        dist, next_node = self.graph.floyd_warshall()
        self.assertEqual(dist[0][3], 6)  

    def test_get_path(self):
        dist, next_node = self.graph.floyd_warshall()
        path = self.graph.get_path(next_node, 0, 3)
        self.assertEqual(path, [0, 1, 2, 3])  

    def test_calculate_center_of_graph(self):
        center = calculate_center_of_graph(self.graph)
        self.assertEqual(center, 0)  

if __name__ == '__main__':
    unittest.main()
