import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Casino casino = new Casino();
        ArrayList<Carton> cartonJugador1=new ArrayList<>();
        ArrayList<Carton> cartonJugador2=new ArrayList<>();
        ArrayList<Carton> cartonJugador3=new ArrayList<>();
        ArrayList<Carton> cartonJugador4=new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            if (i<12){
                cartonJugador1.add(new Carton(i+1));
            }
            else if (i<25){
                cartonJugador2.add(new Carton(i+1));
            }
            else if (i<37){
                cartonJugador3.add(new Carton(i+1));
            }
            else {
                cartonJugador4.add(new Carton(i+1));
            }
        }

        Jugador jugador1=new Jugador(1,casino,4,cartonJugador1);
        Jugador jugador2=new Jugador(2,casino,2,cartonJugador2);
        Jugador jugador3=new Jugador(3,casino,3,cartonJugador3);
        Jugador jugador4=new Jugador(4,casino,1,cartonJugador4);

        int ronda = 1;

        while (!casino.isBingo()) {
            casino.nuevoNumero();
            System.out.println("\nRONDA " + ronda + ": " +"El numero tachado es "+ casino.getNumeroActual());

            Thread[] hilos = new Thread[4];

            hilos[0] = new Thread(jugador1);
            hilos[1] = new Thread(jugador2);
            hilos[2] = new Thread(jugador3);
            hilos[3] = new Thread(jugador4);

            for (Thread hilo : hilos){
                hilo.start();
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            ronda++;
        }

        System.out.println("\nFin de la partida");
        System.exit(0);
    }
}
