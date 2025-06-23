package Practica2.Ejercicio3;

import Practica2.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {

    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> numerosPares(){
        List<Integer> pares = new ArrayList<>();
        paresInOrder(arbol,pares);
        paresPostOrder(arbol,pares);

        return pares;
    }

    private void paresPostOrder(BinaryTree<Integer> nodo, List<Integer> pares) {
        if (nodo != null) {
            //recorro el subarbol izquierdo
            if (nodo.hasLeftChild())
                paresPostOrder(nodo.getLeftChild(),pares);
            //recorro el subarbol derecho
            if (nodo.hasRightChild())
                paresPostOrder(nodo.getRightChild(),pares);

            //si es par lo agrego a pares
            if (nodo.getData() % 2 == 0) {
                pares.add(nodo.getData());
            }
        }
    }

    private void paresInOrder(BinaryTree<Integer> nodo, List<Integer> pares) {
        if (nodo != null){
            //recorro el subárbol izquierdo.
            if (nodo.hasLeftChild())
                paresInOrder(nodo.getLeftChild(),pares);

            //si el nodo es par lo agrego a la lista
            if(nodo.getData() % 2 == 0){
                pares.add(nodo.getData());
            }

            //recorro el subárbol derecho
            if (nodo.hasRightChild())
                paresInOrder(nodo.getRightChild(),pares);
        }
    }


}
