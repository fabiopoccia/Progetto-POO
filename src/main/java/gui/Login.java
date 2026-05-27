package gui;

import javax.swing.*;
import controller.controller;
import model.Utente;
import Exception.CampoNonValidoException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Login {
    private JPanel LoginPanel;
    private JTextField FieldUsername;
    private JTextField FieldPassword;
    private JButton accediButton;
    private JButton creaNuovoButton;
    private controller Mycontroller;
    private JFrame frameChiamante;
    ArrayList<Utente> elencoUtenti;

    public Login(controller controller,  JFrame frameChiamante) {

        this.Mycontroller = controller;
        this.frameChiamante = frameChiamante;

        JFrame frameLogin = new JFrame("Finestra di login");
        frameLogin.setContentPane(LoginPanel);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.pack();
        frameLogin.setVisible(true);
        elencoUtenti = new ArrayList<>();



        accediButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                accediButton.setBackground(Color.white);
                accediButton.setForeground(Color.orange);
            }
        });

        accediButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                accediButton.setBackground(Color.white);
                accediButton.setForeground(Color.BLACK);
            }
        });

        accediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                //RECUPERIAMO I VALORI INSERITI NEI CAMPI DI TESTO
                String User = FieldUsername.getText();
                String pass = FieldPassword.getText();


                try {
                    //Passo le informazioni al controller
                    Mycontroller.VerificaCampiVuotiUtente(User, pass);

                    boolean successo = Mycontroller.login(User, pass);

                    if (successo) {
                        JOptionPane.showMessageDialog(null, "Login avvenuto con successo!");


                    } else {
                        JOptionPane.showMessageDialog(null, "Credenziali errate!", "Errore", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (CampoNonValidoException execp) {
                    JOptionPane.showMessageDialog(null, execp.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        creaNuovoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registrati(Mycontroller, frameLogin);
                frameLogin.dispose();
            }
        });

        creaNuovoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                creaNuovoButton.setBackground(Color.white);
                creaNuovoButton.setForeground(Color.orange);
            }
        });

        creaNuovoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                creaNuovoButton.setBackground(Color.white);
                creaNuovoButton.setForeground(Color.BLACK);
            }
        });

    }
}
