package Practica1.Ejercicio8;

import java.util.List;

public abstract class Sequence<T> {
    protected List<T> data;

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}

