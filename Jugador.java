//Clase jugador con los datos generales


public class Jugador {
    //Atributos
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int servicios;
    protected double efectividad;
    protected int tipo;

    //Metodos
    public double getEfectividad(){
        return efectividad;
    }

    public void setEfectividad(double efectividad){
        this.efectividad = efectividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getServicios() {
        return servicios;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    public int getTipo(){
        return tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }


    // Se utilizó el override en esta clase para no estar repitiendo lo mismo en cada subclase
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + ", Pais: " + this.pais + ", Efectividad:" + this.efectividad;
    }


}
