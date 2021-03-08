/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatos;

import java.io.Serializable;

/**
 * Clase de clientes donde se encuentran su id,nombre, dirección y teléfono.
 * @author José Manuel Martínez Romera 
 * Versión 1.0
 */
public class Cliente implements Serializable{
//Parámetros
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(String id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

    }
    
    /**
     * Getter de id
     *
     * @return id
     */
    public String getId() {

        return id;
    }

    /**
     * Setter de ID
     *
     * @param id
     */
    public void setId(String id) {

        this.id = id;
    }

    /**
     * Getter de nombre
     *
     * @return nombre
     */
    public String getNombre() {

        return nombre;
    }

    /**
     * Setter de nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    /**
     * Getter de dirección
     *
     * @return direccion
     */
    public String getDireccion() {

        return direccion;
    }

    /**
     * Setter de dirección
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    /**
     * Getter de telefono
     *
     * @return telefono
     */
    public String getTelefono() {

        return telefono;

    }

    /**
     * Setter de telefono
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {

        this.telefono = telefono;

    }

    /**
     * Método toString
     *
     * @return id, nombre,direccion y telefono
     */
    
    @Override
    public String toString() {

        return "\n1. Id: " + id + " \n2. Nombre: " + nombre + " \n3.Direccion: " + direccion + " \n4.Telefono: " + telefono;

    }
}
