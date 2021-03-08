/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatos;

import java.util.regex.Pattern;
import Utilidades.ValidarDatos;
import java.io.Serializable;
/**
 * Clase de productos donde se va a encontrar su código, nombre, descripción,
 * precio y unidades
 *
 * @José Manuel Martínez Romera Version 1.0
 */
public abstract class Producto implements Serializable {
    //Parametros
    private String codigo;
    private String nombre;
    private String descripcion;
    private float precio;
    private int unidades;

    public Producto(String codigo, String nombre, String descripcion, float precio, int unidades) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        if (unidades < 0) {
            this.unidades = 0;
        } else {
            this.unidades = unidades;
        }
        if (precio < 0) {
            this.precio = 0;
        } else {
            this.precio = precio;
        }
    }
    
    private static boolean comprobarCodigo(String codigo) {
        return ValidarDatos.comprobarCodigo(codigo);
        //o puede ser: return this.codigo.equals(codigo);
    }
    
    /**
     * Método que se va a encargar de añadir unidades
     *
     * @param unidades
     * @return
     */
    public boolean aniadirUnidades(int unidades) {
        this.unidades = this.unidades + unidades;
        return true;
    }

    /**
     * Método que se va a encargar de quitar unidades
     *
     * @param unidades
     * @return
     */
    public boolean quitarUnidades(int unidades) {
        this.unidades = this.unidades + unidades;
        return true;
    }

    /**
     * Getter de codigo
     *
     * @return codigo
     */
    public String getCodigo() {

        return codigo;

    }

    /**
     * Setter de codigo
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * Getter de descripcion
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de descripcion
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de precio
     *
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Setter de precio
     *
     * @param precio
     */
    public void setPrecio(float precio) {
        if (precio < 0) { this.precio = 0; }
        else { this.precio = precio; }
    }

    /**
     * Getter de unidades
     *
     * @return unidades
     */
    public int getUnidades() {
        return unidades;
    }
    
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
/**
 * Se usa para crear una representación de String mostrando codigo, nombre, descripcion, precio y unidades
 * @return Devuelve codigo, nombre, descripcion,precio y unidades.
 */
    @Override
    public String toString() {
        return "\n1. codigo: " + codigo + " \n2. Nombre: " + nombre + " \n3.Descripción: "
                + descripcion + " \n4.Precio: " + precio + "\n5. Unidades: " + unidades;
    }

}
