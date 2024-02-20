import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "estudiante") // Esto hace que la clase sea reconocible por JAXB
public class Estudiante implements IUser {
    private int id;
    private String firstName;
    private String lastName;
    private String type="Estudiante";

    public Estudiante() {
        // Constructor sin argumentos requerido por JAXB
    }

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "type")
    public String getType() {
        // Implementación específica que devuelve el tipo de usuario
        return type;
    }
    
    @Override
    public void showOptions() {
        // Implementación específica para Estudiante
        System.out.println("Opciones de Estudiante");
    }
}
