public class UsuarioFactory {

    public static IUser createUser(int type, String firstName, String lastName, int id) {
        IUser user = null;
        switch (type) {
            case 1: // Estudiante
                user = new Estudiante();
                break;
            case 2: // Docente
                user = new Docente();
                break;
            case 3: // Auditor
                user = new Auditor();
                break;
            case 4: // Administrativo
                user = new Administrativo();
                break;
        }
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setId(id);
        }
        return user;
    }
}
