package arvoreRN;

public class NoRN {

	private int elemento;
	private NoRN pai, esquerdo, direito;
	private char cor;
	
	public NoRN(int elemento, NoRN pai, NoRN esquerdo, NoRN direito) {
		this.setElemento(elemento);
		this.setPai(pai);
		this.setFilhoEsquerdo(esquerdo);
		this.setFilhoDireito(direito);
		this.setCor('R');
	}

	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public NoRN getPai() {
		return pai;
	}

	public void setPai(NoRN pai) {
		this.pai = pai;
	}

	public NoRN getFilhoEsquerdo() {
		return esquerdo;
	}

	public void setFilhoEsquerdo(NoRN esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NoRN getFilhoDireito() {
		return direito;
	}

	public void setFilhoDireito(NoRN direito) {
		this.direito = direito;
	}

	public void clear() {
		//this.setElemento(null);
		this.setPai(null);
		this.setFilhoEsquerdo(null);
		this.setFilhoDireito(null);
	}

	public char getCor() {
		return cor;
	}

	public void setCor(char cor) {
		this.cor = cor;
	}

	public NoRN getAvo() {
		return this.pai.getPai();
	}

	public NoRN getTio() {
		if (this.getAvo() == null) {
			return null;
		}
		if (this.pai.getElemento() > this.getAvo().getElemento()) {
			return this.getAvo().getFilhoEsquerdo();
		} else {
			return this.getAvo().getFilhoDireito();
		}
	}
	
}