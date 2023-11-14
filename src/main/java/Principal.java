public class Principal {
    public static void main(String[] args) {
        for(int i=0;i<50;i++){
            Jugador jugador =new Jugador(i+1,new Carton());
            System.out.println(jugador.toString());
        }

        /*
        System.out.println(prueba);
        cantarlinea(carton);
            */
    }


    private static void cantarlinea(Carton carton) {
        boolean linea=false;
        int contadorLinea=0;
        int contadorLinea2=0;
        int contadorLinea3=0;
        do{
            int numeroGenerado=calcularNumeroAleatorio();
            if(carton.linea1.contains(numeroGenerado)){
                System.out.println(numeroGenerado);
                contadorLinea++;
            }
            else if(carton.linea2.contains(numeroGenerado)){
                System.out.println(numeroGenerado);
                contadorLinea2++;
            }
            else if(carton.linea3.contains(numeroGenerado)){
                System.out.println(numeroGenerado);
                contadorLinea3++;
            }
            if(contadorLinea==5){
                linea=true;
                System.out.println("Han cantado Linea 1: "+carton.linea1.toString());
            }
            if(contadorLinea2==5){
                linea=true;
                System.out.println("Han cantado la Linea 2 : "+carton.linea2.toString());
            }
            if(contadorLinea3==5){
                linea=true;
                System.out.println("Han cantado la Linea 3: " +carton.linea2.toString());
            }
        }while(!linea);

    }
    private static int calcularNumeroAleatorio() {
        int numero = (int) (Math.random()*99 + 1);
        return numero;

    }
}
