package model;

import java.util.Date;

public class AttivitaCulturale extends Attivita {

    private String linguaGuida;
    private String tematica;
    private int etaMinima;

    public AttivitaCulturale(String codiceAttività, Date dataPrenotazione, String titolo, int durata, int difficoltà, double prezzo, int postiDisponibili, String linguaGuida, String tematica, int etaMinima) {
        super(codiceAttività, dataPrenotazione, titolo, durata, difficoltà, prezzo, postiDisponibili);
        this.linguaGuida = linguaGuida;
        this.tematica = tematica;
        this.etaMinima = etaMinima;
    }

    // restituisce la lingua della guida
    public String getLinguaGuida() {
        return linguaGuida;
    }

    // restituisce la tematica dell'attività
    public String getTematica() {
        return tematica;
    }

    // verifica se l'utente soddisfa l'età minima richiesta
    public boolean verificaIdoneitaUtente(Utente utente) {
        return utente.getEta() >= etaMinima;
    }

    // verifica se l'attività supporta una determinata lingua
    public boolean supportaLingua(String lingua) {
        return linguaGuida.equalsIgnoreCase(lingua);
    }

}