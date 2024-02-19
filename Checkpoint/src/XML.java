import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XML implements IDataSource {

    @Override
    public File saveUsers(List<IUser> users, String path) {
        try {
            // Configurar JAXB y guardar la lista de usuarios en XML
            JAXBContext context = JAXBContext.newInstance(UsersWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            UsersWrapper wrapper = new UsersWrapper();
            wrapper.setUsers(users);

            // Guardar en archivo
            File file = new File(path+".xml");
            marshaller.marshal(wrapper, file);

            return file;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<IUser> getUsersFromFile(File file, int fileType) {
        try {
            // Leer la lista de usuarios desde un archivo XML
            JAXBContext context = JAXBContext.newInstance(UsersWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            UsersWrapper wrapper = (UsersWrapper) unmarshaller.unmarshal(file);
            return wrapper.getUsers();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
