package arvoreRN;

import java.util.ArrayList;

public class ArvoreRN{
	
	private NoRN raiz;
	private int tamanho;
	private ArrayList<NoRN> listaPreOrder, listaInOrder, listaPosOrder;
	
	public ArvoreRN() {
		raiz = null;	
		tamanho = 0;
	}
	
	public ArvoreRN(NoRN raiz) {
		this.raiz = raiz;
		tamanho = 1;
	}

	public int size() {
		return this.tamanho;
	}

	public int height(NoRN no) {
		if(no == null || this.isExternal(no)) {
			return 0;
		}
		else {
			int left = height(no.getFilhoEsquerdo());
			int right = height(no.getFilhoDireito());
			if (left > right) {
				return left + 1;
			}
			return right + 1;
		}
	}

	public boolean isEmpty() {
		return (raiz == null)?true:false;
	}

	public ArrayList<Object> elements() {
		ArrayList<Object> elementos = new ArrayList<Object>();
		ArrayList<NoRN> preOrderAux = this.preOrder(this.raiz, false);
		int tam = preOrderAux.size();
		for(int i = 0; i < tam; i++) {
			elementos.add(preOrderAux.get(i).getElemento());
		}
		return elementos;
	}

	public ArrayList<NoRN> nos() {
		ArrayList<NoRN> nos = new ArrayList<NoRN>();
		ArrayList<NoRN> preOrderAux = this.preOrder(this.raiz, false);
		int tam = preOrderAux.size();
		for(int i = 0; i < tam; i++) {
			nos.add(preOrderAux.get(i));
		}
		return nos;
	}

	public NoRN root() {
		return raiz;
	}

	public NoRN parent(NoRN filho) {
		return filho.getPai();
	}

	public ArrayList<NoRN> children(NoRN pai) {
		ArrayList<NoRN> filhos = new ArrayList<NoRN>();
		if(pai.getFilhoEsquerdo() != null) {
			filhos.add(pai.getFilhoEsquerdo());
		}
		if(pai.getFilhoDireito() != null) {
			filhos.add(pai.getFilhoDireito());
		}
		return filhos;
	}

	public boolean isInternal(NoRN no) {
		return (!this.isExternal(no))?true:false;
	}

	public boolean isExternal(NoRN no) {
		return (no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null)?true:false;
	}

	public boolean isRoot(NoRN no) {
		return (no != raiz)?false:true;
	}

	public int depth(NoRN no) {
		if(no == null) return -1;
		if(this.isRoot(no)) return 0;
		else return 1 + depth(no.getPai());
	}

	public Object replace(NoRN no, int v) { //precisa consertar
		int old = no.getElemento();
		no.setElemento(v);
		return old;
	}
	
	public void swapElements(NoRN no1, NoRN no2) { //precisa consertar
		int aux = no1.getElemento();
		no1.setElemento(no2.getElemento());
		no2.setElemento(aux);
	}

	public void insert(NoRN no, int valor) {
		if(raiz == null) {
            raiz =  new NoRN(valor, null, null, null);
            raiz.setCor('N');
		}
		else {
			if(valor < no.getElemento()) { //inserção à esquerda
				if(no.getFilhoEsquerdo() != null) {
					insert(no.getFilhoEsquerdo(), valor);
				}
				else {
					NoRN novo = new NoRN(valor,no, null, null);
					no.setFilhoEsquerdo(novo);
					this.atualizaCor(novo, null, true);
				}
			}
			else {
				if(no.getFilhoDireito() != null) { //inserção à direita
					insert(no.getFilhoDireito(), valor);
				}
				else {
					NoRN novo = new NoRN(valor,no, null, null);
					no.setFilhoDireito(novo);
					this.atualizaCor(novo, null, true);
				}
			}
		}
	}

