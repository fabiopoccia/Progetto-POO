package model;

import java.util.Date;

public class Attivita {
    private String codiceAttività;
    private Date dataPrenotazione;
    private String titolo;
    private int durata;
    private int difficoltà;
    private double prezzo;
    private int postiDisponibili;
    private int postiTotali; // <-- aggiunto per tenere traccia dei posti totali

    public Attivita(String codiceAttività, Date dataPrenotazione, String titolo, int durata, int difficoltà, double prezzo, int postiDisponibili) {
        this.codiceAttività = codiceAttività;
        this.dataPrenotazione = dataPrenotazione;
        this.titolo = titolo;
        this.durata = durata;
        this.difficoltà = difficoltà;
        this.prezzo = prezzo;
        this.postiDisponibili = postiDisponibili;
        this.postiTotali = postiDisponibili; // all'inizio i posti totali = posti disponibili
    }


    public String getCodiceAttività() { return codiceAttività; }
    public void setCodiceAttività(String codiceAttività) { this.codiceAttività = codiceAttività; }

    public Date getDataPrenotazione() { return dataPrenotazione; }
    public void setDataPrenotazione(Date dataPrenotazione) { this.dataPrenotazione = dataPrenotazione; }

    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public int getDurata() { return durata; }
    public void setDurata(int durata) { this.durata = durata; }

    public int getDifficoltà() { return difficoltà; }
    public void setDifficoltà(int difficoltà) { this.difficoltà = difficoltà; }

    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public int getPostiDisponibili() { return postiDisponibili; }
    public void setPostiDisponibili(int postiDisponibili) { this.postiDisponibili = postiDisponibili; }

    public int getPostiTotali() { return postiTotali; }


    //Verifica se ci sono almeno 'posti' posti disponibili
    public boolean verificaDisponibilita(int posti) {
        return postiDisponibili >= posti;
    }

    //Prenota un certo numero di posti se disponibili
    public void prenotaPosti(int posti) {
        if (verificaDisponibilita(posti)) {
            postiDisponibili -= posti;
        } else {
            System.out.println("Errore: solo " + postiDisponibili + " posti disponibili.");
        }
    }

    //Annulla una prenotazione e rimette i posti disponibili
    public void annullaPrenotazione(int posti) {
        if (postiDisponibili + posti <= postiTotali) {
            postiDisponibili += posti;
        } else {
            System.out.println("Errore: non puoi liberare più posti di quelli totali.");
        }
    }

    //Restituisce una stringa con i dettagli principali dell'attività
    public String getDettagli() {
        return "Codice: " + codiceAttività +
                " | Titolo: " + titolo +
                " | Durata: " + durata + "h" +
                " | Difficoltà: " + difficoltà +
                " | Prezzo: " + prezzo + "€" +
                " | Posti disponibili: " + postiDisponibili + "/" + postiTotali;
    }


    //Aggiorna il prezzo (non può essere negativo)
    public void aggiornaPrezzo(double nuovoPrezzo) {
        if (nuovoPrezzo >= 0) {
            this.prezzo = nuovoPrezzo;
        } else {
            System.out.println("Errore: il prezzo non può essere negativo.");
        }
    }

    //Restituisce true se non ci sono più posti disponibili
    public boolean isSoldOut() {
        return postiDisponibili == 0;
    }

    //Aggiunge posti disponibili (es. capacità aumentata)
    public void aggiungiPosti(int quantita) {
        postiDisponibili += quantita;
        postiTotali += quantita;
    }

    //Rimuove posti totali (solo se non già occupati)
    public void rimuoviPosti(int quantita) {
        if (postiDisponibili >= quantita) {
            postiDisponibili -= quantita;
            postiTotali -= quantita;
        } else {
            System.out.println("Errore: non puoi rimuovere posti già occupati.");
        }
    }

    /**
     * Restituisce il numero di posti occupati (prenotati)
     */
    public int getPostiOccupati() {
        return postiTotali - postiDisponibili;
    }

    /**
     * Restituisce la percentuale di occupazione (0.0 - 100.0)
     */
    public double percentualeOccupazione() {
        if (postiTotali == 0) return 0;
        return ((double) getPostiOccupati() / postiTotali) * 100;
    }

    // ========================= OVERRIDE =========================

    @Override
    public String toString() {
        return "Attivita{" +
                "codice='" + codiceAttività + '\'' +
                ", titolo='" + titolo + '\'' +
                ", durata=" + durata +
                ", difficoltà=" + difficoltà +
                ", prezzo=" + prezzo +
                ", posti=" + postiDisponibili + "/" + postiTotali +
                '}';
    }

}