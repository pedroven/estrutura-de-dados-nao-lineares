package grafos;

import java.util.ArrayList;

public class Vertice {

    private Object elemento;
    private ArrayList<Vertice> adjancentes;
    private int valorD;

    
    public Vertice(Object elemento) {
        this.elemento = elemento;
        this.adjancentes = new ArrayList<>();
        this.valorD = 999999999;
    }

    public int getValorD() {
        return valorD;
    }

    public void setValorD(int valorD) {
        this.valorD = valorD;
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