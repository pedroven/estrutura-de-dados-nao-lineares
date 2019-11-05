package grafos;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainGrafo {

    private static ArrayList<Object> visitados = new ArrayList<Object>();
    private static Stack<Object> pilha = new Stack<>();
    private static ConcurrentLinkedQueue<Object> fila = new ConcurrentLinkedQueue<>();


    public void dijkstra(Grafo grafo) {
        Object[][] td = new Object[grafo.getOrdem()][3];
        for (int j = 0; j < grafo.getOrdem(); j++) {
            td[j][0] = grafo.vertices().get(j);
        }
        ArrayList<Vertice> visitados = new ArrayList<>();
        ArrayList<Vertice> naoVisitados = grafo.vertices();
        boolean pv = true;
        Vertice atual = null;
        while (visitados.size() != naoVisitados.size()) {
            if (pv) {
                atual = grafo.vertices().get(0);
                td[0][1] = 0;
            }
            for (Vertice v : atual.getAdjacentes()) {
                Aresta aresta = grafo.arestaCorrespondente(atual, v);
                int indexAtual = grafo.vertices().indexOf(atual);
                int soma = (Integer)td[indexAtual][1] + (Integer)aresta.getCusto();
                if (soma < (Integer)td[indexAtual][1]) {
                    int indexV = grafo.vertices().indexOf(v);
                    td[indexV][1] = soma;
                }
            }
            visitados.add(atual);
            naoVisitados.remove(atual);
            
        }
    }

    // dfs
    public static void dfs(Vertice inicio) {
        pilha.push(inicio);
        while (!pilha.empty()) {
            Vertice v = (Vertice) pilha.pop();
            System.out.print(v.getElemento() + " ");
            visitados.add(v);
            for (Vertice e : v.getAdjacentes()) {
                if(visitados.indexOf(e) == -1) { //se nao tiver sido visitado
                    pilha.push(e);
                }
            }
        }
    }

    // bfs
    public static void bfs(Vertice inicio) {
        fila.add(inicio); //enfileira
        while(!fila.isEmpty()) {
            Vertice v = (Vertice) fila.peek(); // inicio da fila
            fila.poll(); // desenfileira
            System.out.print(v.getElemento() + " ");
            visitados.add(v);
            for (Vertice e : v.getAdjacentes()) {
                if(visitados.indexOf(e) == -1) { //se nao tiver sido visitado
                    fila.add(e); //enfileira
                }
            }
        }
    }

    public static void main(String[] args) {
        
        //Definição do grafo
        Grafo grafo = new Grafo();
        Vertice v0 = grafo.inserirVertice(0);
        Vertice v1 = grafo.inserirVertice(1);
        Vertice v3 = grafo.inserirVertice(3);
        Vertice v4 = grafo.inserirVertice(4);
        Vertice v6 = grafo.inserirVertice(6);
        Vertice v2 = grafo.inserirVertice(2);
        Vertice v5 = grafo.inserirVertice(5);
        Vertice v7 = grafo.inserirVertice(7);
        grafo.inserirArestaDirecionada(v0, v1, null);
        grafo.inserirArestaDirecionada(v0, v2, null);
        grafo.inserirArestaDirecionada(v1, v3, null);
        grafo.inserirArestaDirecionada(v3, v4, null);
        grafo.inserirArestaDirecionada(v3, v6, null);
        grafo.inserirArestaDirecionada(v2, v5, null);
        grafo.inserirArestaDirecionada(v5, v7, null);
        // for (Vertice v : v0.getAdjacentes()) {
        //     System.out.print(v.getElemento() + " ");
        // }
        // System.out.println(grafo.mostrarMatriz());
        bfs(v0);
        // Vertice v1 = grafo.inserirVertice(1);
        // Vertice v2 = grafo.inserirVertice(2);
        // Vertice v3 = grafo.inserirVertice(3);
        // Vertice v4 = grafo.inserirVertice(4);
        // grafo.inserirAresta(v1, v2, null);
        // grafo.inserirAresta(v2, v3, null);
        // grafo.inserirAresta(v3, v4, null);
        // grafo.inserirAresta(v4, v1, null);

    }

}