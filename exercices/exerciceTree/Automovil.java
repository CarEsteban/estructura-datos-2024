package exerciceTree;

public class Automovil {
    // Atributos de la clase
    private int modelo; // Ahora modelo es de tipo int
    private double precio;
    private String linea, placa ,marca;
    
    // Constructor con todos los atributos
    public Automovil(String marca, int modelo, double precio, String linea, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.linea = linea;
        this.placa = placa; // Guardar la placa
    }
    
    // Métodos getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() { // El getter para modelo ahora retorna un int
        return modelo;
    }

    public void setModelo(int modelo) { // El setter para modelo ahora acepta un int
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método para mostrar la información del Automovil
    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                ", modelo=" + modelo + // Modelo es un int, por lo que no necesita comillas
                ", precio=" + precio +
                ", linea='" + linea + '\'' +
                '}';
    }
}
