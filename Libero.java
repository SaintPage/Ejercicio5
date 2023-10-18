//Clase de líbero siendo hija de Jugador
public class Libero extends Jugador {
    //Atributo
    private int recibos;
    //Metodos
    //Get y set
    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    //Calcular efectividad Líbero: ((recibos – errores) * 100 / (recibos + errores)) + aces * 100 / servicios
    public void calcularEfectividad(){
        System.out.println("Calcular efectividad de Libero ");
        this.efectividad = ((this.recibos - this.errores)*100 / (this.recibos + this.errores)) + (this.aces *100 /this.servicios);
    }
}
