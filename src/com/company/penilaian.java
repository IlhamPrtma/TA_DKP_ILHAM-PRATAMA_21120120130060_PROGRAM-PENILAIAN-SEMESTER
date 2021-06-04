package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

public class penilaian {
    private JPanel penilaianPanel;
    private JTextField namaField;
    private JTextField nimField;
    private JTextField tugasField;
    private JTextField utsField;
    private JTextField uasField;
    private JButton countButton;
    private JButton clearButton;
    private JButton saveButton;
    private JLabel lblnama;
    private JLabel lblnim;
    private JLabel lblrerata;
    private JLabel lblgrade;
    private JLabel lblket;
    private JButton exitButton;

    public penilaian() {

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (namaField.getText().isEmpty() || nimField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data Nama NIM Kosong!!");
                }else if (!namaField.getText().isEmpty() && !nimField.getText().isEmpty()){
                    //nama
                    String nama = namaField.getText();
                    boolean angka = true;
                    try {
                        Integer.parseInt(nama);
                    } catch (NumberFormatException ex) {
                        angka = false;
                    }
                    if (angka){
                        JOptionPane.showMessageDialog(null, "<error>\nData Nama Bukan Huruf!!");
                    }else{
                        lblnama.setText(nama);
                    }

                    //nim
                    String nim = nimField.getText();
                    boolean huruf = false;
                    try {
                        Long.parseLong(nim);
                    } catch (NumberFormatException ex) {
                        huruf = true;
                    }
                    if (huruf) {
                        JOptionPane.showMessageDialog(null, "<error>\nData Nim Bukan Angka!!", "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        lblnim.setText(nim);
                    }

                }

                //rerata
                if (tugasField.getText().isEmpty() || utsField.getText().isEmpty() || uasField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Data Nilai Kosong!!");
                }else if (Integer.parseInt(tugasField.getText()) > 100 || Integer.parseInt(utsField.getText()) > 100 ||
                        Integer.parseInt(uasField.getText()) > 100) {
                    JOptionPane.showMessageDialog(null, "Data Nilai Lebih Dari 100!!");
                } else {
                    double rerata = ((Double.parseDouble(tugasField.getText()) * 0.5) +
                                    (Double.parseDouble(utsField.getText()) * 0.25) +
                                    (Double.parseDouble(uasField.getText()) * 0.25));
                    lblrerata.setText(Double.toString(rerata));
                }

                if (!lblrerata.getText().isEmpty()){
                    //grade
                    double n = Double.parseDouble(lblrerata.getText());
                    char grade = ' ';
                    if(n >= 90.00 && n <=100.00 ){
                        grade = 'A';
                        lblgrade.setText(""+grade);
                    }
                    else if (n >= 80.00 && n <=89.99 ){
                        grade = 'B';
                        lblgrade.setText(""+grade);
                    }
                    else if (n >= 70.00 && n <= 79.99){
                        grade = 'C';
                        lblgrade.setText(""+grade);
                    }
                    else if (n >= 40.00 && n <= 69.99){
                        grade = 'D';
                        lblgrade.setText(""+grade);
                    }
                    else if (n <= 39.99){
                        grade = 'E';
                        lblgrade.setText(""+grade);
                    }

                    //keterangan
                    if (grade == 'A' || grade == 'B' || grade == 'C'){

                        lblket.setText("Lulus");
                    }
                    else {
                        lblket.setText("Tidak Lulus");
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaField.setText("");
                nimField.setText("");
                tugasField.setText("");
                utsField.setText("");
                uasField.setText("");
                lblnama.setText("");
                lblnim.setText("");
                lblrerata.setText("");
                lblgrade.setText("");
                lblket.setText("");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (lblnama.getText().equals("") || lblnim.getText().equals("") ||
                        lblrerata.getText().equals("") || lblgrade.getText().equals("") || lblket.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Belum Di-input-kan");
                } else {
                    String nama, nim, rerata, grade, ket;
                    nama = lblnama.getText();
                    nim = lblnim.getText();
                    rerata = lblrerata.getText();
                    grade = lblgrade.getText();
                    ket = lblket.getText();
                    try {
                        PrintWriter simpan = new PrintWriter(new FileWriter("nilai.txt",true));
                        String tulis = "Nama       : \t" + nama + "\n" +
                                       "Nim        : \t" + nim + "\n" +
                                       "Rata-rata  : \t" + rerata + "\n" +
                                       "Grade      : \t" + grade + "\n" +
                                       "Keterangan : \t" + ket + "\n";
                        simpan.append(tulis).println();
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Succer",
                                JOptionPane.INFORMATION_MESSAGE);
                        simpan.close();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception);
                    }
                    namaField.setText("");
                    nimField.setText("");
                    tugasField.setText("");
                    utsField.setText("");
                    uasField.setText("");
                    lblnama.setText("");
                    lblnim.setText("");
                    lblrerata.setText("");
                    lblgrade.setText("");
                    lblket.setText("");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
    }

    public void penilaianLayout() {
        JFrame frame = new JFrame("Menu Penilaian");
        frame.setContentPane(new penilaian().penilaianPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
