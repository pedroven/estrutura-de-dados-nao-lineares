package grafos;

import java.util.ArrayList;

import grafos.exceptions.NaoIncidenteException;

public class Grafo implements GrafoInterface {

    private int ordem; //numero de vertices
    //adjacencia == par de vertice que compartilha uma aresta OU par de aresta que compartilha um vertice
    //grau == incidencia de arestas no vertice || grau de saida e grau de entrada
    //laço == aresta(v,v)
    //aresta paralela == a1(v, w), a2(v, w)
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private Object matrizAdj [][];

    public Grafo() {
        this.ordem = 0;
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }

    public int getOrdem() {
        return this.ordem;
    }

    @Override
    public boolean ehAdjacente(Vertice vertice1, Vertice vertice2) {
        boolean ehAdj = false;
        if(this.matrizAdj[vertice1.getChave()-1][vertice2.getChave()-1] != null) ehAdj = true;
        return ehAdj;
    }

    @Override
    public void substituirA(Aresta aresta, Object custo) {
        aresta.setCusto(custo);
    }

    @Override
    public void substituirV(Vertice vertice, Object elemento) {
        vertice.setElemento(elemento);        
    }

    @Override
    public ArrayList<Aresta> arestas() {
        return this.arestas;
    }

    @Override
    public ArrayList<Aresta> arestasIncidentes(Vertice vertice) {
        ArrayList<Aresta> a_incidentes = new ArrayList<Aresta>();
        for (Aresta a : this.arestas) {
            if (a.getFim() == vertice || a.getInicio() == vertice) {
                a_incidentes.add(a);
            }
        }
        return a_incidentes;
    }

    @Override
    public boolean ehDirecionado(Aresta aresta) {
        return aresta.getEhdirecionado();
    }

    @Override
    public ArrayList<Vertice> finalVertices(Aresta aresta) {
        ArrayList<Vertice> vertices = new ArrayList<>();
        vertices.add(aresta.getInicio());
        vertices.add(aresta.getFim());
        return vertices;
    }

    @Override
    public Aresta inserirAresta(Vertice inicio, Vertice fim, Object custo) {
        Aresta novo = new Aresta(inicio, fim, false, custo);
        this.arestas.add(novo);
        ArrayList<Aresta> arestasMtr1 = (ArrayList<Aresta>) this.matrizAdj[inicio.getChave()-1][fim.getChave()-1];
        ArrayList<Aresta> arestasMtr2 = (ArrayList<Aresta>) this.matrizAdj[fim.getChave()-1][inicio.getChave()-1];
        if (arestasMtr1 == null) {
            arestasMtr1 = new ArrayList<Aresta>();
            arestasMtr2 = new ArrayList<Aresta>();
            arestasMtr1.add(novo);
            arestasMtr2.add(novo);
            this.matrizAdj[inicio.getChave()-1][fim.getChave()-1] = arestasMtr1;
            this.matrizAdj[fim.getChave()-1][inicio.getChave()-1] = arestasMtr2;
        } else {
            arestasMtr1.add(novo);
            arestasMtr2.add(novo);
        }
        return novo;
    }

    @Override
    public Aresta inserirArestaDirecionada(Vertice inicio, Vertice fim, Object custo) {
        Aresta novo = new Aresta(inicio, fim, true);
        this.arestas.add(novo);
        return novo;      
    }

    @Override
    public Vertice inserirVertice(Object elemento) {
        if (this.ordem == 0) {
            this.matrizAdj = new Object[1][1];
        } else {
            int tam = this.ordem+1;
            this.matrizAdj = new Object[tam][tam];
        }
        Vertice novo = new Vertice(elemento);
        novo.setChave(this.ordem+1);
        this.vertices.add(novo);
        this.ordem++;
        return novo;
    }

    @Override
    public Vertice oposto(Vertice vertice, Aresta aresta) throws NaoIncidenteException {
        if (aresta == null) throw new NaoIncidenteException("A aresta não existe"); 
        if (vertice == null || (vertice != aresta.getInicio() && vertice != aresta.getFim()))
        throw new NaoIncidenteException("O vertice é não inicidente");
        else {
            if (aresta.getInicio() == vertice) {
                return aresta.getFim();
            }
            else if (aresta.getFim() == vertice) {
                return aresta.getInicio();
            }
        }
        return null;
    }

    @Override
    public Object removeAresta(Aresta aresta) {
        Object custo = aresta.getCusto();
        for (Aresta a : this.arestas) {
            if (a == aresta) {
                this.arestas.remove(aresta);
                aresta.setFim(null);
                aresta.setInicio(null);
                aresta.setCusto(null);
                break;
            }
        }
        return custo;
    }

    @Override
    public Object removeVertice(Vertice vertice) {
        Object elemento = vertice.getElemento();
        for (Vertice v : this.vertices) {
            if (v == vertice) {
                ArrayList<Aresta> a_incidentes = this.arestasIncidentes(vertice);
                for (Aresta a : a_incidentes) {
                    this.arestas.remove(a);
                    a.setCusto(null);
                    a.setInicio(null);
                    a.setFim(null);
                }
                int tam = this.ordem-1;
                this.matrizAdj = new Object[tam][tam];
                this.vertices.remove(vertice);
                vertice.setElemento(null);
                break;
            }
        }
        this.ordem--;
        return elemento;
    }

    @Override
    public ArrayList<Vertice> vertices() {
        return this.vertices;
    }

    public String mostrarMatriz() {
        String m = "";
        for (int i = 0; i < this.ordem; i++) {
            for (int j = 0; j < this.ordem; j++) {
                if (this.matrizAdj[i][j] == null) {
                    m += "0 ";
                } else {
                    ArrayList<Aresta> arestas = (ArrayList<Aresta>) this.matrizAdj[i][j];
                    m += arestas.size() + " ";
                }
            }
            m += "\n";
        }
        return m;
    }

    
}