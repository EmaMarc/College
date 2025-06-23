package Practica2.Ejercicio3;

import Practica2.BinaryTree;

public class MainEj3 {
    public static void main(String[] args) {

        BinaryTree<Integer> arbolito = new BinaryTree<>();
        //arbolito.generarArbolAleatorio(6,100);
        ContadorArbol contador = new ContadorArbol(arbolito);

        System.out.println(contador.numerosPares());
    }
}
