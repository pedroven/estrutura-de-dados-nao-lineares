package grafos;

public class MainGrafo {

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo();
        Vertice v1 = grafo.inserirVertice(1);
        Vertice v2 = grafo.inserirVertice(2);
        Vertice v3 = grafo.inserirVertice(3);
        Vertice v4 = grafo.inserirVertice(4);
        Vertice v5 = grafo.inserirVertice(5);
        System.out.println(grafo.getOrdem());
        System.out.println(grafo.mostrarMatriz());
        Aresta a = grafo.inserirAresta(v1, v2, 10);
        grafo.inserirAresta(v1, v3, 20);
        grafo.inserirAresta(v2, v4, 25);
        grafo.inserirAresta(v3, v4, 30);
        grafo.inserirAresta(v4, v5, 40);
        System.out.println(grafo.mostrarMatriz());
        grafo.removeVertice(v5);
        System.out.println(grafo.mostrarMatriz());
        System.out.println(grafo.arestas());
        grafo.removeAresta(a);
        System.out.println(grafo.arestas());
        System.out.println(grafo.mostrarMatriz());


    }

}