/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tramites;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *
 * @author benja
 */
public class Colegiatura extends JFrame implements ActionListener{
    
     JPanel panel, cabecera, localforaneo;
     JPanel inscripcionLic;
     JPanel reinscripcionLic;
     JPanel numeroMaterias;
     JComboBox tipoTramite;
     JRadioButton foraneo,local;
     ButtonGroup estatusAlumno;
     JLabel cuotaApoyo, cuotaServicios,totalMat,curso,costocurso,total;
     JTextField numeroMat;
     double costomaterias,totalcolegiatura;
     JButton calcular;
    public Colegiatura() {
        
    
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setBounds(300, 200, 500, 170); //ancho,alto
        setVisible(true);
        setTitle("Colegiaturas");
        //setLayout(null);
        getContentPane().setLayout(new BorderLayout());
        
        calcular = new JButton("Calcular colegiatura");
           calcular.addActionListener(this);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        cabecera = new JPanel();   
        cabecera.setLayout(new GridLayout()); //una columna por componente en una sola fila
    
        tipoTramite= new JComboBox();
      
        tipoTramite.addItem("Inscripcion licenciatura");
        tipoTramite.addItem("Reinscripcion de licenciatura");
        tipoTramite.addItem("Inscripcion de maestria");
        tipoTramite.addItem("Reinscripcion de maestria");
        
     
        
        cabecera.add(tipoTramite);
        
        foraneo = new JRadioButton("Foraneo",false);
        local= new JRadioButton("Local",true);
        
        estatusAlumno = new ButtonGroup();
        estatusAlumno.add(local);
        estatusAlumno.add(foraneo);
        
    
    
        panel.add("North", cabecera);
        
        cuotaApoyo = new JLabel ("Cuota de apoyo a servicios educativos");
        cuotaServicios = new JLabel("");
        
       inscripcionLic = new JPanel();   
       inscripcionLic.setLayout(new GridLayout(5,2,5,1));
        inscripcionLic.add(local);
       inscripcionLic.add(foraneo);
      
        
       inscripcionLic.add(cuotaApoyo);
       inscripcionLic.add(cuotaServicios);
       //inscripcionLic.setVisible(true);
     
       numeroMaterias = new JPanel ();
       numeroMaterias.setLayout(new GridLayout());
       numeroMaterias.add(new JLabel("Numero de materias"));
       numeroMat = new JTextField("");
       numeroMaterias.add(numeroMat);
       totalMat = new JLabel("");
       
       
       
       inscripcionLic.add(numeroMaterias);
      
       inscripcionLic.add(totalMat);
       
       
       curso = new JLabel ("Curso propedeutico");
       inscripcionLic.add(curso);
       costocurso = new JLabel ("");
       inscripcionLic.add(costocurso);
       
       inscripcionLic.add(new JLabel("Total de colegiatura"));
       total = new JLabel ("");
       inscripcionLic.add(total);
       
     
     
     costomaterias=0;
     totalcolegiatura=0;
     
       panel.add("Center", inscripcionLic);
       panel.add("South",calcular);
       
       
        getContentPane().add(panel);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
        
    } 
    
    
    public void actionPerformed(ActionEvent mn) {
     if (mn.getSource() == calcular){
     
     if(tipoTramite.getSelectedItem().toString()== "Inscripcion licenciatura"){
 curso.setVisible(true);
  costocurso.setVisible(true);
 
 try{
     if (local.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 350;
 cuotaServicios.setText("$1500");
 totalMat.setText(""+costomaterias);
 costocurso.setText("500");
 totalcolegiatura=1500+costomaterias+500;
 total.setText(""+totalcolegiatura);
     }
     
      if (foraneo.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 400;
 cuotaServicios.setText("$1500");
 totalMat.setText(""+costomaterias);
 costocurso.setText("500");
 totalcolegiatura=1500+costomaterias+500;
 total.setText(""+totalcolegiatura);
     }
     
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, "Introduzca numero de materias en formato numerico");
 cuotaServicios.setText("");
 totalMat.setText("");
 costocurso.setText("");
  total.setText("");
 }
 

 
     }
     
     
       if(tipoTramite.getSelectedItem().toString()== "Reinscripcion de licenciatura"){
try{
     if (local.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 300;
 cuotaServicios.setText("$1000");
 totalMat.setText(""+costomaterias);
 //costocurso.setText("1500");
  curso.setVisible(false);
  costocurso.setVisible(false);
 totalcolegiatura=1000+costomaterias;
 total.setText(""+totalcolegiatura);
     }
     
      if (foraneo.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 350;
 cuotaServicios.setText("$1000");
 totalMat.setText(""+costomaterias);
 //costocurso.setText("1500");
  curso.setVisible(false);
  costocurso.setVisible(false);
 totalcolegiatura=1000+costomaterias;
 total.setText(""+totalcolegiatura);
     }
     
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, "Introduzca numero de materias en formato numerico");
 cuotaServicios.setText("");
 totalMat.setText("");
 costocurso.setText("");
  total.setText("");
 }
     }
       
       if(tipoTramite.getSelectedItem().toString()== "Inscripcion de maestria"){
  curso.setVisible(true);
  costocurso.setVisible(true);
 
 try{
     if (local.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 500;
 cuotaServicios.setText("$2500");
 totalMat.setText(""+costomaterias);
 costocurso.setText("2000");
 totalcolegiatura=2500+costomaterias+2000;
 total.setText(""+totalcolegiatura);
     }
     
      if (foraneo.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 550;
 cuotaServicios.setText("$2500");
 totalMat.setText(""+costomaterias);
 costocurso.setText("2000");
 totalcolegiatura=2500+costomaterias+2000;
 total.setText(""+totalcolegiatura);
     }
     
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, "Introduzca numero de materias en formato numerico");
 cuotaServicios.setText("");
 totalMat.setText("");
 costocurso.setText("");
  total.setText("");
 }
     }
     
       
        if(tipoTramite.getSelectedItem().toString()== "Reinscripcion de maestria"){
try{
     if (local.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 500;
 cuotaServicios.setText("$1500");
 totalMat.setText(""+costomaterias);
 //costocurso.setText("1500");
  curso.setVisible(false);
  costocurso.setVisible(false);
 totalcolegiatura=1500+costomaterias;
 total.setText(""+totalcolegiatura);
     }
     
      if (foraneo.isSelected()){
 costomaterias= Double.parseDouble(numeroMat.getText()) * 550;
 cuotaServicios.setText("$1500");
 totalMat.setText(""+costomaterias);
 //costocurso.setText("1500");
  curso.setVisible(false);
  costocurso.setVisible(false);
 totalcolegiatura=1500+costomaterias;
 total.setText(""+totalcolegiatura);
     }
     
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, "Introduzca numero de materias en formato numerico");
 cuotaServicios.setText("");
 totalMat.setText("");
 costocurso.setText("");
  total.setText("");
 }
     }
     
     }
    
    }
    
    public static void main (String [] args){
    
        Colegiatura c = new Colegiatura (); 
    
    }
    
}
