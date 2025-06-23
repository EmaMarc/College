package Practica1.Ejercicio8;

public class DoubleEndedQueue<T> extends Queue<T> {

    public void enqueueFirst(T dato) {
        data.add(0, dato);  // lo agrega al inicio de la lista
    }
}

