from func import *
cities = ["BuenosAires", "SaoPaulo", "Lima", "Quito"]

def main():
    graph = read_graph_from_file("logistica.txt")
    while True:
        print("\n Opciones:")
        print("1. Encontrar la ruta mas corta entre 2 ciuidades")
        print("2. Calcular el centro del grafo")
        print("3. Modificar el grafo")
        print("4. Salir")
        option = int(input("Ingrese una opción: "))
        
        if option == 1:
            city1 = cities.index(input("Ingrese la ciudad de origen: "))
            city2 = cities.index(input("Ingrese la ciudad de destino: "))
            print_shortest_path(graph, city1, city2)
        elif option == 2:
            center_index = calculate_center_of_graph(graph)
            print("El centro del grafo es:", cities[center_index])
        elif option == 3:
            
            pass
        elif option == 4:
            print("Saliendo del programa")
            break
        else:
            print("Opcion invalida, intente de nuevo.")

if __name__ == "__main__":
    main()