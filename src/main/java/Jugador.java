import java.util.ArrayList;

public class Jugador implements Runnable {
    private int idJugador;
    private Casino casinoJuego;
    private ArrayList<Carton> cartones;


    public Jugador(int idJugador, Casino casinoJuego, ArrayList<Carton> cartones) {
        this.idJugador = idJugador;
        this.casinoJuego=casinoJuego;
        this.cartones=cartones;
    }

    @Override
    public void run() {

        for (Carton carton : cartones){
            //Comprobar cada cartón
            if (!casinoJuego.isBingo()) {
                casinoJuego.comprobarCarton(carton,this);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIdJugador() {
        return idJugador;
    }
}
