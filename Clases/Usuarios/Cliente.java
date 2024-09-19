package Clases.Usuarios;

/**
 * Cliente
 */

 /*
Métodos del objeto cliente:
registrarCliente: Permite registrar un nuevos clientes.
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
    private String fechaRegistro;
    private Cuenta cuenta;
    

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    
    public String toString() {//para convertir a cadena.
        return nombre + " - " + telefono +  " - "+direccion+")";
    }
}