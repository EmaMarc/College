package Practica1.Ejercicio8;

import java.util.LinkedList;

public class Queue<T> extends Sequence<T> {

    public Queue() {
        this.data = new LinkedList<>();
    }

    public void enqueue(T dato) {
        data.add(dato);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Error: La cola está vacía. No se puede hacer dequeue.");
            return null;
        }
        return data.remove(0);
    }

    public T head() {
        if (isEmpty()) {
            System.out.println("Error: La cola está vacía. No hay elemento en el frente.");
            return null;
        }
        return data.get(0);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
