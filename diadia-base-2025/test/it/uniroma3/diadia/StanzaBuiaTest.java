package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private Attrezzo lanterna;

	@BeforeEach
	public void setUp() {
		// Creo un labirinto "monolocale" per il test
		this.stanzaBuia = new StanzaBuia("Cantina", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 2);
	}

	@Test
	public void testGetDescrizione_SenzaAttrezzo() {
		String descrizioneBuia = "qui c'è un buio pesto";
		assertEquals(descrizioneBuia, this.stanzaBuia.getDescrizione(), 
				"Senza lanterna la stanza deve essere buia");
	}

	@Test
	public void testGetDescrizione_ConAttrezzo() {
		this.stanzaBuia.addAttrezzo(lanterna);
		String descrizioneBuia = "qui c'è un buio pesto";
		
		assertNotEquals(descrizioneBuia, this.stanzaBuia.getDescrizione(), 
				"Con la lanterna la stanza non deve più essere buia");
	}
}
