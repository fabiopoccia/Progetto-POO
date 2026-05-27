package model;

import java.util.Date;

public class AttivitaNaturalistica extends Attivita {

    private String stagioneMigliore;
    private boolean preparazioneFisicaRichiesta;

    public AttivitaNaturalistica(String codiceAttività, Date dataPrenotazione, String titolo, int durata, int difficoltà, double prezzo, int postiDisponibili, String stagioneMigliore, boolean preparazioneFisicaRichiesta) {
        super(codiceAttività, dataPrenotazione, titolo, durata, difficoltà, prezzo, postiDisponibili);
        this.stagioneMigliore = stagioneMigliore;
        this.preparazioneFisicaRichiesta = preparazioneFisicaRichiesta;
    }

    // restituisce la stagione migliore
    public String getStagioneMigliore() {
        return this.stagioneMigliore;
    }

    //verifica idoneità utente nel caso in cui è richiesta una preparazione fisica
    public boolean verificaIdoneita(Utente u) {
        if (u == null) {
            return false;
        }
        if (this.preparazioneFisicaRichiesta && u.getEta() < 16) {
            return false;
        }
        return true;
    }
}
