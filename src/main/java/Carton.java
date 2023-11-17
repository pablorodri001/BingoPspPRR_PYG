import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Carton {
    private int precio=1;
    private final int id;
    private int [][] carton;
    private int [][] cartonOriginal;


    private int contadorLinea1;


    public String toString2() {
        return "Carton{" +
                "cartonOriginal=" + "\n" + cartonOriginal [0][0] + "," + cartonOriginal [0][1] +","+ cartonOriginal [0][2] +","+
                cartonOriginal [0][3] +","+ cartonOriginal [0][4] +","+ cartonOriginal [0][5] +","+ cartonOriginal [0][6] +","+ cartonOriginal [0][7] +","+
                cartonOriginal [0][8] + "\n" + cartonOriginal [1][0] + "," + cartonOriginal [1][1] +","+ cartonOriginal [1][2] +","+ cartonOriginal [1][3] +","+
                cartonOriginal [1][4] +","+ cartonOriginal [1][5] +","+ cartonOriginal [1][6] +","+ cartonOriginal [1][7] +","+ cartonOriginal [1][8] + "\n" +
                cartonOriginal [2][0] + "," + cartonOriginal [2][1] +","+ cartonOriginal [2][2] +","+ cartonOriginal [2][3] +","+ cartonOriginal [2][4] +","+
                cartonOriginal [2][5] +","+ cartonOriginal [2][6] +","+ cartonOriginal [2][7] +","+ cartonOriginal [2][8] + "\n"+"}";
    }

    private int contadorLinea2;

    public int[][] getCartonOriginal() {
        return cartonOriginal;
    }

    private int contadorLinea3;


    public Carton(int id) {
        this.id=id;

        contadorLinea1=0;
        contadorLinea2=0;
        contadorLinea3=0;

        carton = rellenarCarton();
    }

    private int[][] rellenarCarton() {
        ArrayList<Integer> numeros = generarNumeros();
        int [][] carton = seleccionarVacias();
        int contador=0;

        //Recorrer columnas:
        for (int j=0; j<9; j++){

            //Recorrer filas de cada columna: Si el valor es -1 se cambia por 0 (casilla vacía), si no se mete uno de los números.
            for(int i = 0; i<3; i++){
                if (carton[i][j] == -1){
                    carton[i][j] = 0;
                }
                else if (carton [i][j] != -1){
                    carton[i][j] = numeros.get(contador);
                    contador++;
                }
            }
        }
        return carton;
    }

    private int[][] seleccionarVacias() {
        int [][] carton = new int[3][9];

        //Recorrer filas:
        for(int i = 0; i<3; i++){
            ArrayList<Integer> casillasVacias = new ArrayList<>();

            //Genera 4 números distintos entre 0 y 8 que serán las casillas vacías de la línea:
            while (casillasVacias.size()<4){
                int vacio = (int) (Math.random()*9);

                if(!casillasVacias.contains(vacio)){
                    casillasVacias.add(vacio);
                }
            }

            //Recorre las columnas, si la casilla coincide con alguno de los números generados pone un -1 (Casilla vacía).
            for (int j = 0; j < 9; j++){
                if (casillasVacias.contains(j)){
                    carton[i][j] = -1;
                }
            }
        }

        return carton;
    }

    private ArrayList<Integer> generarNumeros() {

        ArrayList<Integer> numeros = new ArrayList<>();

        //Genera una lista de 15 números distintos aleatorios entre 1 y 99:
        while(numeros.size()<15){
            int numero = (int) (Math.random()*99 + 1);

            if(!numeros.contains(numero)){
                numeros.add(numero);
            }
        }
        Collections.sort(numeros);
        return numeros;
    }

    @Override
    public String toString() {
        return "Carton " + this.id + "{\n" + carton [0][0] + "," + carton [0][1] +","+ carton [0][2] +","+
                carton [0][3] +","+ carton [0][4] +","+ carton [0][5] +","+ carton [0][6] +","+ carton [0][7] +","+
                carton [0][8] + "\n" + carton [1][0] + "," + carton [1][1] +","+ carton [1][2] +","+ carton [1][3] +","+
                carton [1][4] +","+ carton [1][5] +","+ carton [1][6] +","+ carton [1][7] +","+ carton [1][8] + "\n" +
                carton [2][0] + "," + carton [2][1] +","+ carton [2][2] +","+ carton [2][3] +","+ carton [2][4] +","+
                carton [2][5] +","+ carton [2][6] +","+ carton [2][7] +","+ carton [2][8] + "\n";

    }

    public int[][] getCarton() {
        return carton;
    }

    public void tacharNumero(int i, int j){
        carton[i][j] = 0;
    }

    public int getContadorLinea1() {
        return contadorLinea1;
    }

    public int getContadorLinea2() {
        return contadorLinea2;
    }

    public int getContadorLinea3() {
        return contadorLinea3;
    }

    public int getId() {
        return id;
    }

    public void aumentarContador(int i) {
        if (i==0){
            contadorLinea1++;
        }
        else if (i==1){
            contadorLinea2++;
        }
        else {
            contadorLinea3++;
        }
    }
}
