/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooactividad6;
import java.util.Date;

public class Tarea {
    private String descripcion;
    private Date fechaLimite;
    private boolean completada;

    public Tarea(String descripcion, Date fechaLimite, boolean completada) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
    }

    Tarea(String descripcion, Date fechaLimite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public boolean isCompletada() {
        return completada;
    }
    
    public void marcarCompletada(){
        this.completada= true;
    }
    public void borrarTarea(){
        this.descripcion = null;
        this.fechaLimite =null;
        this.completada = false;
    }

    @Override
    public String toString() {
        return "Tarea{" + "descripcion=" + descripcion + ", fechaLimite=" + fechaLimite + ", completada=" + completada + '}';
    }
    
}
