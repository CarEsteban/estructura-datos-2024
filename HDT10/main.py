def main():
    graph = read_graph_from_file("logistica.txt")
    while True:
        print("\nOptions:")
        print("1. Find shortest path between two cities")
        print("2. Calculate center of the graph")
        print("3. Modify the graph")
        print("4. Exit")
        option = int(input("Enter your choice: "))
        
        if option == 1:
            city1 = cities.index(input("Enter origin city: "))
            city2 = cities.index(input("Enter destination city: "))
            print_shortest_path(graph, city1, city2)
        elif option == 2:
            center_index = calculate_center_of_graph(graph)
            print("The center of the graph is:", cities[center_index])
        elif option == 3:
            # Implement graph modification options
            pass
        elif option == 4:
            print("Exiting program...")
            break
        else:
            print("Invalid option. Please try again.")

if __name__ == "__main__":
    main()