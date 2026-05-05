package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosa implements Comando {
	private String oggetto;


	@Override
	public void esegui(Partita partita, IO io) {
		Giocatore giocatore = partita.getGiocatore();

		if(oggetto == null) {
			io.mostraMessaggio("Che oggetto vuoi posare?");
			io.mostraMessaggio(giocatore.getContenutoBorsa());
			io.mostraMessaggio("\n");
			return;
		}
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Attrezzo attrezzoDaPosare = giocatore.prendiAttrezzoDallaBorsa(oggetto);

		if( attrezzoDaPosare != null) {

			if(stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
				io.mostraMessaggio("Attrezzo posato!");
			}
			else {
				io.mostraMessaggio("Stanza piena!");
				giocatore.mettiAttrezzonellaBorsa(attrezzoDaPosare);
			}


		}
		else
			io.mostraMessaggio("Non possiedi l'attrezzo!");
	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto  = parametro;

	}

	@Override
	public String getParametro() {
		return this.oggetto;
	}


	@Override
	public String getNome() {
		return "posa";
	}

}
