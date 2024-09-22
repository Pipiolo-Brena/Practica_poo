package Clases.Cliente;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

import Clases.Cuentas.Credito;
import java.time.format.DateTimeFormatter;
import Clases.Cuentas.Debito;
import Clases.Cuentas.Inversion;
import Clases.Cuentas.Movimiento;
/**
 * Cliente
 */
public class Cliente {
    public static int comision=10;
    public static int contadorClientes;
    private String numCuenta;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String telefono;
    private LocalDateTime fechaRegistro;
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' hh:mm:ss a");
    private HashMap<String, Cuenta> cuentas;
    
    public Cliente(String numCliente,String nombre, String apellidoP,String apellidoM,String direccion,String telefono){
        this.numCuenta= numCliente;
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.direccion=direccion;
        this.telefono =telefono;
        this.cuentas= new HashMap<String, Cuenta>();
        this.fechaRegistro= LocalDateTime.now();

        //se agrega nueva cuenta
        agregarCuenta("Débito",new Debito(0.0));
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
        if(monto<=getCuenta("Débito").getSaldo()){
            Inversion inversion = new Inversion(monto, plazoDias);
            retirarDinero("Débito",monto);
            cuentas.put("Inversión", inversion);
            return "Cuenta creada correctamente";
        }else return "Saldo insuficiente para transeferir de cuenta de débito a la de inversión";
    }

    public String abrirCuentaCredito() {
        double saldo= getCuenta("Débito").getSaldo();
        if(saldo!=0){
            Random random= new Random();
            if(cuentas.containsKey("Crédito")!=true) {
                double porcentajeCredito = (saldo < 1000) ? 0.1 : ((saldo >= 1000) && (saldo < 5000)) ? 0.2 : 0.3;
                saldo*=porcentajeCredito*15;
                Integer numero= random.nextInt(1000000);
                Credito credito = new Credito(String.valueOf(numero), saldo);
                cuentas.put("Crédito", credito);
                return "Cuenta creada correctamente.\n";
            } else return "El cliente ya tiene una cuenta de Crédito.\n";
        } else return "Saldo insuficiente para que se pueda hacer una cuenta de crédito, es requerido que haga un  déposito.\n";
    }

    //Cambia el saldo de la cuenta
    public String retirarDinero(String tipo,double monto){
        Cuenta cuenta=getCuenta(tipo);
        if (cuenta!=null) {
            double saldo= cuenta.getSaldo();
            if (monto+comision<=saldo) {
                cuenta.setSaldo(saldo-monto-comision);
                cuenta.agregarMovimiento(new Movimiento(monto, "Retiro de dinero"));
                return "Saldo retirado correctamente.\n";
            }else return "El dinero de la cuenta no es suficiente para hacer el retiro, considere la comosión de "+comision+" pesos. \n";
        }else return "No tiene la cuenta de "+tipo.toLowerCase()+".\n";
    }

    public String depositarDinero(String tipo,double monto){
        Cuenta cuenta=getCuenta(tipo);
        if (cuenta!=null) {
            double saldo= cuenta.getSaldo();
            if(cuenta instanceof Credito){ //Se agregó una condición para la tarjeta de crédito y así no exceder el límite de crédito si este está completo
                Credito credito = (Credito) cuenta;
                double creditoDisponible = credito.getCreditoDisponible();
                if((saldo + monto) > creditoDisponible)
                    return "El monto a depositar excede el limite de crédito permitido.";
            }
            cuenta.setSaldo(saldo+monto);
            cuenta.agregarMovimiento(new Movimiento(monto, "Depósito de dinero"));
            return "Saldo depositado correctamente";
        }else return "No tiene la cuenta de "+ tipo.toLowerCase();
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

    public String getNumCliente() {
        return numCuenta;
    }

    //Todos los datos del usuario
    public String toString() {
        return "Numero de Cuenta: "+numCuenta+ "\n"+
                "Nombre: "+nombre +" "+apellidoP+" "+apellidoM+ "\n"+
                "Teléfono: " + telefono +"\n" + 
                "Dirección: "+direccion+"\n" + 
                "Fecha de registro: "+fechaRegistro.format(formatoFecha)+"\n"+
                "Cuenta débito: "+getCuenta("Débito").getSaldo()+"\n";
    }
}