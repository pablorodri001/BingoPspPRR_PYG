import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Casino casino = new Casino();

        ArrayList<Carton> cartonJugador1=new ArrayList<>();
        ArrayList<Carton> cartonJugador2=new ArrayList<>();
        ArrayList<Carton> cartonJugador3=new ArrayList<>();
        ArrayList<Carton> cartonJugador4=new ArrayList<>();

        Jugador jugador1=new Jugador(1,casino,40, cartonJugador1);
        Jugador jugador2=new Jugador(2,casino,40, cartonJugador2);
        Jugador jugador3=new Jugador(3,casino,40, cartonJugador3);
        Jugador jugador4=new Jugador(4,casino,40, cartonJugador4);

        System.out.print("Cuantos jugadores? (1-4): ");
        int nJugadores = solicitarInt();
        int maxCartones = 12;
        ArrayList<Jugador> jugadores = new ArrayList<>();

        switch(nJugadores){
            case 1:
                System.out.print("Creditos del jugador: ");
                jugador1.setCredito(solicitarInt());
                jugadores.add(jugador1);
                maxCartones = 50;
                break;
            case 2:
                System.out.print("Creditos del jugador 1: ");
                jugador1.setCredito(solicitarInt());
                System.out.print("Creditos del jugador 2: ");
                jugador2.setCredito(solicitarInt());

                jugadores.add(jugador1);
                jugadores.add(jugador2);
                maxCartones = 25;
                break;
            case 3:
                System.out.print("Creditos del jugador 1: ");
                jugador1.setCredito(solicitarInt());
                System.out.print("Creditos del jugador 2: ");
                jugador2.setCredito(solicitarInt());
                System.out.print("Creditos del jugador 3: ");
                jugador3.setCredito(solicitarInt());

                jugadores.add(jugador1);
                jugadores.add(jugador2);
                jugadores.add(jugador3);
                maxCartones = 16;
                break;
            case 4:
                System.out.print("Creditos del jugador 1: ");
                jugador1.setCredito(solicitarInt());
                System.out.print("Creditos del jugador 2: ");
                jugador2.setCredito(solicitarInt());
                System.out.print("Creditos del jugador 3: ");
                jugador3.setCredito(solicitarInt());
                System.out.print("Creditos del jugador 4: ");
                jugador4.setCredito(solicitarInt());

                jugadores.add(jugador1);
                jugadores.add(jugador2);
                jugadores.add(jugador3);
                jugadores.add(jugador4);
        }

        System.out.println(" ");

        ArrayList<Carton> cartones = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            cartones.add(new Carton(i + 1));
        }

        int contador = 0;

        for (Jugador jugador : jugadores) {
            ArrayList<Carton> cartonesAnhadir = new ArrayList<>();
            while (jugador.getCredito() >= 2 && cartonesAnhadir.size() < maxCartones && contador < 50) {
                cartonesAnhadir.add(cartones.get(contador));
                jugador.setCredito(jugador.getCredito() - 2);
                contador++;
            }
            jugador.setCartones(cartonesAnhadir);
            System.out.println("El jugador " + jugador.getIdJugador() + " ha recibido " + cartonesAnhadir.size() + " cartones.");
        }

        int ronda = 1;

        while (!casino.isBingo()) {
            casino.nuevoNumero();
            System.out.println("\nRONDA " + ronda + ": " + "El numero tachado es " + casino.getNumeroActual());

            Thread[] hilos = new Thread[4];

            hilos[0] = new Thread(jugador1);
            hilos[1] = new Thread(jugador2);
            hilos[2] = new Thread(jugador3);
            hilos[3] = new Thread(jugador4);

            for (Thread hilo : hilos) {
                hilo.start();
            }

            for (Thread hilo : hilos) {
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            ronda++;
        }

        System.out.print("\nFin de la partida.");

        System.exit(0);
    }

    private static int solicitarInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
