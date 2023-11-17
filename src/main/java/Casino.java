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
        //Devuelve la lista con números del 1 al 99 en orden aleatorio.
        numeros = generarNumeros();
        //Contador para saber por qué número vamos de la lista.
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
        //Pasa al siguiente número de la lista
        numeroActual = numeros.get(contador);
        contador++;
    }

    public ArrayList<Integer> generarNumeros() {
        contador = 0;
        numeros = new ArrayList<>();
        while (numeros.size()<99) {
            //Genera un número entre 1 y 99:
            int numero = (int) (Math.random() * 99 + 1);
            if (!numeros.contains(numero)) {
                //Añade el número a la lista
                numeros.add(numero);
            }
        }
        //Devuelve la lista con números del 1 al 99 en orden aleatorio
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

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    public void setNumeroActual(int numeroActual) {
        this.numeroActual = numeroActual;
    }
}
