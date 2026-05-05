package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

    private List<String> righeDaLeggere;
    private int indiceRigheLette;
    
    private List<String> messaggiProdotti;
    private int indiceMessaggiMostrati;

    /**
     * Costruttore che inietta i comandi finti dell'utente
     */
    public IOSimulator(List<String> righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigheLette = 0;
        this.messaggiProdotti = new ArrayList<>();
        this.indiceMessaggiMostrati = 0;
    }

    /**
     * "Finge" di leggere da tastiera prelevando dalla lista
     */
    @Override
    public String leggiRiga() {
        if (this.indiceRigheLette < this.righeDaLeggere.size()) {
            String riga = this.righeDaLeggere.get(this.indiceRigheLette);
            this.indiceRigheLette++;
            return riga;
        }
        return null; // Fine dei comandi simulati
    }

    /**
     * "Finge" di stampare a schermo salvando il messaggio in una lista
     */
    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiProdotti.add(messaggio);
    }
    
    //---------------------------------------------------------
    // Metodi aggiuntivi utili per interrogare il simulatore nei Test
    //---------------------------------------------------------
    
    public String nextMessaggio() {
        if (this.indiceMessaggiMostrati < this.messaggiProdotti.size()) {
            String msg = this.messaggiProdotti.get(this.indiceMessaggiMostrati);
            this.indiceMessaggiMostrati++;
            return msg;
        }
        return null;
    }
    
    public boolean hasNextMessaggio() {
        return this.indiceMessaggiMostrati < this.messaggiProdotti.size();
    }
    
    public List<String> getMessaggiProdotti() {
        return this.messaggiProdotti;
    }
}


