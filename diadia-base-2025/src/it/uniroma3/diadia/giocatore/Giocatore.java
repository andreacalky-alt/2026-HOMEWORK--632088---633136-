package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Giocatore {

	private int cfu;
	private Borsa borsa;
	static final private int CFU_INIZIALI = 20;

	public Giocatore() {
		this(CFU_INIZIALI);
	}
	public Giocatore(int cfu) {
		this.cfu= cfu;
		this.borsa = new Borsa();
	}

	

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}

	

	public boolean mettiAttrezzonellaBorsa(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}

	

	public Attrezzo prendiAttrezzoDallaBorsa(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}

	public Borsa getBorsa() {
		return this.borsa;
	}

	public String getContenutoBorsa() {
		return this.borsa.toString();
	}
}