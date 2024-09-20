package Clases.Banco;

import java.time.LocalDateTime;
import java.util.HashMap;

import Clases.Cuentas.Cuenta;
import Clases.Cuentas.Inversion;
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
    private Integer numCuenta;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private int telefono;
    private LocalDateTime fechaRegistro;
    private HashMap<String, Cuenta> cuentas;
    
    public Cliente(Integer numCliente,String nombre, String apellidoP,String apellidoM,String direccion,int telefono){
        this.numCuenta= numCliente;
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.direccion=direccion;
        this.telefono =telefono;
        this.fechaRegistro= LocalDateTime.now();

        //se agrega nueva cuenta
        agregarCuenta("Debito",new Cuenta(0.0));
        contadorClientes++;
    }

    //Aqui se agrega cualuier tipo de cuenta
    public void agregarCuenta(String tipo, Cuenta cuenta){
        cuentas.put(tipo, cuenta);
    }

    public Cuenta getCuenta(String tipo){
        return cuentas.get(tipo);
    }

    public void abrirCuentaInversion(double monto, int plazoDias) {
        if(cuentas.containsKey("Inversion")!=true&monto<=getCuenta("Debito").getSaldo()) {
            Inversion inversion = new Inversion(monto, plazoDias);
            retirarDinero("Debito",monto);
            cuentas.put("Inversion", inversion);
        } else {
            System.out.println("El cliente ya tiene una cuenta de Ahorro.");
        }
    }

    //Cambia el saldo de la cuenta
    public void retirarDinero(String tipo,double monto){
        Cuenta cuenta=getCuenta(tipo);
        cuenta.setSaldo(cuenta.getSaldo()-monto);

    }

    public static int getContadorClientes() {//metodo estatico
        return contadorClientes;
    }

    public String getAMaterno() {
        return apellidoM;
    }

    public void setAMaterno(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getAPaterno() {
        return apellidoP;
    }

    public void setAPaterno(String apellidoP) {
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

    public Integer getNumCliente() {
        return numCuenta;
    }

    //Todos los datos del usuario
    public String toString() {
        return "Numero de Cuenta: "+numCuenta+ "\\n"+
                "Nombre: "+nombre +apellidoP+apellidoP+ "\\n"+
                "Telefono: " + telefono +"\\n" + 
                "Direccion: "+direccion+"\\n" + 
                "Telefono: "+fechaRegistro+"\\n"+
                "Cuenta debito: "+getCuenta("Debito").getSaldo()+"\\n"+
                "Cuenta Inversion: "+getCuenta("Inversion").getSaldo()+"\\n";

    }
}