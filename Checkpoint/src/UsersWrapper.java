import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
public class UsersWrapper {
    private List<IUser> users;

    @XmlElement(name = "user")
    public List<IUser> getUsers() {
        return users;
    }

    public void setUsers(List<IUser> users) {
        this.users = users;
    }
}
