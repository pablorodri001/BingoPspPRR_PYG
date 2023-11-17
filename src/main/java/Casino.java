import java.util.ArrayList;

public class Casino {
    private boolean linea;
    private boolean bingo;
    private int numeroActual;
    private int contador;
    ArrayList<Integer> numeros;

    public Casino() {
        linea=false;
        bingo = false;
        numeros = generarNumeros();
        contador = 0;
    }

    public void comprobarCarton(Carton carton, Jugador jugador) {
        //Recorre las filas
        for (int i = 0; i < 3; i++) {

            //Recorre las columnas
            for (int j = 0; j < 9; j++) {

                //Comprueba si el número coincide
                if (numeroActual == carton.getCarton()[i][j]) {
                    carton.tacharNumero(i, j);
                    carton.aumentarContador(i);
                    System.out.println("El jugador " + jugador.getIdJugador() + " ha tachado el número del cartón " + carton.getId());

                    //Comprueba la línea si aún no se ha cantado
                    if (!linea && (carton.getContadorLinea1() == 5 || carton.getContadorLinea2() == 5 || carton.getContadorLinea3() == 5)) {
                        System.out.println("\nEl jugador " + jugador.getIdJugador() + " ha cantado una línea del cartón " + carton.getId() + "\n" + carton);
                        linea = true;
                    }

                    //Comprueba si hay bingo
                    else if (linea && carton.getContadorLinea1() == 5 && carton.getContadorLinea2() == 5 && carton.getContadorLinea3() == 5) {
                        System.out.println("\nEl jugador " + jugador.getIdJugador() + " ha cantado Bingo! " + "\n" + carton);
                        bingo = true;
                    }
                }
            }
        }
    }
    public void nuevoNumero(){
        numeroActual = numeros.get(contador);
        contador++;
    }

    public ArrayList<Integer> generarNumeros() {
        numeros = new ArrayList<>();
        while (numeros.size()<99) {
            //Genera un número entre 1 y 99:
            int numero = (int) (Math.random() * 99 + 1);
            if (!numeros.contains(numero)) {
                //Añade el número
                numeros.add(numero);
            }
        }
        return numeros;
    }

    public boolean isLinea() {
        return linea;
    }

    public void setLinea(boolean linea) {
        this.linea = linea;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    public boolean isBingo() {
        return bingo;
    }

    public void setBingo(boolean bingo) {
        this.bingo = bingo;
    }

    public void setNumeroActual(int numeroActual) {
        this.numeroActual = numeroActual;
    }
}