	public Object remove(NoRN no) {
		int valor = 0;
		//folha
		if(this.isExternal(no)) {
			if(this.isRoot(no)) {
				valor = no.getElemento();
				no.clear();
				this.raiz = null;
				return valor;
			}
			valor = no.getElemento();
			this.atualizaCor(no, null, false);
		}
		else {
			int qtdF = this.children(no).size();
			//1 filho
			if(qtdF == 1) {
				valor = no.getElemento();
				if(no.getPai().getFilhoDireito() == no) { //eh o filho direito do pai
					if(no.getFilhoEsquerdo() != null) { //so tem filho na esquerda
						this.atualizaCor(no, no.getFilhoEsquerdo(), false);
						// no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
						// no.getFilhoEsquerdo().setPai(no.getPai());
						// no.clear();
					}
					else { //so tem filho na direita
						this.atualizaCor(no, no.getFilhoDireito(), false);
						//no.getPai().setFilhoDireito(no.getFilhoDireito());
						//no.getFilhoDireito().setPai(no.getPai());
						//no.clear();
					}
				}
				else {
					if(no.getFilhoEsquerdo() != null) { //so tem filho na esquerda
						this.atualizaCor(no, no.getFilhoEsquerdo(), false);
						//no.getPai().setFilhoEsquerdo(no.getFilhoEsquerdo());
						//no.getFilhoEsquerdo().setPai(no.getPai());
						//no.clear();
					}
					else { //so tem filho na direita
						this.atualizaCor(no, no.getFilhoDireito(), false);
						//no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
						//no.getFilhoDireito().setPai(no.getPai());
						//no.clear();
					}
				}
			}
			else { //2 filhos
				valor = no.getElemento(); 
				NoRN aux = no.getFilhoDireito();
				NoRN sub = null; //o substituto do nó que sera removido
				while(aux != null) {
					sub = aux; //nó mais a esquerda da sub-arvore direita (sucessor)
					aux = aux.getFilhoEsquerdo();
				}
				no.setElemento(sub.getElemento());
				//talvez chamar o atualizador aqui
				remove(sub);
			}
		}
		return valor;
	}
	
	public ArrayList<NoRN> preOrder(NoRN no, boolean visitado) {
		if(!visitado) {
			listaPreOrder = new ArrayList<NoRN>();
			if (no == null) return listaInOrder;
		}
		listaPreOrder.add(no);
		if(no.getFilhoEsquerdo() != null) {
			preOrder(no.getFilhoEsquerdo(), true);
		}
		if(no.getFilhoDireito() != null) {
			preOrder(no.getFilhoDireito(), true);
		}
		return listaPreOrder;
	}

	public ArrayList<NoRN> inOrder(NoRN no, boolean visitado) {
		if(!visitado) {
			listaInOrder = new ArrayList<NoRN>();
			if (no == null) return listaInOrder;
		}
		if(no.getFilhoEsquerdo() != null) {
			inOrder(no.getFilhoEsquerdo(), true);
		}
		listaInOrder.add(no);
		if(no.getFilhoDireito() != null) {
			inOrder(no.getFilhoDireito(), true);
		}
		return listaInOrder;
	}
	
	public ArrayList<NoRN> posOrder(NoRN no, boolean visitado) {
		if(!visitado) {
			listaPosOrder = new ArrayList<NoRN>();
			if (no == null) return listaInOrder;
		}
		if(no.getFilhoEsquerdo() != null) {
			posOrder(no.getFilhoEsquerdo(), true);
		}
		if(no.getFilhoDireito() != null) {
			posOrder(no.getFilhoDireito(), true);
		}
		listaPosOrder.add(no);
		if(!visitado) {
			return listaPosOrder;
		}
		return null;
	}
	
