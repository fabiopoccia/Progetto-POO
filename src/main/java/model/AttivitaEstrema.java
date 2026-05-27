package model;

import java.util.Date;

public class AttivitaEstrema extends Attivita {

    private boolean necessitaAttrezzatura;
    private String livelloRischio;
    private String equipaggiamento;
    private boolean difficoltaMotorie;

    public AttivitaEstrema(String codiceAttività, Date dataPrenotazione, String titolo, int durata, int difficoltà, double prezzo, int postiDisponibili, boolean necessitaAttrezzatura, String livelloRischio, String equipaggiamento, boolean difficoltaMotorie) {
        super(codiceAttività, dataPrenotazione, titolo, durata, difficoltà, prezzo, postiDisponibili);
        this.necessitaAttrezzatura = necessitaAttrezzatura;
        this.livelloRischio = livelloRischio;
        this.equipaggiamento = equipaggiamento;
        this.difficoltaMotorie = difficoltaMotorie;
    }

    // verifica se l'utente è maggiorenne e se ha difficoltà motorie
    public boolean verificaIdoneita(Utente u) {
        if (u != null) {
            if (u.getEta() > 18 && !difficoltaMotorie) {
                return true;
            }
        }
        return false;
    }


    public boolean richiedeAttrezzatura() {
        return necessitaAttrezzatura;
    }

    // vede il livello di rischio
    public void visualizzaRischio() {
        System.out.println("Attenzione: Livello di Rischio stimato in categoria [" + livelloRischio.toUpperCase() + "]");
    }

    // mostra attrezzatura
    public void mostraEquipaggiamento() {
        if (necessitaAttrezzatura) {
            System.out.println("Equipaggiamento obbligatorio per partecipare: " + equipaggiamento);
        } else {
            System.out.println("Non è richiesto alcun equipaggiamento specifico.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - AttivitaEstrema{" + "rischio='" + livelloRischio + '\'' +
                ", attrezzaturaObbligatoria=" + necessitaAttrezzatura + '}';
    }
}