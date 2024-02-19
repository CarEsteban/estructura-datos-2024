import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Estudiante.class, Docente.class, Administrativo.class, Auditor.class})
public interface IUser {
    
    String getFirstName() ;
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    int getId();
    void setId(int id);

    void showOptions();
} 