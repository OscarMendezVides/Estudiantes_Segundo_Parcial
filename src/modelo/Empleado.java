/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cocav
 */
public class Empleado extends Persona{
    private String codigo;
public Empleado(){}
    public Empleado(String codigo, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public void agregar(){
        System.out.println("Codigo:" + getCodigo());
        System.out.println("Nombres:" + getNombres());
        System.out.println("Apellidos:" + getApellidos());
        System.out.println("Direccion:" + getDireccion());
        System.out.println("Telefono:" + getTelefono());
        System.out.println("Fecha Nacimiento:" + getFecha_nacimiento());
        System.out.println("________________________________________");
    }
}

