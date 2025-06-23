package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEj7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Integer> Numeros = new ArrayList<>();
        int num = 0;
        while (num != -1) {
            System.out.println("Ingrese un numero:");
            num = teclado.nextInt();
            if (num != -1){
                Numeros.add(num);
            }
        }
        for (int i = 0; i < Numeros.size(); i++){
            System.out.println(Numeros.get(i));
        }

        TestArrayList test = new TestArrayList();
        test.Generar();
    }
}