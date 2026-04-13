package tp1.ejercicio1;

public class Ejercicio1 {

    public static void contarConFor(int desde, int hasta){
        System.out.println(" - - - - - -");
        for (int i = desde; i <= hasta; i++){
            System.out.println(i);
        }
        System.out.println("Fin Contar con For - - -");
    }

    public static void contarConWhile(int desde, int hasta){
        System.out.println(" - - - - - -");
        int i = desde;
        while (i <= hasta) {
            System.out.println(i);
            i++;
        }
        System.out.println("Fin Contar con While");
    }

    public static void contarConRecursion(int desde,int hasta){
        System.out.println(" - - - - - -");

        contar(desde,hasta);
        System.out.println("Fin Contar con Recursion");
    }

    public static void contar(int i, int hasta){
        if(i<=hasta){
            System.out.println(i);
            contar(i+1, hasta);
        }
    }

    public static void main(String[] args) {
        contarConFor(2,5);
        contarConWhile(2,5);
        contarConRecursion(2,5);
    }


}