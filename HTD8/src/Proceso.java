public class Proceso  {
    String nombreProceso;
    String usuario;
    int niceValue;
    int prioridad; // PR calculado a partir del niceValue

    // Constructor, getters, setters, etc.
    public Proceso(String nombreProceso, String usuario, int niceValue){
        this.nombreProceso = nombreProceso;
        this.usuario = usuario;
        this.niceValue = niceValue;
        this.prioridad = 120 + niceValue;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public int getNiceValue() {
        return niceValue;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

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
