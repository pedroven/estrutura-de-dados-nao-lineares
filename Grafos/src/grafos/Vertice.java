package grafos;

import java.util.ArrayList;

public class Vertice {

    private Object elemento;
    private ArrayList<Aresta> vertices;
    
    public Vertice(Object elemento) {
        this.elemento = elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return this.elemento;
    }

}