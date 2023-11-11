import java.util.ArrayList;
import java.util.Arrays;

public class Carton {

    int[] linea1 = new int[8];
    int[] linea2 = new int[8];
    int[] linea3 = new int[8];


    public Carton() {

        ArrayList<Integer> numeros = generarNumeros();

        linea1 = rellenarLinea(numeros, 1);
        linea2 = rellenarLinea(numeros, 2);
        linea3 = rellenarLinea(numeros, 3);

    }

    private ArrayList<Integer> generarNumeros() {

        ArrayList<Integer> numeros = new ArrayList<>();

        //Genera una lista de 15 números distintos aleatorios entre 0 y 100:
        while(numeros.size()<15){
            int numero = (int) (Math.random()*100 + 1);

            if(!numeros.contains(numero)){
                numeros.add(numero);
            }

        }
        return numeros;
    }

    private int[] rellenarLinea(ArrayList<Integer> numeros, int id) {
        int[] linea = new int[9];
        ArrayList<Integer> casillasVacias = new ArrayList<>();

        //Genera 4 numeros distintos entre 1 y 8 que serán las casillas vacias de la linea:
        while (casillasVacias.size()<4){
            int vacio = (int) (Math.random()*9);

            if(!casillasVacias.contains(vacio)){
                casillasVacias.add(vacio);
            }
        }

        //Dependiendo de que línea sea:
        int contador;
        if(id==1){
            contador = 0;
        }else if(id==2){
            contador = 5;
        }
        else{
            contador=10;
        }

        //Asigna numeros a cada casilla de las líneas. Si la casilla está vacia se pone 0.
        for (int i = 0; i < 9; i++){
             if (casillasVacias.contains(i)){
                 linea[i] = 0;
             }
             else {
                 linea[i] = numeros.get(contador);
                 contador++;
             }
        }

        return linea;
    }

    @Override
    public String toString() {
        return "Carton{" +
                "\nlinea1=" + Arrays.toString(linea1) +
                ", \nlinea2=" + Arrays.toString(linea2) +
                ", \nlinea3=" + Arrays.toString(linea3) +
                '}';
    }

}
