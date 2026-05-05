package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class DiaDiaSimulatorTest {

	@Test
	public void testPartitaSimulata_ComandoFineImmediato() {
		// 1. Prepariamo l'input: l'utente digita solo "fine"
		List<String> comandi = Arrays.asList("fine");
		
		// 2. Creiamo il simulatore iniettando i comandi finti
		IOSimulator io = new IOSimulator(comandi);
		
		// 3. Facciamo partire il gioco passandogli il simulatore (Polimorfismo in azione!)
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		
		// 4. Analizziamo l'output catturato
		List<String> messaggi = io.getMessaggiProdotti();
		
		// Il gioco si è chiuso correttamente stampando il messaggio di ringraziamento?
		assertTrue(messaggi.contains("Grazie di aver giocato!"));
	}
	
	@Test
	public void testPartitaSimulata_ComandoVaiEFine() {
		// 1. Prepariamo una sequenza di comandi più complessa
		List<String> comandi = Arrays.asList("vai sud", "fine");
		
		IOSimulator io = new IOSimulator(comandi);
		DiaDia gioco = new DiaDia(io);
		
		gioco.gioca();
		
		List<String> messaggi = io.getMessaggiProdotti();
		
		// Verifichiamo che il gioco abbia risposto al comando "vai" (es. stampando la nuova stanza o un errore)
		// Nota: La stringa esatta dipende da come è fatta la tua mappa iniziale!
		assertTrue(messaggi.size() > 2, "Il gioco deve aver stampato il benvenuto e le risposte ai comandi");
		assertTrue(messaggi.contains("Grazie di aver giocato!"));
	}
}
