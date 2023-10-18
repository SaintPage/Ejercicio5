public class Auxiliar extends Jugador {
    //Atributos
    private int ataques;
    private int bloqueosFallidos;
    private int bloqueosEfectivos;

    //Metodos:
    //getters y setters

    public int getAtaques() {
        return ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    //Calcular efectividad de auxiliares ((ataques + bloqueos efectivos – bloqueos fallidos – errores) * 100 / (ataques +
    //bloqueos efectivos + bloqueos fallidos + errores)) + aces * 100 / servicios
    public void calcularEfectividad(){
        this.efectividad = ((this.ataques + this.bloqueosEfectivos - this.bloqueosFallidos - this.errores)* 100 / (this.ataques + this.bloqueosEfectivos
        + this.bloqueosFallidos + this.errores) + this.aces *100 / this.servicios);
    }
}
