package model;

import java.util.Date;

public class Recensione {
    private String codiceRecensione;
    private String testo;
    private int voto;
    private Date data;

    public Recensione(String codiceRecensione, String testo, int voto, Date data) {
        this.codiceRecensione = codiceRecensione;
        this.testo = testo;
        this.voto = voto;
        this.data = data;
    }



    public String getCodiceRecensione() { return codiceRecensione; }
    public void setCodiceRecensione(String codiceRecensione) { this.codiceRecensione = codiceRecensione; }

    public String getTesto() { return testo; }

    public int getVoto() { return voto; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }



    public void modificaTesto(String nuovoTesto) {
        if (nuovoTesto != null && !nuovoTesto.isEmpty()) {
            this.testo = nuovoTesto;
        } else {
            System.out.println("Errore: il testo non può essere vuoto.");
        }
    }


    public void modificaVoto(int nuovoVoto) {
        if (nuovoVoto >= 1 && nuovoVoto <= 5) {
            this.voto = nuovoVoto;
        } else {
            System.out.println("Errore: il voto deve essere compreso tra 1 e 5.");
        }
    }


    // true se il voto è >= 4
    public boolean valutazionePositiva() {
        return voto >= 4;
    }

    // true se il voto è <= 2
    public boolean valutazioneNegativa() {
        return voto <= 2;
    }

    // restituisce il numero di caratteri del testo
    public int lunghezzaRecensione() {
        return testo.length();
    }


    public String visualizzaRecensione() {
        return "Recensione del " + data + "\nVoto: " + voto + "/5" + "\n" + testo;
    }


}