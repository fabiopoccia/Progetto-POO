package model;

import java.util.ArrayList;

public class Destinazione {
    private String nome;
    private String paese;
    private String descrizione;
    private ArrayList<Attivita> attivitaDisponibili;

    public Destinazione(String nome, String paese, String descrizione) {
        this.nome = nome;
        this.paese = paese;
        this.descrizione = descrizione;
        this.attivitaDisponibili = new ArrayList<>();
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPaese() { return paese; }
    public void setPaese(String paese) { this.paese = paese; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public ArrayList<Attivita> getAttivitaDisponibili() { return attivitaDisponibili; }



    public void aggiungiAttivita(Attivita a) {
        attivitaDisponibili.add(a);
    }


    public void rimuoviAttivita(String codice) {
        Attivita daRimuovere = null;
        for (Attivita a : attivitaDisponibili) {
            if (a.getCodiceAttività().equals(codice)) {
                daRimuovere = a;
            }
        }
        if (daRimuovere != null) {
            attivitaDisponibili.remove(daRimuovere);
        } else {
            System.out.println("Attività non trovata.");
        }
    }

    public Attivita cercaAttivita(String codice) {
        for (Attivita a : attivitaDisponibili) {
            if (a.getCodiceAttività().equals(codice)) {
                return a;
            }
        }
        return null;
    }

    public String elencoAttivita() {
        if (attivitaDisponibili.isEmpty()) return "Nessuna attività disponibile.";
        String elenco = "Attività a " + nome + ":\n";
        for (Attivita a : attivitaDisponibili) {
            elenco += "  - " + a.getTitolo() + " | " + a.getPrezzo() + "€\n";
        }
        return elenco;
    }

    public Attivita piuCostosa() {
        if (attivitaDisponibili.isEmpty()) return null;
        Attivita piuCostosa = attivitaDisponibili.get(0);
        for (Attivita a : attivitaDisponibili) {
            if (a.getPrezzo() > piuCostosa.getPrezzo()) {
                piuCostosa = a;
            }
        }
        return piuCostosa;
    }

    public Attivita menoCostosa() {
        if (attivitaDisponibili.isEmpty()) return null;
        Attivita menoCostosa = attivitaDisponibili.get(0);
        for (Attivita a : attivitaDisponibili) {
            if (a.getPrezzo() < menoCostosa.getPrezzo()) {
                menoCostosa = a;
            }
        }
        return menoCostosa;
    }

    public Attivita piuDifficile() {
        if (attivitaDisponibili.isEmpty()) return null;
        Attivita piuDifficile = attivitaDisponibili.get(0);
        for (Attivita a : attivitaDisponibili) {
            if (a.getDifficoltà() > piuDifficile.getDifficoltà()) {
                piuDifficile = a;
            }
        }
        return piuDifficile;
    }

    // ordina per prezzo crescente con bubble sort
    public ArrayList<Attivita> ordinaPerPrezzo() {
        ArrayList<Attivita> ordinata = new ArrayList<>(attivitaDisponibili);
        for (int i = 0; i < ordinata.size() - 1; i++) {
            for (int j = 0; j < ordinata.size() - 1 - i; j++) {
                if (ordinata.get(j).getPrezzo() > ordinata.get(j + 1).getPrezzo()) {
                    Attivita temp = ordinata.get(j);
                    ordinata.set(j, ordinata.get(j + 1));
                    ordinata.set(j + 1, temp);
                }
            }
        }
        return ordinata;
    }

    // ordina per durata crescente con bubble sort
    public ArrayList<Attivita> ordinaPerDurata() {
        ArrayList<Attivita> ordinata = new ArrayList<>(attivitaDisponibili);
        for (int i = 0; i < ordinata.size() - 1; i++) {
            for (int j = 0; j < ordinata.size() - 1 - i; j++) {
                if (ordinata.get(j).getDurata() > ordinata.get(j + 1).getDurata()) {
                    Attivita temp = ordinata.get(j);
                    ordinata.set(j, ordinata.get(j + 1));
                    ordinata.set(j + 1, temp);
                }
            }
        }
        return ordinata;
    }


    @Override
    public String toString() {
        return "Destinazione{" + "nome='" + nome + '\'' + ", paese='" + paese + '\'' +
                ", attività=" + attivitaDisponibili.size() + '}';
    }


}