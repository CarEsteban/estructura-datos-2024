public class Docente implements IUser{

    private String firstName;
    private String lastName;
    private int id;

    // Implementación de los métodos de IUser
    @Override
    public String getFirstName() { return firstName; }

    @Override
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Override
    public String getLastName() { return lastName; }

    @Override
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public int getId() { return id; }

    @Override
    public void setId(int id) { this.id = id; }

    @Override
    public void showOptions() {
        // Implementación específica para Docente
        System.out.println("Opciones de Docente");
    }
}
