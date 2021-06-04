package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private JTextField logEField;
    private JPasswordField logPField;
    private JButton loginButton;
    private JButton clearButton;
    private JPanel loginPanel;
    private JButton exitButton;


    public login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logEField.getText().isEmpty() || logPField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "<error>\nData Tidak Lengkap!!", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    logEField.requestFocus();
                } else {
                    akun akun = new akun(logEField,logPField);
                    akun.login();

                    logEField.setText("");
                    logPField.setText("");
                    logEField.requestFocus();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logEField.setText("");
                logPField.setText("");
                logEField.requestFocus();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Menu");
        frame.setContentPane(new login().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