	public String mostraArvore() {
		String arvoreCompleta = "";
		
		ArrayList<NoRN> nos = this.inOrder(this.raiz, false);
		
		int largura = nos.size();
		int altura = this.height(this.raiz);
		
		String[][] arvore = new String[altura+1][largura];
		
		NoRN no = null;
		int l = 0;
		
		for(int i=0; i<largura; i++) {
			no = nos.get(i);
			l = this.depth(no);
			arvore[l][i] = String.valueOf(no.getElemento()) + "-" + no.getCor();
		}
		
		for(int i=0; i<altura+1; i++) {
			for(int j=0; j<largura; j++) {
				if(arvore[i][j] == null) {
					arvoreCompleta += "    ";
				}
				else {
					arvoreCompleta += arvore[i][j];
				}
				//arvoreCompleta += arvore[i][j];
			}
			arvoreCompleta += "\n";
		}
		return arvoreCompleta;
	}
	
	public NoRN search(int valor, NoRN no) {
		NoRN aux = null;
		if(valor == no.getElemento()) {
			return no;
		}
		if(valor < no.getElemento()) {
			aux = this.search(valor, no.getFilhoEsquerdo());
		}
		if(valor > no.getElemento()) {
			aux =this.search(valor, no.getFilhoDireito());
		}
		no = aux;
		return no;
	}
	
	public NoRN leftChild(NoRN no) {
		return no.getFilhoEsquerdo();
	}
	
	public NoRN rightChild(NoRN no) {
		return no.getFilhoDireito();
	}
	
	public boolean hasLeftChild(NoRN no) {
		return (no.getFilhoEsquerdo() != null)?true:false;
	}
	
	public boolean hasRightChild(NoRN no) {
		return (no.getFilhoDireito() != null)?true:false;
	}
	
	private void rotacaoSimplesEsquerda(NoRN no) { 
		NoRN filhoDireito = no.getFilhoDireito(); // sub arvore direita
		NoRN filhoEsquerdoSub = no.getFilhoDireito().getFilhoEsquerdo(); 
		no.setFilhoDireito(filhoEsquerdoSub);
		filhoDireito.setFilhoEsquerdo(no);
		filhoDireito.setPai(no.getPai());
		
		if (filhoEsquerdoSub != null) filhoEsquerdoSub.setPai(no);
		
		if (no.getPai() != null && no.getPai().getFilhoEsquerdo() == no) {
			no.getPai().setFilhoEsquerdo(filhoDireito);
		} else if (no.getPai() != null) {
			no.getPai().setFilhoDireito(filhoDireito);
		}
		
		no.setPai(filhoDireito);
		
		if (filhoDireito.getPai() == null) {
			this.raiz = filhoDireito;	
		}
	}
	
	private void rotacaoSimplesDireita(NoRN no) {
		NoRN filhoEsquerdo = no.getFilhoEsquerdo(); // sub arvore esquerda
		NoRN filhoDireitoSub = no.getFilhoEsquerdo().getFilhoDireito();
		no.setFilhoEsquerdo(filhoDireitoSub);
		filhoEsquerdo.setFilhoDireito(no);
		filhoEsquerdo.setPai(no.getPai());
		
		if (filhoDireitoSub != null) filhoDireitoSub.setPai(no);
		
		if (no.getPai() != null && no.getPai().getFilhoDireito() == no) { // condição para desacoplar o no
			no.getPai().setFilhoDireito(filhoEsquerdo);
		} else if (no.getPai() != null) {
			no.getPai().setFilhoEsquerdo(filhoEsquerdo);
		}
		
		no.setPai(filhoEsquerdo);
		
		if (filhoEsquerdo.getPai() == null) {
			this.raiz = filhoEsquerdo;
		}
	}
	
	private void rotacaoDuplaDireita(NoRN no) { 
		this.rotacaoSimplesEsquerda(no.getFilhoEsquerdo());
		this.rotacaoSimplesDireita(no);
	}
	
	private void rotacaoDuplaEsquerda(NoRN no) {
		this.rotacaoSimplesDireita(no.getFilhoDireito());
		this.rotacaoSimplesEsquerda(no);
	}

	private boolean isZigzag(NoRN no) {
		if (no == no.getPai().getFilhoEsquerdo() && no.getAvo().getFilhoDireito() == no.getPai()) {
			return true;
		} else if (no == no.getPai().getFilhoDireito() && no.getAvo().getFilhoEsquerdo() == no.getPai()) {
			return true;
		}
		return false;
	}
	
