public class Jugador implements Runnable {
    //el jugador contara con un id y un carton para jugar

    private int idJugador;
    private Carton cartonJugador;
    private Casino casinoJuego;



    public Jugador(int idJugador, Carton cartonJugador,Casino casinoJuego) {
        this.idJugador = idJugador;
        this.cartonJugador = cartonJugador;
        this.casinoJuego=casinoJuego;
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
