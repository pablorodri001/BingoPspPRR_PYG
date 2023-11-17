import java.util.ArrayList;

public class Jugador implements Runnable {
    //comentario prueba git
    private int idJugador;
    private int credito;
    private Casino casinoJuego;

    public ArrayList<Carton> getCartones() {
        return cartones;
    }

    public void setCartones(ArrayList<Carton> cartones) {
        this.cartones = cartones;
    }

    private ArrayList<Carton> cartones;


    public Jugador(int idJugador, Casino casinoJuego,int credito, ArrayList<Carton> cartones) {
        this.idJugador = idJugador;
        this.casinoJuego=casinoJuego;
        this.credito=credito;
        this.cartones=cartones;
    }

    @Override
    public void run() {

        for (Carton carton : cartones){
            //Comprobar cada cartón
            if (!casinoJuego.isBingo()) {
                casinoJuego.comprobarCarton(carton,this);
            }
           /* try{
                Thread.sleep(250);
            }
            catch (Exception e){
                e.printStackTrace();
            }*/
        }
    }

    public int getIdJugador() {
        return idJugador;
    }
}
