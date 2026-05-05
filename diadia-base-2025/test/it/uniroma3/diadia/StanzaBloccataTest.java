package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacenteLibera;
	private Stanza stanzaOltreIlBlocco;
	private Attrezzo passepartout;

	@BeforeEach
	public void setUp() {
		// Creo un mini-labirinto
		this.stanzaBloccata = new StanzaBloccata("Stanza Chiusa", "nord", "passepartout");
		this.stanzaOltreIlBlocco = new Stanza("Stanza del Tesoro");
		this.stanzaAdiacenteLibera = new Stanza("Corridoio");
		this.passepartout = new Attrezzo("passepartout", 1);
		
		// Imposto le stanze adiacenti
		this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaOltreIlBlocco);
		this.stanzaBloccata.impostaStanzaAdiacente("sud", this.stanzaAdiacenteLibera);
	}

	@Test
	public void testGetStanzaAdiacente_DirezioneBloccataSenzaAttrezzo() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"), 
				"Senza passepartout, se provo ad andare a nord resto nella stanza bloccata");
	}

	@Test
	public void testGetStanzaAdiacente_DirezioneBloccataConAttrezzo() {
		this.stanzaBloccata.addAttrezzo(passepartout);
		assertEquals(this.stanzaOltreIlBlocco, this.stanzaBloccata.getStanzaAdiacente("nord"), 
				"Con il passepartout nella stanza, devo poter passare alla stanza a nord");
	}

	@Test
	public void testGetStanzaAdiacente_DirezioneLiberaSenzaAttrezzo() {
		assertEquals(this.stanzaAdiacenteLibera, this.stanzaBloccata.getStanzaAdiacente("sud"), 
				"Verso sud la stanza non è bloccata, devo poter passare anche senza passepartout");
	}
}
