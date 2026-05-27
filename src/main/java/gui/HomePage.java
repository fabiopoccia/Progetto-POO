package gui;

import controller.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class HomePage {
    private JPanel MainPanel;
    private JButton registratiButton;
    private JButton loginButton;
    private JPanel Panel2;
    private JTabbedPane tabbedPane1;
    private JLabel FirenzeLabel1;
    private JLabel Firenzelabel;
    private JFrame mainFrame;
    private controller controller;



    public HomePage(){
        this.controller = new controller();

        // inserimento immagini
        URL imageUrl = getClass().getResource("/Firenze.jpeg");
        ImageIcon icon = new ImageIcon(imageUrl);
        Firenzelabel.setIcon(icon);

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.white);
                loginButton.setForeground(Color.orange);
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.white);
                loginButton.setForeground(Color.BLACK);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginframe = new Login(controller, mainFrame);
                mainFrame.dispose();
            }
        });

        registratiButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registratiButton.setBackground(Color.white);
                registratiButton.setForeground(Color.orange);
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
            public void actionPerformed(ActionEvent e) {
                Registrati registratiFrame = new Registrati(controller, mainFrame);
                mainFrame.dispose();
            }
        });
    }

    public static void main(String[] args){
        HomePage homePage = new HomePage();
        JFrame frame = new JFrame("Home page");
        frame.setContentPane(homePage.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        homePage.mainFrame = frame;
    }
}
