package arvoreAVL;

public class MainAVL {

	public static void main(String[] args) {

		ArvoreAVL avl = new ArvoreAVL();
		
//		avl.insert(null, 50);
//		avl.remove(avl.root());
//		avl.insert(avl.root(), 17);
//		avl.insert(avl.root(), 72);
//		avl.insert(avl.root(), 9);
//		avl.insert(avl.root(), 14);
//		avl.insert(avl.root(), 12);
//		avl.insert(avl.root(), 76);
//		avl.insert(avl.root(), 23);
//		avl.insert(avl.root(), 19);
//		avl.insert(avl.root(), 54);
//		avl.insert(avl.root(), 72);
//		avl.insert(avl.root(), 67);
//		System.out.println(avl.root().getFilhoDireito().getElemento());
//		//avl.remove(avl.root());
		
		avl.insert(null, 1);
		avl.insert(avl.root(), 2);
		avl.insert(avl.root(), 3);
		avl.insert(avl.root(), 4);
		avl.insert(avl.root(), 5);
		avl.insert(avl.root(), 6);
		avl.insert(avl.root(), 7);
		avl.insert(avl.root(), 8);
		avl.insert(avl.root(), 9);
		//avl.remove(avl.root());
		avl.remove(avl.search(4, avl.root()));
		avl.remove(avl.search(6, avl.root()));
		//System.out.println(avl.search(6, avl.root()).getPai().getElemento());
		avl.insert(avl.root(), 0);
		avl.remove(avl.search(7, avl.root()));
		avl.insert(avl.root(), 4);
		avl.remove(avl.search(9, avl.root()));
		avl.remove(avl.search(0, avl.root()));
		avl.remove(avl.search(1, avl.root()));
		avl.remove(avl.root());
		avl.remove(avl.search(2, avl.root()));
		avl.insert(avl.root(), 6);
		System.out.println(avl.mostraArvore());
		avl.remove(avl.search(4, avl.root()));
//		avl.insert(null, 1);
//		avl.insert(avl.root(), 2);
//		avl.insert(avl.root(), 3);
//		avl.rotacaoSimplesEsquerda(avl.root());
		
//		avl.insert(null, 50);
//		avl.insert(avl.root(), 20);
//		avl.insert(avl.root(), 70);
//		avl.insert(avl.root(), 30);
//		avl.insert(avl.root(), 10);
//		avl.insert(avl.root(), 5);
//		avl.rotacaoSimplesDireita(avl.root());
		
//		avl.insert(null, 4);
//		avl.insert(avl.root(), 2);
//		avl.insert(avl.root(), 1);
//		avl.insert(avl.root(), 3);
//		avl.insert(avl.root(), 5);
//		avl.insert(avl.root(), 6);
//		avl.insert(avl.root(), 7);
//		avl.rotacaoSimplesEsquerda(avl.root().getFilhoDireito());
		
// ROTACOES DUPLAS
		
//		avl.insert(null, 50);
//		avl.insert(avl.root(), 20);
//		avl.insert(avl.root(), 90);
//		avl.insert(avl.root(), 10);
//		avl.insert(avl.root(), 40);
//		avl.insert(avl.root(), 30);
//		avl.rotacaoDuplaDireita(avl.root());
		
//		avl.insert(null, 50);
//		avl.insert(avl.root(), 20);
//		avl.insert(avl.root(), 80);
//		avl.insert(avl.root(), 70);
//		avl.insert(avl.root(), 90);
//		avl.insert(avl.root(), 60);
//		avl.rotacaoDuplaEsquerda(avl.root());
		System.out.println(avl.mostraArvore());
		System.out.println(avl.mostraFatores());
	}

}
