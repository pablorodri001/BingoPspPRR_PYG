public class Jugador implements Runnable {
    //el jugador contara con un id y un carton para jugar

    private int idJugador;
    private Carton cartonJugador;



    public Jugador(int idJugador, Carton cartonJugador) {
        this.idJugador = idJugador;
        this.cartonJugador = cartonJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", cartonJugador=" + cartonJugador +
                '}';
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public Carton getCartonJugador() {
        return cartonJugador;
    }

    public void setCartonJugador(Carton cartonJugador) {
        this.cartonJugador = cartonJugador;
    }

    @Override
    public void run() {

    }
}
