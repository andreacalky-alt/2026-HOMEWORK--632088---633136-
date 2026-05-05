package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private String direzioneBloccata;
    private String attrezzoSbloccante;

    /**
     * Crea una stanza bloccata.
     * @param nome il nome della stanza
     * @param direzioneBloccata la direzione in cui non si può procedere
     * @param attrezzoSbloccante il nome dell'attrezzo necessario per sbloccare la direzione
     */
    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata.
     * Se la direzione è quella bloccata e manca l'attrezzo sbloccante, 
     * restituisce se stessa (bloccando il passaggio).
     * @param direzione la direzione verso cui spostarsi
     */
    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(this.attrezzoSbloccante)) {
            return this;
        }
        return super.getStanzaAdiacente(direzione);
    }

    /**
     * Restituisce la descrizione della stanza avvisando del blocco.
     * @return la descrizione della stanza
     */
    @Override
    public String getDescrizione() {
        String blocco = "\nAttenzione: la direzione " + this.direzioneBloccata + 
                        " è bloccata! Ti serve l'attrezzo: " + this.attrezzoSbloccante + ".\n";
        return super.getDescrizione() + blocco;
    }

}
