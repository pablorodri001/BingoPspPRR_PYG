import java.util.ArrayList;
import java.util.Arrays;

public class Carton {

    int [][] carton;


    public Carton() {

        ArrayList<Integer> numeros = generarNumeros();

        carton = rellenarCarton(numeros);

    }

    private int[][] rellenarCarton(ArrayList<Integer> numeros) {
        int [][] carton = new int[3][9];
        int contador;

        for(int i = 0; i<3; i++){
            ArrayList<Integer> casillasVacias = new ArrayList<>();

            //Genera 4 números distintos entre 0 y 8 que serán las casillas vacías de la línea:
            while (casillasVacias.size()<4){
                int vacio = (int) (Math.random()*9);

                if(!casillasVacias.contains(vacio)){
                    casillasVacias.add(vacio);
                }
            }

            //Dependiendo de que línea sea:
            if(i==0){
                contador = 0;
            }else if(i==1){
                contador = 5;
            }
            else{
                contador=10;
            }

            //Asigna números a cada casilla de las líneas. Si la casilla está vacía pone un 0.
            for (int j = 0; j < 9; j++){
                if (casillasVacias.contains(j)){
                    carton[i][j] = 0;
                }
                else {
                    carton[i][j] = numeros.get(contador);
                    contador++;
                }
            }
        }
        return carton;
    }

    private ArrayList<Integer> generarNumeros() {

        ArrayList<Integer> numeros = new ArrayList<>();

        //Genera una lista de 15 números distintos aleatorios entre 1 y 99:
        while(numeros.size()<15){
            int numero = (int) (Math.random()*100 + 1);

            if(!numeros.contains(numero)){
                numeros.add(numero);
            }
        }
        return numeros;
    }

    @Override
    public String toString() {
        return "Carton{\n" + carton [0][0] + "," + carton [0][1] +","+ carton [0][2] +","+ carton [0][3] +","+ carton [0][4] +","+ carton [0][5] +","+ carton [0][6] +","+ carton [0][7] +","+ carton [0][8] + "\n" +
                carton [1][0] + "," + carton [1][1] +","+ carton [1][2] +","+ carton [1][3] +","+ carton [1][4] +","+ carton [1][5] +","+ carton [1][6] +","+ carton [1][7] +","+ carton [1][8] + "\n" +
                carton [2][0] + "," + carton [2][1] +","+ carton [2][2] +","+ carton [2][3] +","+ carton [2][4] +","+ carton [2][5] +","+ carton [2][6] +","+ carton [2][7] +","+ carton [2][8];

    }
}
