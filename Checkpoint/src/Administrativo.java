public class Administrativo implements IUser {
    private String firstName;
    private String lastName;
    private int id;
    private String type ="Administrativo";

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
    public String getType() {
        return type;
    }


    @Override
    public void showOptions() {
        // Implementación específica para Administrativo
        System.out.println("Opciones de Administrativo");
    }
    
}
