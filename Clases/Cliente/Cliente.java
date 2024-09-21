package Clases.Cliente;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

import Clases.Cuentas.Credito;
import Clases.Cuentas.Debito;
import Clases.Cuentas.Inversion;
/**
 * Cliente
 */
public class Cliente {
    public static int comision=10;
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
        this.cuentas= new HashMap<String, Cuenta>();
        this.fechaRegistro= LocalDateTime.now();

        //se agrega nueva cuenta
        agregarCuenta("Debito",new Debito(0.0));
        contadorClientes++;
    }

    //Aqui se agrega cualuier tipo de cuenta
    public void agregarCuenta(String tipo, Cuenta cuenta){
        cuentas.put(tipo, cuenta);
    }

    public Cuenta getCuenta(String tipo){
        return cuentas.get(tipo);
    }

    public String abrirCuentaInversion(double monto, int plazoDias) {
        if(monto<=getCuenta("Debito").getSaldo()){
            Inversion inversion = new Inversion(monto, plazoDias);
            retirarDinero("Debito",monto);
            cuentas.put("Inversion", inversion);
            return "Cuenta creada correctamente";
        }else return "Saldo insuficiente para transeferir de cuenta de debito a la de imversion";
    }

    public String abrirCuentaCredito() {
        double saldo= getCuenta("Debito").getSaldo();
        Random random= new Random();
        if(saldo!=0){
            if(cuentas.containsKey("Credito")!=true) {
                double porcentajeCredito = saldo < 1000?  0.1: saldo >= 1000 && saldo < 5000? 0.2: 0.3;
                saldo*=porcentajeCredito*15;
                int numero= random.nextInt(1000000);
                Credito credito = new Credito(numero, saldo);
                cuentas.put("Credito", credito);
                return "Cuenta creada correctamente";
            } else return "El cliente ya tiene una cuenta de Ahorro.";
        } else return "Saldo insificiente para que se pueda hacer una cuenta de credito, reuqerido que haga un  deposito";
    }

    //Cambia el saldo de la cuenta
    public String retirarDinero(String tipo,double monto){
        Cuenta cuenta=getCuenta(tipo);
        if (cuenta!=null) {
            double saldo= cuenta.getSaldo();
            if (monto<=saldo) {
                cuenta.setSaldo(saldo-monto-comision);
                return "Saldo retirado correctamente";
            }else return "El dinero de la cuenta no es sificiente para hacer el retiro";
        }else return "No tiene la cuenta de "+tipo;
    }

    public String depositarDinero(String tipo,double monto){
        Cuenta cuenta=getCuenta(tipo);
        if (cuenta!=null) {
            double saldo= cuenta.getSaldo();
            cuenta.setSaldo(saldo+monto);
            return "Saldo depositado correctamente";
        }else return "No tiene la cuenta de "+tipo;
    }

    public boolean cuentaExiste(String tipo){
        return getCuenta(tipo)!=null?true:false;
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
        return "Numero de Cuenta: "+numCuenta+ "\n"+
                "Nombre: "+nombre +" "+apellidoP+" "+apellidoM+ "\n"+
                "Telefono: " + telefono +"\n" + 
                "Direccion: "+direccion+"\n" + 
                "Fecha de registro: "+fechaRegistro+"\n"+
                "Cuenta debito: "+getCuenta("Debito").getSaldo()+"\n";
    }
}