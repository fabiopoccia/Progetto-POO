package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;

public class Itinerario {
    private String titolo;
    private String descrizione;
    private Date dataCreazione;
    private int durataTotaleGiorni;
    private ArrayList<Tappa> tappe;

    public Itinerario(String titolo, String descrizione, Date dataCreazione, int durataTotaleGiorni) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.durataTotaleGiorni = durataTotaleGiorni;
        this.tappe = new ArrayList<>();
    }


    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public Date getDataCreazione() { return dataCreazione; }
    public void setDataCreazione(Date dataCreazione) { this.dataCreazione = dataCreazione; }

    public int getDurataTotaleGiorni() { return durataTotaleGiorni; }
    public void setDurataTotaleGiorni(int durataTotaleGiorni) { this.durataTotaleGiorni = durataTotaleGiorni; }

    public ArrayList<Tappa> getTappe() { return tappe; }


    // Aggiunge una tappa all'itinerario
    public void aggiungiTappa(Tappa t) {
        tappe.add(t);
        System.out.println("Tappa giorno " + t.getNumeroGiorno() + " aggiunta: " + t.getDestinazione());
    }

    // Rimuove la tappa corrispondente al giorno indicato
    public void rimuoviTappa(int giorno) {
        Tappa daRimuovere = cercaTappa(giorno);
        if (daRimuovere != null) {
            tappe.remove(daRimuovere);
            System.out.println("Tappa del giorno " + giorno + " rimossa.");
        } else {
            System.out.println("Errore: nessuna tappa trovata per il giorno " + giorno);
        }
    }

    // Ricalcola e aggiorna la durata totale in base alle tappe presenti
    public int calcolaDurataTotale() {
        durataTotaleGiorni = tappe.size();
        return durataTotaleGiorni;
    }

    // Mostra tutte le tappe dell'itinerario
    public String mostraItinerario() {
        if (tappe.isEmpty()) {
            return "L'itinerario '" + titolo + "' non ha tappe.";
        }
        String result = "   ITINERARIO: " + titolo + " \n";
        for (Tappa t : tappe) {
            result += "  Giorno " + t.getNumeroGiorno() + " | " + t.getDestinazione() + " | " + t.getDurataOre() + "h\n";
        }
        return result;
    }


    // Cerca e restituisce la tappa di un certo giorno
    public Tappa cercaTappa(int giorno) {
        for (Tappa t : tappe) {
            if (t.getNumeroGiorno() == giorno) {
                return t;
            }
        }
        return null;
    }

    // Modifica il titolo dell'itinerario
    public void modificaTitolo(String titolo) {
        this.titolo = titolo;
        System.out.println("Titolo aggiornato: " + titolo);
    }

    // Modifica la descrizione dell'itinerario
    public void modificaDescrizione(String descrizione) {
        this.descrizione = descrizione;
        System.out.println("Descrizione aggiornata.");
    }

    // Restituisce il numero di tappe
    public int numeroTappe() {
        return tappe.size();
    }


    // Restituisce il totale delle ore sommate da tutte le tappe
    public int oreTotali() {
        int totale = 0;
        for (Tappa t : tappe) {
            totale += t.getDurataOre();
        }
        return totale;
    }


    @Override
    public String toString() {
        return "Itinerario{" + "titolo='" + titolo + '\'' + ", giorni=" + durataTotaleGiorni + ", tappe=" + numeroTappe() +
                ", oreT totali=" + oreTotali() + '}';
    }

}