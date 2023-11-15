public class Principal {
    public static void main(String[] args) {
        Casino casino=new Casino();
        for(int i=0;i<50;i++){
            new Thread(new Jugador(i+1,new Carton(),casino)).start();
        }
    }



}
