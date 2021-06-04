package com.company;

import javax.swing.*;

public class akun {
    private final String[][] data;
    private final JTextField email;
    private final JPasswordField password;
    private String type = "";

    //Ini constructor yang akan dijalankan setiap class diinisialisasikan
    public akun( JTextField logEField, JPasswordField logPField) {
        email = logEField;
        password = logPField;
        String[][] data =
                {
                        {"admin01@gmail.com", "12345", "admin"},

                };
        this.data = data;
    }

    //Untuk pengecekan akun yang terdaftar
    private boolean checkCredential() {
        for(int i = 0; i < data.length; i++ )
        {
            if(data[i][0].equalsIgnoreCase(email.getText()))
            {
                if(data[i][1].equals(password.getText()))
                {
                    type = data[i][2];
                    return true;
                }
            }
        }
        return false;
    }

    public void login() {
        boolean status = checkCredential();
        if(status) {
            penilaian menu = new penilaian();
            menu.penilaianLayout();
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Terdaftar!!", "Invalid Login",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
