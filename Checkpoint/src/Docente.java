import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "docente")
public class Docente implements IUser {
    private int id;
    private String firstName;
    private String lastName;
    private String type="Docente";

    public Docente() {
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
        return type;
    }

    
    @Override
    public void showOptions() {
        // Implementación específica para Docente
        System.out.println("Opciones de Docente");
    }
}
