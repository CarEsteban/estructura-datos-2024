import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auditor")
public class Auditor implements IUser {
    private int id;
    private String firstName;
    private String lastName;
    private String type="Auditor";

    public Auditor() {
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
        System.out.println("Menú Auditor Externo:");
        System.out.println("1. Revisar notas");
        System.out.println("2. Revisar cuotas pagadas de estudiantes");
        System.out.println("3. Revisar Pagos a docentes");
        System.out.println("4. Salir");
    }
    
}
