public class Proceso  {
    String nombreProceso;
    String usuario;
    int niceValue;
    int prioridad; // PR calculado a partir del niceValue

    /**
     * Constructor de la clase Proceso
     * @param nombreProceso
     * @param usuario
     * @param niceValue
     */
    public Proceso(String nombreProceso, String usuario, int niceValue){
        this.nombreProceso = nombreProceso;
        this.usuario = usuario;
        this.niceValue = niceValue;
        this.prioridad = 120 + niceValue;
    }
    /**
     * Método que devuelve la prioridad del proceso
     * @return prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }
    /**
     * Método que devuelve el nombre del proceso
     * @return nombreProceso
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Método que devuelve el niceValue del proceso
     * @return niceValue
     */
    public int getNiceValue() {
        return niceValue;
    }
    /**
     * Método que devuelve el nombre del proceso
     * @return nombreProceso
     */
    public String getNombreProceso() {
        return nombreProceso;
    }
    /**
     * Método que establece la prioridad del proceso
     * @param prioridad
     */
    @Override
    public String toString() {
        return "Proceso{" +
            "nombreProceso='" + nombreProceso + '\'' +
            ", usuario='" + usuario + '\'' +
            ", niceValue=" + niceValue +
            ", prioridad=" + prioridad +
            '}';
    }
}
