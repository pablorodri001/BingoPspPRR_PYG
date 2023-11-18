import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Crear casino:
        Casino casino = new Casino();

        //Crear listas de cartones para los jugadores:
        ArrayList<Carton> cartonJugador1=new ArrayList<>();
        ArrayList<Carton> cartonJugador2=new ArrayList<>();
        ArrayList<Carton> cartonJugador3=new ArrayList<>();
        ArrayList<Carton> cartonJugador4=new ArrayList<>();

        //Crear jugadores:
        Jugador jugador1=new Jugador(1,casino,0, cartonJugador1);
        Jugador jugador2=new Jugador(2,casino,0, cartonJugador2);
        Jugador jugador3=new Jugador(3,casino,0, cartonJugador3);
        Jugador jugador4=new Jugador(4,casino,0, cartonJugador4);

        //Pedir número de jugadores:
        System.out.println("\n\n******  BINGO  ******");
        System.out.print("Cuántos jugadores? (1-4): ");
        int nJugadores = solicitarInt();
        int maxCartones = 0;

        //Pedir créditos de jugadores y asignar un máximo de cartones en función del número de jugadores:
        ArrayList<Jugador> jugadores = new ArrayList<>();
        switch(nJugadores){
            case 1:
                System.out.print("Créditos del jugador: ");
                jugador1.setCredito(solicitarInt());

                jugadores.add(jugador1);

                maxCartones = 50;
                break;

            case 2:
                System.out.print("Créditos del jugador 1: ");
                jugador1.setCredito(solicitarInt());
                System.out.print("Créditos del jugador 2: ");
                jugador2.setCredito(solicitarInt());

                jugadores.add(jugador1);
                jugadores.add(jugador2);

                maxCartones = 25;
                break;

            case 3:
                System.out.print("Créditos del jugador 1: ");
                jugador1.setCredito(solicitarInt());
                System.out.print("Créditos del jugador 2: ");
                jugador2.setCredito(solicitarInt());
                System.out.print("Créditos del jugador 3: ");
                jugador3.setCredito(solicitarInt());

                jugadores.add(jugador1);
                jugadores.add(jugador2);
                jugadores.add(jugador3);

                maxCartones = 16;
                break;

            case 4:
                System.out.print("Créditos del jugador 1: ");
                jugador1.setCredito(solicitarInt());
                System.out.print("Créditos del jugador 2: ");
                jugador2.setCredito(solicitarInt());
                System.out.print("Créditos del jugador 3: ");
                jugador3.setCredito(solicitarInt());
                System.out.print("Créditos del jugador 4: ");
                jugador4.setCredito(solicitarInt());

                jugadores.add(jugador1);
                jugadores.add(jugador2);
                jugadores.add(jugador3);
                jugadores.add(jugador4);

                maxCartones = 12;
        }

        System.out.println(" ");

        //Crear los 50 cartones de la partida
        ArrayList<Carton> cartones = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            cartones.add(new Carton(i + 1));
        }

        //Contador de cartones repartidos:
        int contador = 0;

        //Repartir cartones entre los jugadores
        for (Jugador jugador : jugadores) {
            ArrayList<Carton> cartonesAnhadir = new ArrayList<>();

            //El jugador debe tener suficientes créditos, no puede pasarse del máximo y no pueden repartirse más de 50 cartones:
            while (jugador.getCredito() >= 2 && cartonesAnhadir.size() < maxCartones && contador < 50) {

                //Añadir cartón:
                cartonesAnhadir.add(cartones.get(contador));
                //Restar 2 créditos:
                jugador.setCredito(jugador.getCredito() - 2);
                //Aumentar contador de cartones repartidos:
                contador++;
            }

            //Pasarle el array con sus cartones al jugador:
            jugador.setCartones(cartonesAnhadir);
            System.out.println("El jugador " + jugador.getIdJugador() + " ha recibido " + cartonesAnhadir.size() + " cartones.");
        }

        //Contador de rondas
        int ronda = 1;

        //Empieza la partida:
        while (!casino.isBingo()) {
            //Sacar nuevo número:
            casino.nuevoNumero();
            System.out.println("\nRONDA " + ronda + ": " + "El número tachado es " + casino.getNumeroActual());

            //Crear array para meter los hilos
            Thread[] hilos = new Thread[4];

            //Crear hilos para cada jugador
            hilos[0] = new Thread(jugador1);
            hilos[1] = new Thread(jugador2);
            hilos[2] = new Thread(jugador3);
            hilos[3] = new Thread(jugador4);

            //Iniciar los hilos
            for (Thread hilo : hilos) {
                hilo.start();
            }

            //Join para cada hilo. El programa espera a que todos los hilos con join terminen antes de continuar.
            for (Thread hilo : hilos) {
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //Aumentar contador de ronda.
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
