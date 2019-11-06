package grafos;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainGrafo {

    private static ArrayList<Object> visitados = new ArrayList<Object>();
    private static Stack<Object> pilha = new Stack<>();
    private static ConcurrentLinkedQueue<Object> fila = new ConcurrentLinkedQueue<>();


    public static ArrayList<Vertice> dijkstra(Grafo grafo) {
        Grafo gclone = grafo;
        Object[][] td = new Object[gclone.getOrdem()][3];
        for (int j = 0; j < gclone.getOrdem(); j++) {
            td[j][0] = gclone.vertices().get(j);
            td[j][1] = 999999999;
        }
        ArrayList<Vertice> visitados = new ArrayList<>();
        ArrayList<Vertice> naoVisitados = (ArrayList<Vertice>) gclone.vertices().clone();
        boolean pv = true;
        Vertice atual = null;
        int tam = naoVisitados.size();
        ArrayList<Vertice> na = null;
        ArrayList<Vertice> adj = null;
        int indexAtual = 0;
        while (visitados.size() != tam && naoVisitados.size() != 0) {
            if (pv) {
                atual = gclone.vertices().get(0);
                td[0][1] = 0;
                pv = false;
            }
            Vertice menor = atual.getAdjacentes().get(0);
            int somatmp = (Integer)td[indexAtual][1];
            if (na != null) {
                adj = na;
                if (adj.size() != 0) menor = adj.get(0);
            } else {
                adj = atual.getAdjacentes(); 
            }
            for (Vertice v : adj) {
                Aresta aresta = gclone.arestaCorrespondente(atual, v);
                int soma = (Integer)td[indexAtual][1] + (Integer)aresta.getCusto();
                int indexV = gclone.vertices().indexOf(v);
                if (soma < (Integer)td[indexV][1]) {
                    td[indexV][1] = soma;
                    td[indexV][2] = atual;
                }
                if (soma < somatmp) {
                    menor = v;
                }
                somatmp = soma;
            }
            visitados.add(atual);
            naoVisitados.remove(atual);
            atual = menor;
            indexAtual = gclone.vertices().indexOf(atual);
            na = (ArrayList<Vertice>) atual.getAdjacentes().clone();
            for (Vertice e : atual.getAdjacentes()) {
                if (visitados.contains(e)) {
                    na.remove(e);
                }
            }
        }
        return visitados;
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
        // Vertice v0 = grafo.inserirVertice(0);
        // Vertice v1 = grafo.inserirVertice(1);
        // Vertice v3 = grafo.inserirVertice(3);
        // Vertice v4 = grafo.inserirVertice(4);
        // Vertice v6 = grafo.inserirVertice(6);
        // Vertice v2 = grafo.inserirVertice(2);
        // Vertice v5 = grafo.inserirVertice(5);
        // Vertice v7 = grafo.inserirVertice(7);
        // grafo.inserirArestaDirecionada(v0, v1, null);
        // grafo.inserirArestaDirecionada(v0, v2, null);
        // grafo.inserirArestaDirecionada(v1, v3, null);
        // grafo.inserirArestaDirecionada(v3, v4, null);
        // grafo.inserirArestaDirecionada(v3, v6, null);
        // grafo.inserirArestaDirecionada(v2, v5, null);
        // grafo.inserirArestaDirecionada(v5, v7, null);
        Vertice a = grafo.inserirVertice("A");
        Vertice b = grafo.inserirVertice("B");
        Vertice c = grafo.inserirVertice("C");
        Vertice d = grafo.inserirVertice("D");
        Vertice e = grafo.inserirVertice("E");
        grafo.inserirAresta(a, b, 6);
        grafo.inserirAresta(a, d, 1);
        grafo.inserirAresta(d, b, 2);       
        grafo.inserirAresta(d, e, 1);       
        grafo.inserirAresta(b, e, 2);       
        grafo.inserirAresta(b, c, 5);       
        grafo.inserirAresta(e, c, 5);
        ArrayList<Vertice> caminho = dijkstra(grafo);
        for(Vertice v : caminho) {
            System.out.print(v.getElemento() + " ");
        }       
        // bfs(v0);

    }

}