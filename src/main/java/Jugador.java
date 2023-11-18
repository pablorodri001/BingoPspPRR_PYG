import java.util.ArrayList;

public class Jugador implements Runnable {
    private final int idJugador;
    private int credito;
    private final Casino casinoJuego;
    private ArrayList<Carton> cartones;

    public Jugador(int idJugador, Casino casinoJuego,int credito, ArrayList<Carton> cartones) {
        this.idJugador = idJugador;
        this.casinoJuego = casinoJuego;
        this.credito = credito;
        this.cartones = cartones;
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
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setCartones(ArrayList<Carton> cartones) {
        this.cartones = cartones;
    }
}
