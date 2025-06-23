package Practica1.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Contador {

    public Contador() {
    }

    public void ImprimirFor(int num1, int num2) {
        for(int i = num1; i < num2; i++){
            System.out.println(i);
        }
    }

    public void ImprimirWhile(int num1, int num2) {
        while (num1<=num2) {
            System.out.println(num1);
            num1++;
        }
    }

    public void ImprimirRecursion(int num1, int num2) {
        System.out.println(num1);//imprimo el estado de num1
        //No hace falta el caso base xq esta implicito en | ESTE | ejercicio.
        if (num1 < num2) {
            ImprimirRecursion(num1+1,num2);
        }
        else if (num2 < num1){
            ImprimirRecursion(num1-1,num2);
        }
    }
}
