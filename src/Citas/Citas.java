/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Citas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author benja
 */
public class Citas extends JFrame implements ActionListener {

    Icon fotoUsuario;
    JLabel foto;
    JPanel panel, cabecera, cabecera2, footer, genero, edocivil, eventos;
    JTextField nombre, edad, telefono;
    JRadioButton hombre, mujer;
    JRadioButton soltero, viudo, divorciado;
    ButtonGroup sexo, estadocivil;
    JButton alta, buscar;
    JTextArea consulta;
    JScrollPane scrollBar1, scrollBar2;
    ArrayList<Persona> usuarios;
    JTextArea users;
    Image redimensionada;
    String rutaFoto;

    public Citas() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(200, 100, 360, 520); //ancho,alto
        setSize(360, 520);
        setLocationRelativeTo(null);  //centro en pantalla
        setVisible(true);
        setTitle("Citas");
        setLayout(null);
        setResizable(false);
        // getContentPane().setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        cabecera = new JPanel();
        cabecera.setLayout(new GridLayout(6, 1));
        cabecera2 = new JPanel();
        cabecera2.setLayout(new GridLayout(6, 1));

        cabecera.add(new JLabel("Nombre: "));
        nombre = new JTextField("");
        cabecera2.add(nombre);
        cabecera.add(new JLabel("Sexo: "));
        hombre = new JRadioButton("Hombre", false);
        mujer = new JRadioButton("Mujer", true);
        sexo = new ButtonGroup();
        sexo.add(hombre);
        sexo.add(mujer);
        genero = new JPanel();
        genero.setLayout(new GridLayout());
        genero.add(hombre);
        genero.add(mujer);

        cabecera2.add(genero);
        cabecera.add(new JLabel("Edad "));
        edad = new JTextField("");
        cabecera2.add(edad);
        cabecera.add(new JLabel("Estado civil"));

        estadocivil = new ButtonGroup();
        soltero = new JRadioButton("Soltero", true);
        viudo = new JRadioButton("Viudo", false);
        divorciado = new JRadioButton("Divorciado", false);
        estadocivil.add(soltero);
        estadocivil.add(viudo);
        estadocivil.add(divorciado);

        edocivil = new JPanel();
        edocivil.setLayout(new GridLayout());
        edocivil.add(soltero);
        edocivil.add(viudo);
        edocivil.add(divorciado);

        cabecera2.add(edocivil);
        cabecera.add(new JLabel("Telefono"));
        telefono = new JTextField("");
        cabecera2.add(telefono);
        cabecera.add(new JLabel("Foto"));

        foto = new JLabel();
        foto.setSize(130, 130);
        //fotoUsuario =new ImageIcon("img/usuario.png" );
        //rutaFoto="img/usuario.png";
        rutaFoto = System.getProperty("user.dir") + "/img/" + "usuario.png";

        redimensionada = new ImageIcon(rutaFoto).getImage();
        redimensionada = redimensionada.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        fotoUsuario = new ImageIcon(redimensionada);
        //  fotoUsuario =  new ImageIcon(fotoUsuario.getImage().getScaledInstance(foto.getWidth(),foto.getHeight(),Image.SCALE_DEFAULT));

        //fotoUsuario = new ImageIcon(getClass().getResource("usuario.png"));
        foto.setIcon(fotoUsuario);
        buscar = new JButton("Buscar foto");
        buscar.addActionListener(this);

        cabecera2.add(buscar);

        footer = new JPanel();
        footer.setLayout(new BorderLayout());

        alta = new JButton("Agregar usuario");

        alta.addActionListener(this);

        footer.add("East", foto);
        //footer.add("Center",alta);
        //footer.add("South",alta);

        eventos = new JPanel();
        eventos.setLayout(new BorderLayout());
        eventos.add("North", alta);

        users = new JTextArea();
        users.setEditable(false);

        consulta = new JTextArea();
        consulta.setEditable(false);

        // eventos.add("Center", scrollBar1);
        footer.add("South", alta);

        panel.add("South", footer);
        panel.add("West", cabecera);
        panel.add("East", cabecera2);

        usuarios = new ArrayList<Persona>();

        panel.setBounds(0, 0, 350, 300);

        getContentPane().add(panel);
        scrollBar1 = new JScrollPane(users,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //NEVER

        scrollBar1.setBounds(0, 305, 350, 100);

        scrollBar2 = new JScrollPane(consulta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //NEVER

        consulta.setBounds(0, 410, 350, 70);

        getContentPane().add(scrollBar1);
        getContentPane().add(consulta);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);

    }

