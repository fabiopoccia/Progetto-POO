package model;

import java.util.Date;

public class Prenotazione {
    private String codicePrenotazione;
    private Date dataPrenotazione;
    private int durata;
    private Date dataAttività;
    private int numeroPosti;
    private String stato;
    private double prezzoTotale;
    private double prezzoEscursione;
    private int postiDaPrenotare;

    public Prenotazione(String codicePrenotazione, Date dataPrenotazione, int durata, Date dataAttività, int numeroPosti, String stato, double prezzoEscursione, int postiDaPrenotare) {
        this.codicePrenotazione = codicePrenotazione;
        this.dataPrenotazione = dataPrenotazione;
        this.durata = durata;
        this.dataAttività = dataAttività;
        this.numeroPosti = numeroPosti;
        this.stato = stato;
        this.prezzoEscursione = prezzoEscursione;
        this.postiDaPrenotare = postiDaPrenotare;
        this.prezzoTotale = calcolaPrezzoTotale();
    }


    public String getCodicePrenotazione() { return codicePrenotazione; }
    public void setCodicePrenotazione(String codicePrenotazione) { this.codicePrenotazione = codicePrenotazione; }

    public Date getDataPrenotazione() { return dataPrenotazione; }
    public void setDataPrenotazione(Date dataPrenotazione) { this.dataPrenotazione = dataPrenotazione; }

    public int getDurata() { return durata; }
    public void setDurata(int durata) { this.durata = durata; }

    public Date getDataAttività() { return dataAttività; }
    public void setDataAttività(Date dataAttività) { this.dataAttività = dataAttività; }

    public int getNumeroPosti() { return numeroPosti; }
    public void setNumeroPosti(int numeroPosti) { this.numeroPosti = numeroPosti; }

    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }

    public double getPrezzoTotale() { return prezzoTotale; }
    public double getPrezzoEscursione() { return prezzoEscursione; }
    public void setPrezzoEscursione(double prezzoEscursione) { this.prezzoEscursione = prezzoEscursione; }

    public int getPostiDaPrenotare() { return postiDaPrenotare; }
    public void setPostiDaPrenotare(int postiDaPrenotare) { this.postiDaPrenotare = postiDaPrenotare; }


    // Calcola e aggiorna il prezzo totale (prezzo * posti)
    public double calcolaPrezzoTotale() {
        prezzoTotale = prezzoEscursione * postiDaPrenotare;
        return prezzoTotale;
    }

    // Conferma la prenotazione
    public void conferma() {
        if (stato.equals("annullata")) {
            System.out.println("Errore: non puoi confermare una prenotazione annullata.");
        } else {
            stato = "confermata";
            System.out.println("Prenotazione " + codicePrenotazione + " confermata.");
        }
    }

    // Annulla la prenotazione
    public void annulla() {
        if (stato.equals("confermata")) {
            System.out.println("Errore: non puoi annullare una prenotazione già confermata.");
        } else {
            stato = "annullata";
            System.out.println("Prenotazione " + codicePrenotazione + " annullata.");
        }
    }


    // Modifica il numero di posti e ricalcola il prezzo
    public void modificaNumeroPosti(int posti) {
        if (posti > 0) {
            this.postiDaPrenotare = posti;
            calcolaPrezzoTotale(); // aggiorna il prezzo
            System.out.println("Posti aggiornati a " + posti + ", nuovo totale: " + prezzoTotale + "€");
        } else {
            System.out.println("Errore: il numero di posti deve essere maggiore di 0.");
        }
    }

    // Modifica la data dell'attività
    public void modificaData(Date data) {
        this.dataAttività = data;
        System.out.println("Data aggiornata: " + data);
    }

    // Restituisce true se la prenotazione è confermata
    public boolean isConfermata() {
        return stato.equals("confermata");
    }

    // Restituisce true se la prenotazione è annullata
    public boolean isAnnullata() {
        return stato.equals("annullata");
    }


    // Genera una ricevuta testuale della prenotazione
    public String generaRicevuta() {
        return "   RICEVUTA   " + "\nCodice: " + codicePrenotazione + "\nData prenotazione: " + dataPrenotazione +
                "\nData attività: " + dataAttività + "\nDurata: " + durata + "h" + "\nPosti prenotati: " + postiDaPrenotare +
                "\nPrezzo a persona: " + prezzoEscursione + "€" + "\nTotale: " + prezzoTotale + "€" + "\nStato: " + stato;
    }

    // Mostra i dettagli della prenotazione
    public String visualizzaDettagli() {
        return "Prenotazione{" + "codice='" + codicePrenotazione + '\'' + ", dataAttività=" + dataAttività +
                ", posti=" + postiDaPrenotare + ", totale=" + prezzoTotale + "€" + ", stato='" + stato + '\'' + '}';
    }


}