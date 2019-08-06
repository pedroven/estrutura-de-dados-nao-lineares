package arvoreAVL;

public class MainAVL {

	public static void main(String[] args) {

		ArvoreAVL avl = new ArvoreAVL();
		
//		avl.insert(null, 32);
//		avl.insert(avl.root(), 31);
//		avl.insert(avl.root(), 35);
//		avl.insert(avl.root(), 33);
//		avl.insert(avl.root(), 36);
//		avl.insert(avl.root(), 38);
//		avl.insert(avl.root(), 40);
//		avl.insert(avl.root(), 70);
//		avl.insert(avl.root(), 80);
//		System.out.println(avl.root().getFilhoDireito().getElemento());
//		//avl.remove(avl.root());
		
		avl.insert(null, 10);
		avl.insert(avl.root(), 20);
		avl.insert(avl.root(), 30);
		
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
