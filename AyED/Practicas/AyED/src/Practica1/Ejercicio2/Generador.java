package Practica1.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Generador {

    public Generador() {
    }

    public List<Integer> GenerarArray(int num){
        List<Integer> Arreglo = new ArrayList<>();
        for (int i=1;i<=num;i++){
            Arreglo.add(num*i);
        }
        System.out.println(Arreglo);
        return Arreglo;
    }
}