	private void atualizaCor(NoRN no, NoRN sucessor, boolean insercao) { 
		if (insercao) {

			if (no == null) return;
			
			if (no == this.raiz) {
                no.setCor('N');
                return;
			}

            if (no.getPai().getCor() == 'R' && (no.getTio() != null && no.getTio().getCor() == 'R')) {
                no.getPai().setCor('N');
				no.getTio().setCor('N');
				if(no.getAvo() != raiz)
				no.getAvo().setCor('R');
				this.atualizaCor(no.getAvo(), null, true);

            } else if (no.getPai().getCor() == 'R' && (no.getTio() == null || no.getTio().getCor() == 'N')) {
				if (this.isZigzag(no)) {
					no.setCor('N');
					no.getAvo().setCor('R');
					if (no == no.getPai().getFilhoEsquerdo()) {
						this.rotacaoDuplaEsquerda(no.getAvo());
					} else {
						this.rotacaoDuplaDireita(no.getAvo());
					}
				} else {
					no.getPai().setCor('N');
					no.getAvo().setCor('R');
					if (no == no.getPai().getFilhoDireito()) {
						this.rotacaoSimplesEsquerda(no.getAvo()); 
					} else {
						this.rotacaoSimplesDireita(no.getAvo());
					}
				}
				this.atualizaCor(no.getAvo(), null, true);
			}
			return;			
			
		} else {
			if (this.isExternal(no)) {
				if (no.getCor() == 'R') {
					if (no.getPai().getFilhoEsquerdo() == no) {
						no.getPai().setFilhoEsquerdo(null);
					} else {
						no.getPai().setFilhoDireito(null);
					}
					no.clear();
				} else {
					no.setCor('D');
					this.escolheCaso(no);
					if (no.getPai().getFilhoEsquerdo() == no) {
						no.getPai().setFilhoEsquerdo(null);
					} else {
						no.getPai().setFilhoDireito(null);
					}
					no.clear();
				}
			} else {
				if (no.getCor() == 'N' && sucessor.getCor() == 'R') {
					no.setElemento(sucessor.getElemento());
					if (no.getFilhoEsquerdo() == sucessor) {
						no.setFilhoEsquerdo(null);
						sucessor.clear();
					} else {
						no.setFilhoDireito(null);
						sucessor.clear();
					}
				}
			}
		}
	}

