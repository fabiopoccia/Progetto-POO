package model;

public class Tappa {
    private int numeroGiorno;
    private int durataOre;
    private Destinazione destinazione; // cambiato da String a Destinazione

    public Tappa(int numeroGiorno, int durataOre, Destinazione destinazione) {
        this.numeroGiorno = numeroGiorno;
        this.durataOre = durataOre;
        this.destinazione = destinazione;
    }


    public int getNumeroGiorno() { return numeroGiorno; }
    public void setNumeroGiorno(int numeroGiorno) { this.numeroGiorno = numeroGiorno; }

    // nessun setter per durataOre: usiamo modificaDurata, incrementaDurata, riduciDurata
    public int getDurataOre() { return durataOre; }

    // nessun setter per destinazione: usiamo modificaDestinazione
    public Destinazione getDestinazione() { return destinazione; }
    public void setDestinazione(Destinazione d){ this.destinazione = d;}


    public String getInfoTappa() {
        return "Giorno " + numeroGiorno + " | Destinazione: " + destinazione.getNome() + " | Durata: " + durataOre + "h";
    }



    public void modificaDurata(int ore) {
        if (ore > 0) {
            this.durataOre = ore;
        } else {
            System.out.println("Errore: la durata deve essere maggiore di 0.");
        }
    }


    public void incrementaDurata(int ore) {
        if (ore > 0) {
            this.durataOre += ore;
        } else {
            System.out.println("Errore: le ore da aggiungere devono essere maggiori di 0.");
        }
    }

    public void riduciDurata(int ore) {
        if (ore > 0 && this.durataOre - ore > 0) {
            this.durataOre -= ore;
        } else {
            System.out.println("Errore: la durata non può diventare 0 o negativa.");
        }
    }


}