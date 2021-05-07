/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Masa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author benja
 */
public class Masa extends JFrame implements ActionListener {

    JPanel panel, cuerpo;
    JTextField presion, volumen, temperatura;
    JButton calcular;
    JLabel resultado;
    double result;

    public Masa() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(250, 150);
        setLocationRelativeTo(null);  //centro en pantalla
        setVisible(true);
        setTitle("Calcular masa");
        getContentPane().setLayout(new BorderLayout());
        setResizable(true);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        cuerpo = new JPanel();
        cuerpo.setLayout(new GridLayout(3, 2));
        cuerpo.add(new JLabel("Presion: "));
        presion = new JTextField();
        cuerpo.add(presion);
        cuerpo.add(new JLabel("Volumen: "));
        volumen = new JTextField();
        cuerpo.add(volumen);
        cuerpo.add(new JLabel("Temperatura: "));
        temperatura = new JTextField();
        cuerpo.add(temperatura);
        calcular = new JButton("Calcular");
        calcular.addActionListener(this);
        resultado = new JLabel("Masa = ");
        panel.add("Center", cuerpo);
        panel.add("South", calcular);
        resultado.setBorder(new EmptyBorder(0, 5, 0, 5));
        getContentPane().add(panel);
        getContentPane().add("South", resultado);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);

        result = 0;
    }

    public void actionPerformed(ActionEvent mn) {
        if (mn.getSource() == calcular) {
            if ((!presion.getText().equals(""))
                    && (!volumen.getText().equals(""))
                    && (!temperatura.getText().equals(""))) {
                try {
                    result = Double.parseDouble(presion.getText()) * Double.parseDouble(volumen.getText());
                    result = result / ((0.37) * (Double.parseDouble(temperatura.getText()) + 460));
                    resultado.setText("Masa= " + result);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Los valores deben ser numericos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Dejo campos vacios");
            }

        }
    }

    public static void main(String[] args) {
        Masa m = new Masa();
    }
}
