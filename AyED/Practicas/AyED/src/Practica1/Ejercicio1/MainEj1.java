package Practica1.Ejercicio1;

public class MainEj1 {
    public static void main(String[] args) {
        Contador Contador = new Contador();
        System.out.println("Condador con for:");
        Contador.ImprimirFor(3,9);
        System.out.println("-------------");
        System.out.println("Contador con while:");
        Contador.ImprimirWhile(5,13);
        System.out.println("-------------");
        System.out.println("Countador con recursion:");
        Contador.ImprimirRecursion(3,10);
        System.out.println("-------------");
    }
}
