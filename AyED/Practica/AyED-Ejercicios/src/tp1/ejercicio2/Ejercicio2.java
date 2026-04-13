package tp1.ejercicio2;
import java.util.Scanner;


public class Ejercicio2 {

    public static int leerValor(){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el numero");
        int num = s.nextInt();
        System.out.println(" - - - - - - ");
        return num;
    }

    public static int[] crearArray(){
        int num = leerValor();
        int[] array = new int[num];
        for (int i = 0; i < num; i++){
            array[i] = num * (i + 1);
        }
        return array;
    }

    public static void imprimirArray(int[] array){
        for (int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        imprimirArray(crearArray());
    }
}
