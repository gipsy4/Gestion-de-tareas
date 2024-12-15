/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooactividad6;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GestionTareas {
    private List<Usuario> usuarios;
    private List<Tarea> tareas;

    public GestionTareas(){
        usuarios = new ArrayList<>();
        tareas = new ArrayList<>();
    }
    
    public void registrarUsuario (String nombre, String email){
        usuarios.add(new Usuario(nombre, email));
    }
    public void registarTarea(String descripcion, Date fechaLimite){
        tareas.add(new Tarea(descripcion, fechaLimite));
    }
    public void borrarTarea(Tarea tarea){
        tareas.remove(tarea);
    }
    
    public void verEstadisticas(){
        int completadas = 0;
        for(Tarea tarea: tareas){
            if(tarea.isCompletada()){
                completadas++;
            }
        }
        System.out.println("Tareas completads: "+completadas);
        System.out.println("Tareas pendientes"+(tareas.size()-completadas));
    }
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    public List<Tarea> getTareas(){
        return tareas;
    }    
}
