/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cocav
 */

    
  

public class Estudiantes extends Persona{
   
    private int id;
    Conexion cn;
public Estudiantes(){}
    public Estudiantes(int id, String carnet, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento,String genero,String email) {
        super(carnet,nombres,apellidos,direccion,telefono,fecha_nacimiento,genero,email);
        
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    cn = new Conexion();
    cn.abrir_conexion();
    String query;
    query = "Select id_estudiantes as id,carnet,nombres,apellidos,direccion,telefono,fecha_nacimiento,genero,email from estudiantes;";
    ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
    
    String encabezado[] = {"id","Carnet","Nombres","Apellidos","Direccion","Telefono","Nacimiento","Genero","Email"};
    tabla.setColumnIdentifiers(encabezado);
    String datos[] = new String [9];
    while(consulta.next()){
    datos[0] = consulta.getString("id");
    datos[1] = consulta.getString("carnet");
    datos[2] = consulta.getString("nombres");
    datos[3] = consulta.getString("apellidos");
    datos[4] = consulta.getString("direccion");
    datos[5] = consulta.getString("telefono");
    datos[6] = consulta.getString("fecha_nacimiento");
    datos[7] = consulta.getString("genero");
    datos[8] = consulta.getString("email");
    tabla.addRow(datos);
    }
    cn.cerrar_conexion();
    }
    
    catch(SQLException ex){
        cn.cerrar_conexion();
        System.out.println("Error" + ex.getMessage() );
    }
    return tabla;
    }
    @Override
    public void agregar(){
     try{
     PreparedStatement parametro;
     String query = "INSERT INTO estudiantes(Carnet,Nombres,Apellidos,Direccion,Telefono,Fecha_Nacimiento,Genero,Email) VALUES(?,?,?,?,?,?,?,?);";
     cn = new Conexion();
     cn.abrir_conexion();
     parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
     parametro.setString(1, getCarnet());
     parametro.setString(2, getNombres());
     parametro.setString(3, getApellidos());
     parametro.setString(4, getDireccion());
     parametro.setString(5, getTelefono());
     parametro.setString(6, getFecha_nacimiento());
     parametro.setString(7, getGenero());
     parametro.setString(8, getEmail());
     int executar = parametro.executeUpdate();
     cn.cerrar_conexion();
     JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ ex.getMessage());
     } 
    }
    
    @Override
    public void actualizar(){
    try{
     PreparedStatement parametro;
     String query = "update estudiantes set Carnet = ?,Nombres = ?,Apellidos = ?,Direccion = ?,Telefono = ?,Fecha_Nacimiento = ?,Genero = ?,Email = ? "
             + "where id_estudiantes = ?";
     cn = new Conexion();
     cn.abrir_conexion();
     parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
     parametro.setString(1, getCarnet());
     parametro.setString(2, getNombres());
     parametro.setString(3, getApellidos());
     parametro.setString(4, getDireccion());
     parametro.setString(5, getTelefono());
     parametro.setString(6, getFecha_nacimiento());
     parametro.setString(7, getGenero());
     parametro.setString(8, getEmail());
     parametro.setInt(9, this.getId());
     int executar = parametro.executeUpdate();
     cn.cerrar_conexion();
     JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Actulizado","Actualizar",JOptionPane.INFORMATION_MESSAGE);
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ ex.getMessage());
     } 
    }
    
    @Override
    public void eliminar(){
    try{
     PreparedStatement parametro;
     String query = "delete from estudiantes where id_estudiantes = ?";
     cn = new Conexion();
     cn.abrir_conexion();
     parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
     parametro.setInt(1, this.getId());
     int executar = parametro.executeUpdate();
     cn.cerrar_conexion();
     JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Eliminado","Eliminar",JOptionPane.INFORMATION_MESSAGE);
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ ex.getMessage());
     } 
    }

    
    
}
    

