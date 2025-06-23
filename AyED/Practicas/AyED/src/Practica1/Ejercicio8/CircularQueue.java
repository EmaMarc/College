package Practica1.Ejercicio8;

public class CircularQueue<T> extends Queue<T> {

    public T shift() {
        if (isEmpty()) {
            System.out.println("Error: La cola está vacía. No se puede rotar.");
            return null;
        }
        T elemento = dequeue();  // esto ya muestra error si está vacía
        enqueue(elemento);       // lo vuelve a poner al final
        return elemento;
    }
}

