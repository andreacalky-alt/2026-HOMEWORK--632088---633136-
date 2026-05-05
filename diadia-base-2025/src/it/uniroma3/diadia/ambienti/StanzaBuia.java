package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private String attrezzoPerVedere;

    /**
     * Crea una stanza buia.
     * @param nome il nome della stanza
     * @param attrezzoPerVedere il nome dell'attrezzo necessario per illuminare la stanza
     */
    public StanzaBuia(String nome, String attrezzoPerVedere) {
        super(nome);
        this.attrezzoPerVedere = attrezzoPerVedere;
    }

    /**
     * Restituisce la descrizione della stanza.
     * Se l'attrezzo per vedere non è presente, restituisce "qui c'è un buio pesto".
     * @return la descrizione della stanza
     */
    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(this.attrezzoPerVedere)) {
            return "qui c'è un buio pesto";
        }
        return super.getDescrizione();
    }
}
    
