package grafos;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainGrafo {

    private static ArrayList<Object> visitados = new ArrayList<Object>();
    private static ConcurrentLinkedQueue<Object> fila = new ConcurrentLinkedQueue<>();
    
    private static boolean ehArestaValida(Vertice atual, Vertice proximo, Grafo grafo) {
        if (atual.getAdjacentes().size() == 1) {
            return true;
        }
        int cont1 = dfsCont(atual);
        Aresta a = grafo.arestaCorrespondente(atual, proximo);
        // int custo = (Integer) a.getCusto();
        if (a != null) grafo.removeAresta(a);
        proximo.getAdjacentes().remove(atual);
        atual.getAdjacentes().remove(proximo);
        int cont2 = dfsCont(atual);
        grafo.inserirAresta(atual, proximo, null);
        // proximo.getAdjacentes().add(atual);
        // atual.getAdjacentes().add(proximo);
        return (cont1 > cont2) ? false : true;
    }

    private static ArrayList<Vertice> caminhoEuleriano(Vertice vertice, Grafo grafo) throws CloneNotSupportedException {
        ArrayList<Aresta> arestas = grafo.arestas();
        System.out.println(arestas.size());
        // adicionar arestas visitadas
        ArrayList<Vertice> caminho = new ArrayList<>();
        ArrayList<Aresta> arestasbck = new ArrayList<>();
        caminho.add(vertice);
        while (arestas.size() != 0) {
            for (int i = 0; i < vertice.getAdjacentes().size(); i++) {
                // System.out.println(vertice.getAdjacentes());
                Vertice proximo = vertice.getAdjacentes().get(i);
                if (ehArestaValida(vertice, proximo, grafo)) {
                    Aresta a = grafo.arestaCorrespondente(vertice, proximo);
                    Aresta aClone = (Aresta) a.clone();
                    arestasbck.add(aClone);
                    grafo.removeAresta(a); 
                    proximo.getAdjacentes().remove(vertice);
                    vertice.getAdjacentes().remove(proximo);
                    caminho.add(proximo);
                    vertice = proximo;
                    break;
                }
            }
        }
        System.out.println(caminho.size());
        grafo.recolocarArestas(arestasbck);
        return caminho;
    }

    private static Vertice proximo(ArrayList<Vertice> naoVisitados) {
        Vertice proximo = naoVisitados.get(0);
        int menor = naoVisitados.get(0).getValorD();
        for (Vertice v : naoVisitados) {
            if (v.getValorD() < menor) {
                proximo = v;
            } 
        }
        return proximo;
    }
 
    public static ArrayList<Vertice> fleury(Grafo grafo) throws CloneNotSupportedException {
        Grafo gclone = (Grafo) grafo.clone();
        ArrayList<Vertice> vertices = gclone.vertices();
        ArrayList<Vertice> caminhoEuleriano = new ArrayList<>();
        Vertice atual = vertices.get(0);
        for (Vertice v :  vertices) {
            if (v.getAdjacentes().size() % 2 != 0) {
                atual = v;
                break;
            }
        }
        caminhoEuleriano = caminhoEuleriano(atual, gclone);
        return caminhoEuleriano;
    }


    public static Object[][] dijkstra(Grafo grafo, Vertice inicio) {
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
        int indexAtual = gclone.vertices().indexOf(inicio);
        while (visitados.size() != tam && naoVisitados.size() != 0) {
            if (pv) {
                atual = inicio;
                td[indexAtual][1] = 0;
                pv = false;
            }
            if (na != null) {
                adj = na;
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
                    v.setValorD(soma);
                }
            }
            visitados.add(atual);
            naoVisitados.remove(atual);
            if (naoVisitados.size() != 0) atual = proximo(naoVisitados);
            indexAtual = gclone.vertices().indexOf(atual);
            na = (ArrayList<Vertice>) atual.getAdjacentes().clone();
            for (Vertice e : atual.getAdjacentes()) {
                if (visitados.contains(e)) {
                    na.remove(e);
                }
            }
        }
        return td;
    }

    public static void printDijkstra(Object[][] td) {
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 3; j++) {
                if (j == 0) {
                    Vertice v = (Vertice) td[i][j];
                    if (v != null)
                    System.out.print(v.getElemento() + " ");
                } else if (j == 1) {
                    Integer c = (Integer) td[i][j];
                    System.out.print(c + " ");
                } else {
                    Vertice v = (Vertice) td[i][j];
                    if (v != null)
                    System.out.print(v.getElemento() + " ");
                }
            }
            System.out.println();
        }
    }

    private static int dfsCont(Vertice fim) {
        ArrayList<Object> visitados = new ArrayList<Object>();
        Stack<Object> pilha = new Stack<>();
        pilha.push(fim);
        while (!pilha.empty()) {
            Vertice v = (Vertice) pilha.pop();
            // System.out.print(v.getElemento() + " ");
            visitados.add(v);
            for (Vertice e : v.getAdjacentes()) {
                if(visitados.indexOf(e) == -1) { //se nao tiver sido visitado
                    if (!pilha.contains(e)) pilha.push(e);
                }
            }
        }
        return visitados.size();
    }

    // dfs
    public static void dfs(Vertice inicio) {
        ArrayList<Object> visitados = new ArrayList<Object>();
        Stack<Object> pilha = new Stack<>();
        pilha.push(inicio);
        while (!pilha.empty()) {
            Vertice v = (Vertice) pilha.pop();
            // System.out.print(v.getElemento() + " ");
            visitados.add(v);
            for (Vertice e : v.getAdjacentes()) {
                if(visitados.indexOf(e) == -1) { //se nao tiver sido visitado
                    if (!pilha.contains(e)) pilha.push(e);
                }
            }
        }
        for(Object v : visitados) {
            Vertice v1 = (Vertice) v;
            System.out.println(v1.getElemento());
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

    public static void main(String[] args) throws CloneNotSupportedException {
        
        //Definição do grafo
        Grafo grafo = new Grafo();
        Vertice a = grafo.inserirVertice("A");
        Vertice b = grafo.inserirVertice("B");
        Vertice c = grafo.inserirVertice("C");
        Vertice d = grafo.inserirVertice("D");
        Vertice e = grafo.inserirVertice("E");
        // Vertice f = grafo.inserirVertice("F");
        // Vertice g = grafo.inserirVertice("G");
        // Vertice h = grafo.inserirVertice("H");
        //teste 1
        // grafo.inserirAresta(a, b, null);
        // grafo.inserirAresta(a, c, null);
        // grafo.inserirAresta(c, b, null);
        // grafo.inserirAresta(b, d, null);
        // teste 2
        // grafo.inserirAresta(a, b, 6);
        // grafo.inserirAresta(a, c, 1);
        // grafo.inserirAresta(a, d, 2);       
        // grafo.inserirAresta(a, g, 5);
        // grafo.inserirAresta(b, c, 6);
        // grafo.inserirAresta(c, d, 1);
        // grafo.inserirAresta(e, c, 2);       
        // grafo.inserirAresta(e, g, 5);
        // grafo.inserirAresta(e, f, 6);
        // grafo.inserirAresta(e, h, 1);
        // grafo.inserirAresta(f, g, 2);       
        // grafo.inserirAresta(g, h, 5);
        // teste 3
        grafo.inserirAresta(a, b, 6);
        grafo.inserirAresta(a, d, 1);
        grafo.inserirAresta(b, d, 2); 
        grafo.inserirAresta(d, e, 1);
        grafo.inserirAresta(b, e, 2);
        grafo.inserirAresta(b, c, 5); 
        grafo.inserirAresta(e, c, 5); 
        Object[][] matriz = dijkstra(grafo, a);
        printDijkstra(matriz);
    }

}