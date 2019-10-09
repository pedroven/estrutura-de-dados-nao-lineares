package grafos;

import java.util.ArrayList;

public class Vertice {

    private int chave;
    private Object elemento;
    private ArrayList<Aresta> vertices;
    
    public Vertice(Object elemento) {
        this.elemento = elemento;
        this.chave = 0;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return this.chave;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return this.elemento;
    }

}