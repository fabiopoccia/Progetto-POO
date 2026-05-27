package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class GuidaLocale {
    private String codiceGuida;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private int certificazioni;
    private int anniEsperienza;
    private List<Attivita> attivitaAssegnate;

    public GuidaLocale(String codiceGuida, String nome, String cognome, String email, String telefono, int certificazioni, int anniEsperienza) {
        this.codiceGuida = codiceGuida;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.certificazioni = certificazioni;
        this.anniEsperienza = anniEsperienza;
        this.attivitaAssegnate = new ArrayList<>(); // lista vuota all'inizio
    }

    public String getCodiceGuida() { return codiceGuida; }
    public void setCodiceGuida(String codiceGuida) { this.codiceGuida = codiceGuida; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getCertificazioni() { return certificazioni; }
    public void setCertificazioni(int certificazioni) { this.certificazioni = certificazioni; }

    public int getAnniEsperienza() { return anniEsperienza; }
    public void setAnniEsperienza(int anniEsperienza) { this.anniEsperienza = anniEsperienza; }

    public List<Attivita> getAttivitaAssegnate() { return attivitaAssegnate; }


    // Verifica se la guida è disponibile in una certa data
    // (non ha già un'attività programmata in quella data)
    public boolean verificaDisponibilita(Date data) {
        for (Attivita a : attivitaAssegnate) {
            if (a.getDataPrenotazione().equals(data)) {
                return false; // già occupata in quella data
            }
        }
        return true;
    }

    // Assegna un'attività alla guida (se non già presente)
    public void assegnaAttivita(Attivita a) {
        if (!attivitaAssegnate.contains(a)) {
            attivitaAssegnate.add(a);
            System.out.println("Attività '" + a.getTitolo() + "' assegnata a " + nome + " " + cognome);
        } else {
            System.out.println("Errore: attività già assegnata a questa guida.");
        }
    }

    // Rimuove un'attività dalla guida
    public void rimuoviAttivita(Attivita a) {
        if (attivitaAssegnate.remove(a)) {
            System.out.println("Attività '" + a.getTitolo() + "' rimossa da " + nome + " " + cognome);
        } else {
            System.out.println("Errore: attività non trovata per questa guida.");
        }
    }

    // Restituisce il numero di attività assegnate
    public int numeroAttivitaAssegnate() {
        return attivitaAssegnate.size();
    }

    // Verifica se la guida ha abbastanza anni di esperienza
    public boolean anniEsperienzaSufficienti(int minimo) {
        return this.anniEsperienza >= minimo;
    }

    // Mostra il curriculum della guida
    public String mostraCurriculum() {
        return "  CURRICULUM " + "\nNome: " + nome + " " + cognome + "\nEmail: " + email + "\nTelefono: " + telefono +
                "\nAnni di esperienza: " + anniEsperienza + "\nCertificazioni: " + certificazioni +
                "\nAttività assegnate: " + numeroAttivitaAssegnate();
    }

    // Restituisce una stringa con l'elenco delle attività assegnate
    public String elencoAttivita() {
        if (attivitaAssegnate.isEmpty()) {
            return nome + " " + cognome + " non ha attività assegnate.";
        }
        String elenco = "Attività di " + nome + " " + cognome + ":\n";
        for (Attivita a : attivitaAssegnate) {
            elenco += "  - " + a.getTitolo() + " (" + a.getDataPrenotazione() + ")\n";
        }
        return elenco;
    }


    @Override
    public String toString() {
        return "GuidaLocale{" + "codice='" + codiceGuida + '\'' + ", nome='" + nome + " " + cognome + '\'' +
                ", esperienza=" + anniEsperienza + ", certificazioni=" + certificazioni +
                ", attivitàAssegnate=" + numeroAttivitaAssegnate() + '}';
    }

}