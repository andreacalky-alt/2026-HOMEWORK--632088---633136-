package it.uniroma3.diadia;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	Borsa borsa;
	Attrezzo attrezzoTest,attrezzoTestMax;

	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.attrezzoTest = new Attrezzo("attrezzoTest", 1);
		this.attrezzoTestMax = new Attrezzo("attrezzoTestMax",this.borsa.getPesoMax() + 1);
	}

	
	@Test
	void testAddAttrezzo_BorsaPiena_False() {
		int i = 0;
		while(!this.borsa.isFull()) {
			Attrezzo attrezzo = new Attrezzo("oggetto" + i,1);
			this.borsa.addAttrezzo(attrezzo);
			i++;
		}

		assertFalse(this.borsa.addAttrezzo(attrezzoTest));

	}

	@Test
	void testAddAttrezzo_BorsaPesante_False() {

		assertFalse(this.borsa.addAttrezzo(attrezzoTestMax));

	}

	@Test
	void testAddAttrezzo_BorsaVuota_True() {
		assertTrue(this.borsa.addAttrezzo(attrezzoTest));
	}

	@Test
	void testAddAttrezzo_BorsaConAltriOggetti_True() {
		this.borsa.addAttrezzo(attrezzoTest);
		assertTrue(this.borsa.addAttrezzo(attrezzoTest));
	}

	
	@Test
	void testIsEmpty_False() {
		this.borsa.addAttrezzo(attrezzoTest);
		assertFalse(this.borsa.isEmpty());
	}
	@Test
	void testIsEmpty_True() {
		assertTrue(this.borsa.isEmpty());
	}



	@Test
	void testHasAttrezzo_Borsavuota_False() {
		assertFalse(this.borsa.hasAttrezzo("attrezzoTest"));
	}
	@Test
	void testHasAttrezzo_BorsaPiena_False() {
		int i = 0;
		while(!this.borsa.isFull()) {
			Attrezzo attrezzo = new Attrezzo("oggetto" + i,1);
			this.borsa.addAttrezzo(attrezzo);
			i++;
		}
		assertFalse(this.borsa.hasAttrezzo("attrezzoTest"));
	}

	@Test
	void testHasAttrezzo_Borsa_True() {
		this.borsa.addAttrezzo(attrezzoTest);
		assertTrue(this.borsa.hasAttrezzo("attrezzoTest"));
	}

	
	@Test
	void testRemoveAttrezzo_BorsaVuota_Null() {
		assertNull(this.borsa.removeAttrezzo("attrezzoTest"));
	}

	@Test
	void testRemoveAttrezzo_BorsaPiena_Null() {
		int i = 0;
		while(!this.borsa.isFull()) {
			Attrezzo attrezzo = new Attrezzo("oggetto" + i,1);
			this.borsa.addAttrezzo(attrezzo);
			i++;
		}
		assertNull(this.borsa.removeAttrezzo("attrezzoTest"));
	}

	@Test
	void testRemoveAttrezzo_BorsaConOggetto_Oggetto() {
		this.borsa.addAttrezzo(attrezzoTest);
		assertEquals(attrezzoTest,this.borsa.removeAttrezzo("attrezzoTest"));
	}

}