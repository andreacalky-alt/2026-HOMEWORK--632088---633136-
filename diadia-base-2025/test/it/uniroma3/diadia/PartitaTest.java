package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.partita = new Partita();
	}
	
	//---------- Test Metodo vinta() ---------------

	@Test
	public void testVinta_InizioPartita_False() {

		assertFalse(this.partita.vinta());
	}

	@Test
	public void testVinta_StanzaSbagliata_False() {
		
		Stanza stanzaSbagliata = new Stanza("Aula N8");
		this.partita.setStanzaCorrente(stanzaSbagliata);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVinta_StanzaVincente_true() {
		
	 this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
	 assertTrue(this.partita.vinta());
	}
	
	
	
	@Test
	public void testIsFinita_StanzaVincente_True() {
		
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		 assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita_FineVite_True() {
		
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita_UtenteTerminaLaPartita_True() {
		
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

}
