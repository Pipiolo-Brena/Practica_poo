package Clases.Usuarios;

import java.time.LocalDateTime;
import java.util.Set;
/**
 * Cliente
 */

 /*
Métodos del objeto cliente:
modificarDatos(será para cada dato separado o juntos): Modifica los datos del cliente que se requiera.
verDatosCliente: Muestra la información del cliente.
 */
public class Cliente {
    public static int contadorClientes;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private int telefono;
    private LocalDateTime fechaRegistro;
    private Cuenta cuenta;
    
    public Cliente(Set<Integer> numCliente,String nombre, String apellidoP,String apellidoM,String direccion,int telefono){
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.direccion=direccion;
        this.telefono =telefono;
        this.fechaRegistro= LocalDateTime.now();

        this.cuenta = new Cuenta(numCliente);
        contadorClientes++;
    }

    public static int getContadorClientes() {//metodo estatico
        return contadorClientes;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public String toString() {//para convertir a cadena.
        return "Numero de Cuenta: "+cuenta.getNumCuenta()+ "\\n"+
                "Nombre: "+nombre +apellidoP+apellidoP+ "\\n"+
                "Telefono: " + telefono +"\\n" + 
                "Direccion: "+direccion+"\\n" + 
                "Telefono: "+fechaRegistro+"\\n";
    }
}