package grafos;

public class MainGrafo {

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo();
        Vertice v1 = grafo.inserirVertice(1);
        Vertice v2 = grafo.inserirVertice(1);
        Vertice v3 = grafo.inserirVertice(1);
        Vertice v4 = grafo.inserirVertice(1);
        System.out.println(grafo.getOrdem());
        System.out.println(grafo.mostrarMatriz());
        grafo.inserirAresta(v1, v2, null);
        grafo.inserirAresta(v1, v4, null);
        grafo.inserirAresta(v2, v3, null);
        grafo.inserirAresta(v4, v3, null);
        System.out.println(grafo.getOrdem());
        System.out.println(grafo.mostrarMatriz());

    }

}