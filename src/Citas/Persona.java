/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Citas;

/**
 *
 * @author benja
 */
public class Persona {
    private String nombre;
    private String sexo;
    private int edad;
    private String edoCivil;
    private String telefono;
    private String foto;
    
    
    public Persona(String nombre, String sexo, int edad, String edoCivil, String telefono, String foto){
    
        setNombre(nombre);
        setSexo(sexo);
        setEdad(edad);
        setEdoCivil(edoCivil);
        setTelefono(telefono);
        setFoto(foto);
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the edoCivil
     */
    public String getEdoCivil() {
        return edoCivil;
    }

    /**
     * @param edoCivil the edoCivil to set
     */
    public void setEdoCivil(String edoCivil) {
        this.edoCivil = edoCivil;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
