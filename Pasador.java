public class Pasador extends Jugador {
    private int pases;
    private int fintas;

    //Metodos:

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getFintas() {
        return fintas;
    }

    public void setFintas(int fintas) {
        this.fintas = fintas;
    }
    //Caluclar efectividad Pasadores: ((pases + fintas – errores) * 100 / (pases + fintas + errores)) + aces * 100 / servicios
    public void calcularEfectividad(){
        this.efectividad = ((this.pases + this.fintas - this.errores)*100 / (this.pases + this.fintas + this.errores) + this.aces * 100/this.servicios);
    }
}
