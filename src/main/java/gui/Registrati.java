package gui;

import controller.controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Year;
import Exception.CampoNonValidoException;


public class Registrati {
    private JTextField FieldNome;
    private JTextField FieldCognome;
    private JTextField FieldNascita;
    private JTextField FieldTelefono;
    private JTextField FieldEmail;
    private JTextField Fieldpassword;
    private JPanel Registrati;
    private JButton registratiButton;
    private JComboBox comboBoxGiorno;
    private JComboBox comboBoxAnno;
    private JComboBox comboBoxMese;
    private JButton tornaAdAccountButton;
    private controller Mycontroller;
    private JFrame Framechiamante;

    public Registrati(controller controller, JFrame framechiamante) {
        this.Mycontroller = controller;
        this.Framechiamante = framechiamante;
        JFrame registraFrame = new JFrame("Pagina di registrazione");
        registraFrame.setContentPane(Registrati);
        registraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registraFrame.pack();
        registraFrame.setVisible(true);

        //aggiungiamo i valori alle combobox
        for(int i = 1; i <= 31; i++){
            comboBoxGiorno.addItem(i);
        }

        for(int i = 1; i <=12; i++){
            comboBoxMese.addItem(i);
        }

        // variabile per aggiornare l'anno
        int annoCorrente = Year.now().getValue();
        for(int i = 1920; i <= annoCorrente; i++){
            comboBoxAnno.addItem(i);
        }

        registratiButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registratiButton.setBackground(Color.white);
                registratiButton.setForeground(Color.PINK);
            }
        });

        registratiButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                registratiButton.setBackground(Color.white);
                registratiButton.setForeground(Color.BLACK);
            }
        });

        registratiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                //recuperiamo i valori inseriti nei campi di testo
                String nome = FieldNome.getText();
                String cognome = FieldCognome.getText();
                String numeroTel = FieldTelefono.getText();
                String email = FieldEmail.getText();
                String pass = Fieldpassword.getText();

                try{
                    Mycontroller.RegistraUtente(nome, cognome, numeroTel, email, pass);
                    JOptionPane.showMessageDialog(null, "Registrazione avvenuta con succeso!");
                }catch(CampoNonValidoException execp){
                    JOptionPane.showMessageDialog(null, execp.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tornaAdAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(Mycontroller, registraFrame);
                registraFrame.dispose();
            }
        });

        tornaAdAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tornaAdAccountButton.setBackground(Color.white);
                tornaAdAccountButton.setForeground(Color.PINK);
            }
        });

        tornaAdAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                tornaAdAccountButton.setBackground(Color.white);
                tornaAdAccountButton.setForeground(Color.BLACK);
            }
        });
    }



}
