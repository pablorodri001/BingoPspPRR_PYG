import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Carton> cartones = new ArrayList<>();
        Casino casino = new Casino();

        for (int i = 0; i < 50; i++) {
            cartones.add(new Carton(i + 1));
        }

        Jugador jugador = new Jugador(1, casino, cartones);

        int ronda = 0;
        while (!casino.isBingo()) {
            ronda++;
            casino.nuevoNumero();
            System.out.println("\nRONDA " + ronda + ": " + casino.getNumeroActual());
            jugador.run();
        }

        System.out.println("\nFin de la partida");
        System.exit(0);
    }
}
