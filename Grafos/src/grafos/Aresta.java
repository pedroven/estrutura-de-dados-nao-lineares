package grafos;

public class Aresta {

    private Vertice inicio;
    private Vertice fim;
    private boolean ehDirecionado;
    private Object custo;

    public Aresta(Vertice inicio, Vertice fim, boolean ehDirecionado) {
        this.inicio = inicio;
        this.fim = fim;
        this.ehDirecionado = ehDirecionado;
    }

    public Aresta(Vertice inicio, Vertice fim, boolean ehDirecionado, Object custo) {
        this.inicio = inicio;
        this.fim = fim;
        this.ehDirecionado = ehDirecionado;
        this.custo = custo;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getInicio() {
        return this.inicio;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    public Vertice getFim() {
        return this.fim;
    }

    public void setEhDirecionado(boolean ehDirecionado) {
        this.ehDirecionado = ehDirecionado;
    }

    public boolean getEhdirecionado() {
        return this.ehDirecionado;
    }

    public void setCusto(Object custo) {
        this.custo = custo;
    }

    public Object getCusto() {
        return this.custo;
    }

}