/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatos;

/**
 *
 * @author José Manuel Martínez Romera
 * version 1.0
 */
public class Medicamento extends Producto {
    
   private String comoTomar;
   private String efectosAdversos;
   private TipoMedicamento tipoMedicamento;
  
   public Medicamento (String codigo, String nombre, String descripcion, float precio, int unidades, TipoMedicamento tipoMedicamento ,String comoTomar, String efectosAdversos){
        super(codigo, nombre, descripcion, precio, unidades);
        this.comoTomar = comoTomar;
        this.efectosAdversos = efectosAdversos;
        this.tipoMedicamento = tipoMedicamento;
   }
    
   public TipoMedicamento getTipoMedicamento() {
        return this.tipoMedicamento;
   }
   
   public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
   }
   
   public String getComoTomar () {    
       return comoTomar;
   }
   
   public void setComoTomar (String ComoTomar) {
       
       this.comoTomar = comoTomar;
       
   }
   
   public String getEfectosAdversos (String efectosAdversos) {
       
       return efectosAdversos;
   }
   
   public void setEfectosAdversos (String efectosAdversos) {
       
       this.efectosAdversos = efectosAdversos;
       
   }
   
   @Override
    public String toString() {
        return "\n1. El tipo de medicamento: " + this.tipoMedicamento.toString() + 
                "\n2. Se puede tomar: " + comoTomar + " \n3. Y tiene estos posibles efectos adversos: " +
                efectosAdversos;
    }
}