	private void escolheCaso(NoRN no) {
		
		if(no == null) return;
		
		if (no.getCor() != 'D') return; 
		
		if (this.isRoot(no)) {
			this.caso1(no);
			return;
		}

		NoRN irmao = null;
		NoRN sobrinhoEsq = null;
		NoRN sobrinhoDir = null;
		if (no.getPai().getFilhoDireito() == no) {
			irmao = no.getPai().getFilhoEsquerdo();
			if (irmao != null) {
				sobrinhoEsq = irmao.getFilhoEsquerdo();
				sobrinhoDir = irmao.getFilhoDireito();
			}
		} else {
			irmao = no.getPai().getFilhoDireito();
			if (irmao != null) {
				sobrinhoEsq = irmao.getFilhoEsquerdo();
				sobrinhoDir = irmao.getFilhoDireito();
			}
		}

		if (no.getPai().getCor() == 'N' 
		&& (irmao == null || irmao.getCor() == 'R') 
		&& (irmao == null || (sobrinhoDir == null || sobrinhoDir.getCor() == 'N')) 
		&& (irmao == null || (sobrinhoEsq == null || sobrinhoEsq.getCor() == 'N'))) {
			NoRN pai = no.getPai();
			this.caso2(no, pai, irmao);
			escolheCaso(no);

		} else if (no.getPai().getCor() == 'N' 
		&& (irmao == null || irmao.getCor() == 'N') 
		&& (irmao == null || (sobrinhoDir == null || sobrinhoDir.getCor() == 'N')) 
		&& (irmao == null || (sobrinhoEsq == null || sobrinhoEsq.getCor() == 'N'))) {
			NoRN pai = no.getPai();
			this.caso3(no, pai, irmao);
			escolheCaso(pai);

		} else if (no.getPai().getCor() == 'R' 
		&& (irmao == null || irmao.getCor() == 'N') 
		&& (irmao == null || (sobrinhoDir == null || sobrinhoDir.getCor() == 'N')) 
		&& (irmao == null || (sobrinhoEsq == null || sobrinhoEsq.getCor() == 'N'))) {
			this.caso4(no, irmao);

		} else if (no.getPai().getCor() == 'N' 
		&& (irmao == null || irmao.getCor() == 'N') 
		&& (irmao == null || (sobrinhoDir == null || sobrinhoDir.getCor() == 'N')) 
		&& (irmao == null || (sobrinhoEsq.getCor() == 'R'))) {
			this.caso5(no, irmao, sobrinhoEsq, sobrinhoDir);
			escolheCaso(no);

		} else if ((no.getPai().getCor() == 'R' || no.getPai().getCor() == 'N') 
		&& (irmao == null || irmao.getCor() == 'N') 
		&& (irmao == null || (sobrinhoDir == null || sobrinhoDir.getCor() == 'R')) 
		&& (irmao == null || (sobrinhoEsq == null || (sobrinhoEsq.getCor() == 'N' || sobrinhoEsq.getCor() == 'R')))) {
			NoRN pai = no.getPai();
			this.caso6(no, pai, sobrinhoDir, sobrinhoEsq);
		}
	}

	private void caso1(NoRN no) {
		no.setCor('N');
	}

	private void caso2(NoRN no, NoRN pai, NoRN irmao) {
		if (pai.getFilhoEsquerdo() == no) {
			this.rotacaoSimplesEsquerda(pai);
			pai.setCor('R');
			irmao.setCor('N');
		} else {
			this.rotacaoSimplesDireita(pai);
			pai.setCor('R');
			irmao.setCor('N');
		}
	}

	private void caso3(NoRN no, NoRN pai, NoRN irmao) {
		pai.setCor('D');
		no.setCor('N');
		irmao.setCor('R');
		// if(this.isRoot(pai)) {
		// 	if (pai.getFilhoDireito() == no) {
		// 		pai.setFilhoDireito(null);
		// 	} else {
		// 		pai.setFilhoEsquerdo(null);
		// 	} 
		// 	no.clear();
		// }
	}

	private void caso4(NoRN no, NoRN irmao) {
		no.getPai().setCor('N');
		if (irmao != null) irmao.setCor('R');
		if (no.getPai().getFilhoEsquerdo() == no){
			//no.getPai().setFilhoEsquerdo(null);
		} else {
			//no.getPai().setFilhoDireito(null);
		}
		//no.clear();
	}

	private void caso5(NoRN no, NoRN irmao, NoRN sobrEsq, NoRN sobrDir) {
		if (irmao != null) {
			if(no.getPai().getFilhoEsquerdo() == no){
				this.rotacaoSimplesDireita(irmao);
				irmao.setCor('R');
				sobrEsq.setCor('N');
			} else {
				this.rotacaoSimplesEsquerda(irmao);
				irmao.setCor('R');
				if (sobrDir != null) sobrDir.setCor('N');
			}
		}
	}

	private void caso6(NoRN no, NoRN pai, NoRN sobrDir, NoRN sobrEsq) {
		if (pai.getFilhoEsquerdo() == no) {
			no.setCor('N');
			//pai.setFilhoEsquerdo(null);
			this.rotacaoSimplesEsquerda(pai);
			if(sobrDir != null) sobrDir.setCor('N');
			//no.clear();
		} else {
			no.setCor('N');
			//pai.setFilhoDireito(null);
			this.rotacaoSimplesDireita(pai);
			if (sobrEsq != null) sobrEsq.setCor('N');
			//no.clear();
		}
	}
	
}
