/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatos;

/**
 *
 * @author chema aka José Manuel Martínez Romera
 * Version 1.0
 */
public class Parafarmacia extends Producto {
    
   private int dosisUnidades;
   private float descuento;
   private Categoria categoria;
   
   public Parafarmacia (String codigo, String nombre, String descripcion, float precio, int unidades, Categoria categoria, int dosisUnidades, float descuento) {
        
        super(codigo, nombre, descripcion, precio, unidades);
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
        this.categoria = categoria;
   }

   public Categoria getCategoria(){
        return categoria;
   }
    
   public void setCategoria (Categoria categoria){
       this.categoria = categoria;
   }
    
   public int getDosisUnidades (){
       return dosisUnidades;
   }
    
   public void setDosisUnidades (int dosisUnidades) {
        this.dosisUnidades = dosisUnidades;
   }
    
   public float getDescuento () {
        return descuento;
   }    
    
   public void setDescuento (float descuento){
        this.descuento = descuento;
   }
    
    @Override
    public String toString() {
        return "1. Es un producto de la categoria: " + this.categoria.toString() + "\n2. Las dosis por unidad es: " + dosisUnidades + 
                " \n3. Y tiene este descuento: " + descuento;
    }
}
