package model;

import java.util.ArrayList;
import java.util.Date;


public class Utente {
    private String nome;
    private String cognome;
    private String codiceUtente;
    private String email;
    private String numeroTelefono;
    private String password;
    private int eta;
    private boolean problemiFisici;
    private ArrayList<Prenotazione> prenotazioni;
    private ArrayList<Recensione> recensioni;
    private ArrayList<Itinerario> itinerari;

    public Utente(String nome, String cognome, String codiceUtente, String numeroTelefono, String email, String password, int eta, boolean problemiFisici) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceUtente = codiceUtente;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.password = password;
        this.eta = eta;
        this.problemiFisici = problemiFisici;
        this.prenotazioni = new ArrayList<>();
        this.recensioni = new ArrayList<>();
        this.itinerari = new ArrayList<>();
    }

    public Utente(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Utente(String nome, String cognome, String numeroTelefono, String email, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.password = password;
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getCodiceUtente() { return codiceUtente; }
    public void setCodiceUtente(String codiceUtente) { this.codiceUtente = codiceUtente; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }

    public boolean getDifficoltaMotorie() { return problemiFisici; }
    public void setDifficoltaMotorie(boolean problemiFisici) { this.problemiFisici = problemiFisici; }

    public ArrayList<Prenotazione> getPrenotazioni() { return prenotazioni; }
    public ArrayList<Recensione> getRecensioni() { return recensioni; }
    public ArrayList<Itinerario> getItinerari() { return itinerari; }


    // Modifica i dati del profilo dell'utente
    public void modificaProfilo(String nuovoNome, String nuovoCognome, String nuovaEmail, int nuovaEta) {
        this.nome = nuovoNome;
        this.cognome = nuovoCognome;
        this.email = nuovaEmail;
        this.eta = nuovaEta;
        System.out.println("Profilo aggiornato con successo.");
    }

    // Aggiunge una nuova prenotazione alla lista
    public void effettuaPrenotazione(Prenotazione p) {
        prenotazioni.add(p);
        System.out.println("Prenotazione " + p.getCodicePrenotazione() + " effettuata con successo.");
    }

    // Aggiunge una nuova recensione alla lista
    public void scriviRecensione(Recensione r) {
        recensioni.add(r);
        System.out.println("Recensione aggiunta con successo.");
    }

    // Aggiunge un nuovo itinerario alla lista
    public void creaItinerario(Itinerario i) {
        itinerari.add(i);
        System.out.println("Itinerario '" + i.getTitolo() + "' creato con successo.");
    }


    // Annulla una prenotazione impostando lo stato ad "annullata"
    public void annullaPrenotazione(Prenotazione p) {
        if (prenotazioni.contains(p)) {
            p.setStato("annullata");
            System.out.println("Prenotazione " + p.getCodicePrenotazione() + " annullata.");
        } else {
            System.out.println("Errore: prenotazione non trovata.");
        }
    }

    // Modifica una prenotazione esistente con nuovi dati
    public void modificaPrenotazione(Prenotazione p, Date nuovaData, int nuoviPosti) {
        if (prenotazioni.contains(p)) {
            p.setDataAttività(nuovaData);
            p.setNumeroPosti(nuoviPosti);
            System.out.println("Prenotazione " + p.getCodicePrenotazione() + " modificata.");
        } else {
            System.out.println("Errore: prenotazione non trovata.");
        }
    }

    // Stampa tutte le prenotazioni dell'utente
    public String visualizzaPrenotazioni() {
        if (prenotazioni.isEmpty()) {
            return nome + " non ha prenotazioni.";
        }
        String elenco = "Prenotazioni di " + nome + " " + cognome + ":\n";
        for (Prenotazione p : prenotazioni) {
            elenco += "  - " + p.getCodicePrenotazione() + " | stato: " + p.getStato() + "\n";
        }
        return elenco;
    }

    // Stampa tutte le recensioni dell'utente
    public String visualizzaRecensioni() {
        if (recensioni.isEmpty()) {
            return nome + " non ha ancora scritto recensioni.";
        }
        String elenco = "Recensioni di " + nome + " " + cognome + ":\n";
        for (Recensione r : recensioni) {
            elenco += "  - Voto: " + r.getVoto() + " | " + r.getTesto() + "\n";
        }
        return elenco;
    }

    // Stampa tutti gli itinerari dell'utente
    public String visualizzaItinerari() {
        if (itinerari.isEmpty()) {
            return nome + " non ha itinerari salvati.";
        }
        String elenco = "Itinerari di " + nome + " " + cognome + ":\n";
        for (Itinerario i : itinerari) {
            elenco += "  - " + i.getTitolo() + " (" + i.getDurataTotaleGiorni() + " giorni)\n";
        }
        return elenco;
    }

    // Cambia la password dopo aver verificato quella vecchia
    public void cambiaPassword(String vecchiaPassword, String nuovaPassword) {
        if (this.password.equals(vecchiaPassword)) {
            this.password = nuovaPassword;
            System.out.println("Password cambiata con successo.");
        } else {
            System.out.println("Errore: la vecchia password non è corretta.");
        }
    }

    // Verifica se la password inserita è corretta
    public boolean controllaPassword(String pwd) {
        return this.password.equals(pwd);
    }



    // Restituisce il numero totale di prenotazioni
    public int numeroPrenotazioni() {
        return prenotazioni.size();
    }

    // Calcola la spesa totale sommando i prezzi di tutte le prenotazioni
    public double spesaTotale() {
        double totale = 0;
        for (Prenotazione p : prenotazioni) {
            totale += p.getPrezzoTotale();
        }
        return totale;
    }


    @Override
    public String toString() {
        return "Utente{" + "codice='" + codiceUtente + '\'' + ", nome='" + nome + " " + cognome + '\'' +
                ", email='" + email + '\'' + ", eta=" + eta + ", prenotazioni=" + numeroPrenotazioni() + '}';
    }

}