    public void actionPerformed(ActionEvent mn) {
        if (mn.getSource() == buscar) {

            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
            fileChooser.setFileFilter(imgFilter);

            int result = fileChooser.showOpenDialog(this);
            //int result = fileChooser.showSaveDialog(this);

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    //txt.setText("...");
                    fotoUsuario = new ImageIcon(redimensionada); // la foto que tengo default
                    foto.setIcon(fotoUsuario);
                } else {
                    try {
                        //txt.setText(fileName.getAbsolutePath());

                        String Dest = System.getProperty("user.dir") + "/img/" + fileName.getName();
                        Path Destino = Paths.get(Dest);
                        String Orig = fileName.getPath();
                        Path Origen = Paths.get(Orig);
                        Files.copy(Origen, Destino, REPLACE_EXISTING);
                        rutaFoto = Dest;

                        /////////////
                        Image redimensionada = new ImageIcon(Dest).getImage();
                        redimensionada = redimensionada.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                        fotoUsuario = new ImageIcon(redimensionada);
                        //////////////
                        foto.setIcon(fotoUsuario);
                    } catch (IOException ex) {

                    }

                }
            }
        }

        if (mn.getSource() == alta) {

            String nombreUsuario = nombre.getText();

            String sexoUsuario = "";
            if (hombre.isSelected()) {
                sexoUsuario = "Hombre";
            }
            if (mujer.isSelected()) {
                sexoUsuario = "Mujer";
            }

            int edadUsuario = 0;
            try {
                edadUsuario = Integer.parseInt(edad.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Edad debe ser formato numerico");
                edad.setText("");
                edadUsuario = 0;
            }

            String edoCivilUsuario = "";
            if (soltero.isSelected()) {
                edoCivilUsuario = "Soltero";
            }
            if (viudo.isSelected()) {
                edoCivilUsuario = "Viudo";
            }
            if (divorciado.isSelected()) {
                edoCivilUsuario = "Divorciado";
            }
            String telefonoUsuario = "";

            telefonoUsuario = telefono.getText();

            String fotoUsuario = rutaFoto;

            if (!(nombre.getText().equals("")) && (edadUsuario != 0) && (!telefonoUsuario.equals(""))) {

                usuarios.add(new Persona(nombreUsuario, sexoUsuario, edadUsuario, edoCivilUsuario, telefonoUsuario, fotoUsuario));
                Iterator<Persona> basedatos = usuarios.iterator();
                int total = 1;
                int contador1, contador2, contador3, contador4;
                contador1 = contador2 = contador3 = contador4 = 0;
                users.setText("");
                while (basedatos.hasNext()) {
                    Persona elemento = basedatos.next();
                    users.append(total + "\t");
                    users.append(elemento.getNombre() + "\t");

                    users.append(elemento.getSexo() + "\t");
                    users.append(elemento.getEdad() + "\t");
                    users.append(elemento.getEdoCivil() + "\t");
                    users.append(elemento.getTelefono() + "\t");
                    users.append(elemento.getFoto() + "\t");
                    users.append("\n");

                    if ((elemento.getSexo() == "Mujer")
                            && (elemento.getEdoCivil() == "Soltero")
                            && (elemento.getEdad() >= 27 && elemento.getEdad() <= 37)) {
                        contador1++;
                    }

                    if ((elemento.getSexo() == "Mujer")
                            && (elemento.getEdoCivil() == "Divorciado")
                            && (elemento.getEdad() >= 35 && elemento.getEdad() <= 45)) {
                        contador2++;
                    }

                    if ((elemento.getSexo() == "Hombre")
                            && (elemento.getEdoCivil() == "Viudo")
                            && (elemento.getEdad() >= 45 && elemento.getEdad() <= 55)) {
                        contador3++;
                    }

                    if ((elemento.getSexo() == "Hombre")
                            && (elemento.getEdoCivil() == "Soltero")
                            && (elemento.getEdad() >= 30 && elemento.getEdad() <= 40)) {
                        contador4++;
                    }

                    total++;
                }
                consulta.setText("");
                consulta.setText("Numero de mujeres solteras entre 27 y 37 años: " + contador1 + "\n"
                        + "Numero de mujeres divorciadas entre 35 y 45 sños: " + contador2 + "\n"
                        + "Numero de hombres viudos entre 45 y 55 años: " + contador3 + "\n"
                        + "Numero de hombres solteros entre 30 y 40 años: " + contador4 + "\n"
                );
            } else {
                JOptionPane.showMessageDialog(null, "Dejo campos vacios");
            }

        }
    }

    public static void main(String[] args) {
        Citas c = new Citas();
    }
}
