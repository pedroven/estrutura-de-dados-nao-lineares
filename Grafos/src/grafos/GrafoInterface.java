package grafos;

import java.util.ArrayList;

import grafos.exceptions.NaoIncidenteException;

public interface GrafoInterface {

    public ArrayList<Vertice> finalVertices(Aresta aresta);

    public Vertice oposto(Vertice vertice, Aresta aresta) throws NaoIncidenteException;

    public boolean ehAdjacente(Vertice vertice1, Vertice vertice2);

    public Vertice inserirVertice(Object elemento);

    public Aresta inserirAresta(Vertice inicio, Vertice fim, Object custo);

    public Object removeVertice(Vertice vertice);

    public Object removeAresta(Aresta aresta);

    public ArrayList<Aresta> arestasIncidentes(Vertice vertice);

    public ArrayList<Vertice> vertices();
   
    public ArrayList<Aresta> arestas();

    public boolean ehDirecionado(Aresta aresta);

    public Aresta inserirArestaDirecionada(Vertice inicio, Vertice fim, Object custo);

    public void substituirA(Aresta aresta, Object custo);

    public void substituirV(Vertice vertice, Object elemento);

}