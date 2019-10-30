package grafos;

import java.util.ArrayList;

public class Vertice {

    private Object elemento;
    private ArrayList<Vertice> adjancentes;
    
    public Vertice(Object elemento) {
        this.elemento = elemento;
        this.adjancentes = new ArrayList<>();
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public ArrayList<Vertice> getAdjacentes() {
        return this.adjancentes;
    }

    public void setAdjacentes(ArrayList<Vertice> adjacentes) {
        this.adjancentes = adjacentes;
    }

}