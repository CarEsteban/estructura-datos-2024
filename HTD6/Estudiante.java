public class Estudiante {
    private String name;
    private String phone;
    private String email;
    private String postalZip;
    private String country;

    /**
     * Constructor de la clase Estudiante
     * @param name
     * @param phone
     * @param email
     * @param postalZip
     * @param country
     */
    public Estudiante(String name, String phone, String email, String postalZip, String country) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.postalZip = postalZip;
        this.country = country;
    }

    /**
     * Método que retorna el nombre del estudiante
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Método que retorna el teléfono del estudiante
     * @return phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Método que retorna el correo del estudiante
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Método que retorna el código postal del estudiante
     * @return postalZip
     */
    public String getPostalZip() {
        return postalZip;
    }
    /**
     * Método que retorna el país del estudiante
     * @return country
     */
    public String getCountry() {
        return country;
    }
    /**
     * Método que retorna el hash del nombre del estudiante
     * @return hashName
     */
    @Override
    public String toString() {
        return "Estudiante{" +
               "name='" + name + '\'' +
               ", phone='" + phone + '\'' +
               ", email='" + email + '\'' +
               ", postalZip='" + postalZip + '\'' +
               ", country='" + country + '\'' +
               '}';
    }
}
