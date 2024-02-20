import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "administrativo")
public class Administrativo implements IUser {
    private int id;
    private String firstName;
    private String lastName;
    private String type="Administrativo";

    public Administrativo() {
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
        // Implementación específica para Administrativo
        System.out.println("Opciones de Administrativo");
    }
    
}
