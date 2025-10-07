package ar.edu.unlp.info.oo1.ejercicio9;


import java.util.ArrayList;
import java.util.List;


public class Farola {
    private boolean on;
    private List<Farola> neighbor;

    public Farola() {
        this.neighbor = new ArrayList<Farola>();
    }

    public boolean isOn() {
        return this.on;
    }

    public boolean isOff(){
        return !this.on;
    }

    public void setOn(boolean encendida) {
        this.on = encendida;
    }

    public void pairWithNeighbor(Farola otraFarola){
        if (otraFarola == null || otraFarola == this) return;

        //if (!this.neighbors.contains(otra)) ??
        this.neighbor.add(otraFarola);
        //if (!otra.neighbors.contains(this)) ??
        otraFarola.neighbor.add(this);
    }

    public List<Farola> getNeighbors(){
        return new ArrayList<>(this.neighbor);
    }

    public void turnOn(){
        if (this.on) return;
        this.on = true;

        //para saber cuales farolas recorri y no estar recorriendo infinitamente
        List<Farola> recorridos = new ArrayList<>();
        for (Farola v : this.neighbor) {
            v.propagateOn(recorridos);
        }
    }

    public void turnOff() {
        if (!this.on) return;
        this.on = false;
        List<Farola> recorridos = new ArrayList<>();
        recorridos.add(this);
        for (Farola v : this.neighbor) {
            v.propagateOff(recorridos);
        }
    }

    private void propagateOn(List<Farola> recorridos) {
        //si ya lo recorri return
        if (recorridos.contains(this)) return;
        //si no lo recorri lo agrego a recorrido
        recorridos.add(this);
        //si estaba apagada la prendo
        if (!this.on)
            this.on = true;
        //recorro todos los vecinos
        for (Farola rec : this.neighbor) {
            //recurso a esta funcion para hacer lo mismo con los vecinos
            rec.propagateOn(recorridos);
        }
    }

    private void propagateOff(List<Farola> recorridos){
        if (recorridos.contains(this)) return;
        recorridos.add(this);
        if (this.on) this.on = false;
        for (Farola rec : this.neighbor) {
            rec.propagateOff(recorridos);
        }
    }

}
