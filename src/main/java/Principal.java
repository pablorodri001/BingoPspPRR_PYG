public class Principal {
    public static void main(String[] args) {
        for(int i=0;i<50;i++){
            Jugador jugador =new Jugador(i+1,new Carton());
            System.out.println(jugador.toString());
        }
    }



}
