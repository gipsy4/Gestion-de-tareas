/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pooactividad6;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class POOActividad6 extends JFrame{
    private GestionTareas gestionTareas;
    
    private JTextArea areaTareas;
    private JTextField campoNombre;
    private JTextField campoEmail;
    private JTextField campoDescripcion;
    private JTextField campoFechaLimite;
    
    public POOActividad6(){
        gestionTareas = new GestionTareas();
        
        setTitle("--Gestion de Tareas para Estudiantes--");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
    
        //Seccion de panel
        
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new GridLayout(2,2));
        
        panelUsuario.add(new JLabel("Nombre"));
        campoNombre = new JTextField();
        panelUsuario.add(campoNombre);
        
        panelUsuario.add(new JLabel("Email"));
        campoEmail = new JTextField();
        panelUsuario.add(campoEmail);
        
        JButton btnRegistrarUsuario = new JButton("Registar Usuario");
        btnRegistrarUsuario.addActionListener(e-> registrarUsuario());
        panelUsuario.add(btnRegistrarUsuario);
        
        container.add(panelUsuario,BorderLayout.NORTH);
        
        
        //Seccion tareas
        
        JPanel panelTareas = new JPanel();
        panelTareas.setLayout(new GridLayout(3,2));
        
        panelTareas.add(new JLabel("Descripcion de Tareas:"));
        campoDescripcion = new JTextField();
        panelTareas.add(campoDescripcion);
        
        panelTareas.add(new JLabel("Fecha limite: (YYYY-MM-DD): "));
        campoFechaLimite = new JTextField();
        panelTareas.add(campoFechaLimite);
        
        JButton btnRegistrarTarea = new JButton("Registar Tarea");
        btnRegistrarTarea.addActionListener(e-> registrarTarea());
        panelTareas.add(btnRegistrarTarea);
        
        container.add(panelTareas, BorderLayout.CENTER);
        
        areaTareas = new JTextArea();
        areaTareas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTareas);
        container.add(scrollPane, BorderLayout.SOUTH);
        
        //Seccion del menu
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem itemVerEstadisticas = new JMenuItem("Ver Estadisticas");
        itemVerEstadisticas.addActionListener(e-> verEstadisticas());
        menu.add(itemVerEstadisticas);
        
        JMenuItem itemBorrarTarea = new JMenuItem("Borrar Tarea");
        itemBorrarTarea.addActionListener(e-> borrarTarea());
        menu.add(itemBorrarTarea);
        
        menuBar.add(menu);
        setMenuBar(menuBar);   
    }

    private void registrarUsuario(){
        String nombre = campoNombre.getText();
        String email = campoEmail.getText();
        if(!nombre.isEmpty()&& !email.isEmpty()){
            gestionTareas.registrarUsuario(nombre, email);
            JOptionPane.showMessageDialog(this, "Usuario registrado de forma exitosa.");
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los datos");
        }
    }
    private void registrarTarea(){
        String descripcion = campoDescripcion.getText();
        String fechaString = campoFechaLimite.getText();
        if(!descripcion.isEmpty()&& !fechaString.isEmpty()){
            try{
                Date fechaLimite = java.sql.Date.valueOf(fechaString);
                gestionTareas.registarTarea(descripcion,fechaLimite);
                JOptionPane.showMessageDialog(this,"Tarea registrada correctamente");
                actualizarTareas();
            }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Fecha Registra de forma incorrecta.");
        }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los datos");
        }
    }
        
    private void verEstadisticas(){
        gestionTareas.verEstadisticas();
    }
    private void borrarTarea(){
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion:");
        List<Tarea> tareas = gestionTareas.getTareas();
        for(Tarea tarea : tareas){
            if(tarea.getDescripcion().equalsIgnoreCase(descripcion)){
                gestionTareas.borrarTarea(tarea);
                JOptionPane.showMessageDialog(this,"Tareaborradade forma exitosa.");
                actualizarTareas();
                return;
            }
        }
    JOptionPane.showMessageDialog(this,"tarea no encontrada.");
    }

    private void actualizarTareas(){
        areaTareas.setText("");
        for(Tarea tarea: gestionTareas.getTareas()){
            areaTareas.append(tarea.toString()+"/n");
        }
    }
        
    
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(()->{
            new POOActividad6().setVisible(true);
        });
    }

    private void setMenuBar(JMenuBar menuBar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}


