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
        System.out.println("Menú Personal Administrativo:");
        System.out.println("1. Crear Cursos, Docentes y Estudiantes");
        System.out.println("2. Asignar estudiante a curso");
        System.out.println("3. Asignar catedrático a curso");
        System.out.println("4. Asignar pago a catedrático");
        System.out.println("5. Resumen de Notas y Resumen de Pagos de Estudiantes");
        System.out.println("6. Salir");
    }
    
}
