package Practica2.Ejemplo;
//----------------------SUMAR ARBOLES-------------------------
//
//Escribir en una clase "EjercitacionArboles" el metodo publico con la siguiente firma:
//  public BinaryTree<Integer> sumarArboles (BinaryTree<Integer> arbol1, BinaryTree<Integer> Arbol2)
//  -→ Si ambos arboles tiene la misma estructura, el metodo:
//          • Crea y devuelve un nuevo arbol con misma estructura;
//          • Donde cada nodo del nuevo arbol contiene la suma de los nodos correspondiente de arbol1 y arbol2
//
//  -→ Si NO tienen la misma estructura, devuelve un arbol vacio

import Practica2.BinaryTree;

public class SumarArboles {

    public BinaryTree<Integer> sumarArboles (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        //declaro el arbol que voy a devolver si es valido.a
        BinaryTree<Integer> arbolSuma = new BinaryTree<Integer>();

        //pregunto si el arbol esta vacio o si es nulo;
        if(arbol1 == null || arbol2== null) return null;
        if(arbol1.isEmpty() || arbol2.isEmpty()) return arbolSuma;

        //Llamo al metodo booleano sumaRecursiva, para que devuelva el valor a estructuraValida
        boolean estructuraValida = sumaRecursiva(arbol1,arbol2,arbolSuma);
        //Si estructura valida es VERDADERO devuelve el arbol sumado, si es FALSO devuelve un nuevo arbol vacio.
        //    condición      ? valorSiEsTrue : valorSiEsFalse;
        return estructuraValida ? arbolSuma : new BinaryTree<Integer>();
    }

    private boolean sumaRecursiva(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2, BinaryTree<Integer> arbolSuma) {
        //Lo inicializo en true, por las comprobaciones de validez anteriores.
        boolean estructuraValida = true;
        //Seteo la suma de los 2 nodos de los 2 arboles en el nuevo arbol.
        arbolSuma.setData(arbol1.getData() + arbol2.getData());

        //Si ambos arboles tienen hijo izquierdo...
        if(arbol1.hasLeftChild() && arbol2.hasLeftChild()){
            //Aunque quiero trabajar los hijos izquierdos primero, no tiene sentido hacerlo si no coinciden en hijo derecho
            //asi que antes hago una comprobacion a ver si tienen hijo derecho tambien...
            if (arbol1.hasRightChild() && arbol2.hasRightChild()){
                //como fueron ambos nodos iguales, le agrego un NUEVO hijo IZQUIERDO
                arbolSuma.addLeftChild(new BinaryTree<Integer>());
                //vuelvo a llamar al metodo booleano sumaRecursiva, para que devuelva el valor a estructuraValida pero con los hijos IZQUIERDOS
                estructuraValida = sumaRecursiva(arbol1.getLeftChild(), arbol2.getLeftChild(), arbolSuma.getLeftChild());
            }
            else estructuraValida = false;
        }
        else {
            //esto es para comprobar si uno tiene y el otro no, puede ser uno null y el otro no.
            estructuraValida = arbol1.hasLeftChild() == arbol2.hasLeftChild();
        }

        //Ahora hago lo mismo de arriba pero con los hijos derechos.
        //Si es una estructura valida...
        if (estructuraValida){
            //si ambos arboles tienen hijo derecho...
            if (arbol1.hasLeftChild() && arbol2.hasRightChild()){
                //como fueron iguales ambos nodos, le agrego un NUEVO hijo DERECHO
                arbolSuma.addRightChild(new BinaryTree<Integer>());
                //vuelvo a llamar al metodo booleano sumaRecursiva, para que devuelva el valor a estructuraValida pero con los hijos DERECHOS
                estructuraValida = sumaRecursiva(arbol1.getRightChild(), arbol2.getRightChild(), arbolSuma.getRightChild());
            }
            else {
                //esto es para comprobar si uno tiene y el otro no, puede ser uno null y el otro no.
                estructuraValida = arbol1.hasRightChild() == arbol2.hasRightChild();
            }
        }
        return estructuraValida;
    }



    public static void main(String[] args) {
        //sé instancia el siguiente ejemplo para arbol 1:
        //     ARBOL 1:             ARBOL 2:
        //          3                   5
        //        /   \               /   \
        //       8     4             9     7
        //      / \     \             \   / \
        //    20   1     5             2 14  -6

        //ARBOL 1
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(3);
        arbol1.addLeftChild(new BinaryTree<>(8));
        arbol1.addRightChild(new BinaryTree<>(4));
        arbol1.getLeftChild().addLeftChild(new BinaryTree<>(20));
        arbol1.getLeftChild().addRightChild(new BinaryTree<>(1));
        arbol1.getRightChild().addRightChild(new BinaryTree<>(5));
        System.out.println("--- Impresion por niveles arbol1");
        //arbol1.recorridoPorNiveles();
        System.out.println("\n\n");
        //-----------------------------------------------------------------
        //ARBOL 2
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(5);
        arbol2.addLeftChild(new BinaryTree<Integer>(9));
        arbol2.addRightChild(new BinaryTree<Integer>(7));
        arbol2.getLeftChild().addRightChild(new BinaryTree<Integer>(2));
        arbol2.getRightChild().addLeftChild(new BinaryTree<Integer>(14));
        arbol2.getRightChild().addRightChild(new BinaryTree<Integer>(-6));
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--- Impresion por niveles arbol2");
        //arbol2.recorridoPorNiveles();
        System.out.println("\n\n");

        SumarArboles Final = new SumarArboles();
        BinaryTree<Integer> suma = Final.sumarArboles(arbol1,arbol2);
        System.out.println("--- Impresion por niveles del arbol sumado");
        //suma.recorridoPorNiveles();
        System.out.println("\n\n");

    }
}