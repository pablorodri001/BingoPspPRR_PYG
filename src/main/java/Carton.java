import java.util.ArrayList;
import java.util.Collections;

public class Carton {

    int [][] carton;
    ArrayList<Integer> linea1;
    ArrayList<Integer> linea2;
    ArrayList<Integer> linea3;


    public Carton() {

        ArrayList<Integer> numeros = generarNumeros();

        carton = rellenarCarton(numeros);
        linea1=leerLinea1();
        linea2=leerLinea2();
        linea3=leerLinea3();
    }

    private void cantarLinea(){
        ArrayList<Integer> linea1=leerLinea1();

    }

    public ArrayList<Integer> leerLinea1() {
        ArrayList<Integer> linea1=new ArrayList<>();
        for(int i=0;i<9;i++){
            linea1.add(carton[0][i]);

        }

        return linea1;
    }

    public ArrayList<Integer> leerLinea2() {
        ArrayList<Integer> linea2=new ArrayList<>();
        for(int i=0;i<9;i++){
            linea2.add(carton[1][i]);

        }
        return linea2;
    }
    public ArrayList<Integer> leerLinea3() {
        ArrayList<Integer> linea3=new ArrayList<>();
        for(int i=0;i<9;i++){
            linea3.add(carton[0][i]);

        }
        return linea3;
    }

    private int[][] rellenarCarton(ArrayList<Integer> numeros) {
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

            //Genera 4 números distintos entre 0 y 8 que serán las casillas vacías de la línea::
            while (casillasVacias.size()<4){
                int vacio = (int) (Math.random()*9);

                if(!casillasVacias.contains(vacio)){
                    casillasVacias.add(vacio);
                }
            }

            //Recorre las columnas, si la casilla está vacía pone un -1.
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
        return "Carton{\n" + carton [0][0] + "," + carton [0][1] +","+ carton [0][2] +","+ carton [0][3] +","+ carton [0][4] +","+ carton [0][5] +","+ carton [0][6] +","+ carton [0][7] +","+ carton [0][8] + "\n" +
                carton [1][0] + "," + carton [1][1] +","+ carton [1][2] +","+ carton [1][3] +","+ carton [1][4] +","+ carton [1][5] +","+ carton [1][6] +","+ carton [1][7] +","+ carton [1][8] + "\n" +
                carton [2][0] + "," + carton [2][1] +","+ carton [2][2] +","+ carton [2][3] +","+ carton [2][4] +","+ carton [2][5] +","+ carton [2][6] +","+ carton [2][7] +","+ carton [2][8];

    }
}
