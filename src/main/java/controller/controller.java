package controller;
import Exception.CampoNonValidoException;
import model.*;

import javax.swing.*;
import java.util.ArrayList;

public class controller {

    private ArrayList<Utente> elencoUtenti = new ArrayList<>();

    public controller(){
        elencoUtenti.add(new Utente("fabioPoccia@libero.it","1234"));
        elencoUtenti.add(new Utente("simoneMinopoli@libero.it","5678"));
        elencoUtenti.add(new Utente("davideRibera@libero.it","4321"));
    }

    // metodo per verificare che i campi non siano vuoti
    public void VerificaCampiVuotiUtente(String username, String password) throws CampoNonValidoException{

        if(username.isBlank()){
            throw new CampoNonValidoException("Il campo username è vuoto!");
        }else if(password.isBlank()){
            throw new CampoNonValidoException("Il campo password è vuoto!");
        }

    }

    // metodo per verificare che l'utente ha già un account e che le credenziali siano corrette
    public boolean login(String username, String password){
        for(Utente u : elencoUtenti){
            if(u.getEmail().equals(username) && (u.getPassword().equals(password))){
                return true;
            }
        }
        return false;
    }


    public void RegistraUtente(String nome, String cognome, String numeroTelefono, String email, String password)throws CampoNonValidoException{
        if(nome.isBlank()){
            throw new CampoNonValidoException("Il campo username è vuoto!");
        }else if(cognome.isBlank()){
            throw new CampoNonValidoException("Il campo cognome è vuoto!");
        }else if(numeroTelefono.isBlank()){
            throw new CampoNonValidoException("Il campo Numero di Telefono è vuoto!");
        }else if(email.isBlank()){
            throw new CampoNonValidoException("Il campo email è vuoto!");
        }else if(password.isBlank()){
            throw new CampoNonValidoException("Il campo password è vuoto!");
        }

        Utente u = new Utente(nome, cognome, numeroTelefono, email,password);

        elencoUtenti.add(u);
        System.out.print("Utenti registrati: " + elencoUtenti.size());
    }


    public ArrayList<Utente> getElencoUtenti(){ return this.elencoUtenti;}
}
