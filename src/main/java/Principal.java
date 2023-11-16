import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Carton> cartones = new ArrayList<>();
        Casino casino = new Casino();

        for (int i = 0; i < 50; i++) {
            cartones.add(new Carton(i + 1));
        }
        ArrayList<Carton> cartonJugador1=new ArrayList<>();
        ArrayList<Carton> cartonJugador2=new ArrayList<>();
        ArrayList<Carton> cartonJugador3=new ArrayList<>();
        ArrayList<Carton> cartonJugador4=new ArrayList<>();
        for(int i=0;i<4;i++){
            cartonJugador1.add(new Carton(i+1));
        }
        for(int i=0;i<2;i++){
            cartonJugador2.add(new Carton(i+1));
        }
        for(int i=0;i<3;i++){
            cartonJugador3.add(new Carton(i+1));
        }
        for(int i=0;i<1;i++){
            cartonJugador4.add(new Carton(i+1));
        }
        Jugador jugador1=new Jugador(1,casino,4,cartonJugador1);
        Jugador jugador2=new Jugador(2,casino,2,cartonJugador2);
        Jugador jugador3=new Jugador(3,casino,3,cartonJugador3);
        Jugador jugador4=new Jugador(4,casino,1,cartonJugador4);
        new Thread(jugador1).start();
        new Thread(jugador2).start();
        new Thread(jugador3).start();
        new Thread(jugador4).start();
        int ronda = 0;
        while (!casino.isBingo()) {
            ronda++;
            casino.nuevoNumero();
            System.out.println("\nRONDA " + ronda + ": " +"El numero tachado es "+ casino.getNumeroActual());
        }

        System.out.println("\nFin de la partida");
        System.exit(0);
    }
}
