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
 * Archivo: Cliente.java
 * package Clases.Cliente
 * La clase Cliente representa a un cliente de un banco, que puede tener diversas cuentas
 * como débito, crédito o inversión. Administra la creación de cuentas, depósitos y retiros,
 * así como el registro del cliente y sus operaciones bancarias.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Cliente {
    public static int comision = 10;  // Comisión fija por cada operación
    public static int contadorClientes; // Cuenta el número de clientes registrados
    private String numCuenta; // Número de cuenta del cliente
    private String nombre;  // Nombre del cliente
    private String apellidoP; // Apellido parterno del cliente
    private String apellidoM; // Apellido Materno del cliente
    private String direccion; // Dirección del cliente
    private String telefono; // Teléfono de contacto del cliente
    private LocalDateTime fechaRegistro; // Fecha de registro para la apertura de cuenta
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' hh:mm:ss a");
    private HashMap<String, Cuenta> cuentas; // Tabla hash para la coleccion de cuentas asociadas al cliente
    
    /**
     * Constructor de la clase Cliente.
     * Inicializa los atributos del cliente, asigna la fecha de registro generando la apertura
     * de una cuenta de débito con saldo inicial de 0.0.
     * @param numCliente Número único de identificación del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoP Apellido paterno del cliente.
     * @param apellidoM Apellido materno del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     */
    public Cliente(String numCliente,String nombre, String apellidoP,String apellidoM,String direccion,String telefono){
        this.numCuenta = numCliente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuentas = new HashMap<String, Cuenta>();
        this.fechaRegistro = LocalDateTime.now();

        agregarCuenta("Débito",new Debito(0.0)); // Saldo inicial para cuenta creada
        contadorClientes++;
    }

    /**
     * Método propio que agrega una cuenta de un tipo específico al cliente.
     * @param tipo Tipo de cuenta (Débito, Crédito, Inversión).
     * @param cuenta Objeto cuenta que se añadirá.
     */
    public void agregarCuenta(String tipo, Cuenta cuenta){
        cuentas.put(tipo, cuenta);
    }

    /**
     * Método que obtiene la cuenta del cliente de acuerdo al tipo.
     * @param tipo Tipo de cuenta que se desea obtener.
     * @return Cuenta asociada al tipo especificado.
     */
    public Cuenta getCuenta(String tipo){
        return cuentas.get(tipo);
    }

    /**
     * Métdo que abre una nueva cuenta de inversión si el saldo en la cuenta de débito es suficiente.
     * Transfiere el monto de la cuenta de débito a la de inversión.
     * @param monto Monto a invertir.
     * @param plazoDias Plazo de la inversión en días.
     * @return Mensaje indicando si la cuenta se creó correctamente o si hubo un error.
     */
    public String abrirCuentaInversion(double monto, int plazoDias) {
        if(monto <= getCuenta("Débito").getSaldo()){
            Inversion inversion = new Inversion(monto, plazoDias);
            retirarDinero("Débito",monto);
            cuentas.put("Inversión", inversion);
            return "Cuenta creada correctamente";
        }else return "Saldo insuficiente para transeferir de cuenta de débito a la de inversión";
    }

    /**
     * Método que abre una cuenta de crédito para el cliente, si no existe una previamente y
     * si el saldo en la cuenta de débito es suficiente.
     * @return Mensaje indicando el resultado de la operación.
     */
    public String abrirCuentaCredito() {
        double saldo = getCuenta("Débito").getSaldo();
        if(saldo != 0){
            Random random= new Random();
            if(cuentas.containsKey("Crédito")!=true) {
                double porcentajeCredito = (saldo < 1000) ? 0.1 : ((saldo >= 1000) && (saldo < 5000)) ? 0.2 : 0.3;
                saldo*=porcentajeCredito*15;
                Integer numero = random.nextInt(1000000);
                Credito credito = new Credito(String.valueOf(numero), saldo);
                cuentas.put("Crédito", credito);
                return "Cuenta creada correctamente.\n";
            } else return "El cliente ya tiene una cuenta de Crédito.\n";
        } else return "Saldo insuficiente para que se pueda hacer una cuenta de crédito, es requerido que haga un déposito.\n";
    }

    /**
     * Método para retirar dinero de la cuenta del cliente, teniendo en cuenta la comisión fija.
     * @param tipo Tipo de cuenta de la cual se retira el dinero.
     * @param monto Monto a retirar.
     * @return Mensaje indicando si el retiro fue exitoso o si hubo algún error.
     */
    public String retirarDinero(String tipo,double monto){
        Cuenta cuenta = getCuenta(tipo);
        if (cuenta != null) {
            double saldo = cuenta.getSaldo();
            if ((monto + comision) <= saldo) {
                cuenta.setSaldo(saldo-monto-comision);
                cuenta.agregarMovimiento(new Movimiento(monto, "Retiro de dinero"));
                return "Saldo retirado correctamente.\n";
            }else return "El dinero de la cuenta no es suficiente para hacer el retiro, considere la comisión de "+comision+" pesos. \n";
        }else return "No tiene la cuenta de "+tipo.toLowerCase()+".\n";
    }

    /**
     * Método para realizar el depósito de dinero en la cuenta del cliente, con verificación especial
     * si es una cuenta de crédito, para evitar exceder el límite de crédito.
     * @param tipo Tipo de cuenta a la que se deposita.
     * @param monto Monto a depositar.
     * @return Mensaje indicando si el depósito fue exitoso o si hubo algún error.
     */
    public String depositarDinero(String tipo,double monto){
        Cuenta cuenta = getCuenta(tipo);
        if (cuenta != null) {
            double saldo = cuenta.getSaldo();
            if(cuenta instanceof Credito){  // Condición de la tarjeta de créditono para no exceder el límite de crédito si este está completo.
                Credito credito = (Credito) cuenta;
                double creditoDisponible = credito.getCreditoDisponible();
                if((saldo + monto) > creditoDisponible)
                    return "El monto a depositar excede el limite de crédito permitido.";
            }
            cuenta.setSaldo(saldo+monto);
            cuenta.agregarMovimiento(new Movimiento(monto, "Depósito de dinero"));
            return "Saldo depositado correctamente";
        }else return "No tiene la cuenta de "+tipo.toLowerCase();
    }

    /**
     * Método de verificación si el cliente tiene una cuenta del tipo especificado.
     * @param tipo Tipo de cuenta.
     * @return `true` si la cuenta existe, `false` si no.
     */
    public boolean cuentaExiste(String tipo){
        return getCuenta(tipo) != null ? true : false;
    }

    /**
     * Método estático que devuelve el número total de clientes registrados.
     * @return Número total de clientes.
     */
    public static int getContadorClientes() {
        return contadorClientes;
    }

    // Getters y setters para los atributos la clase Cliente.

    /**
     * Método para obtener el apellido materno del cliente.
     * @return Apellido materno del cliente.
     */
    public String getAMaterno() {
        return apellidoM;
    }

    /**
     * Método para establecer el apellido materno del cliente.
     * @param apellidoM Apellido materno nombre del cliente.
     */
    public void setAMaterno(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Método para obtener el apellido paterno del cliente.
     * @return Apellido paterno del cliente.
     */
    public String getAPaterno() {
        return apellidoP;
    }

    /**
     * Método para establecer el apellido paterno del cliente.
     * @param apellidoP Apellido paterno nombre del cliente.
     */
    public void setAPaterno(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Método para obtener el teléfono del cliente.
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el teléfono del cliente.
     * @param telefono Nuevo teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del cliente.
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para establecer la dirección del cliente.
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener la dirección del cliente.
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para obtener el número del cliente.
     * @return Número del cliente.
     */
    public String getNumCliente() {
        return numCuenta;
    }

    /**
     * Método toString que devuelve una cadena con la información del cliente,
     * mostrando numero de cuenta, nombre y apellidos del cliente, telefono, direccón del cliente, 
     * resgistro de apertura de cuenta y saldo.
     * @return Información detallada del cliente, incluyendo sus cuentas y saldo de débito.
     */
    public String toString() {
        return "Numero de Cuenta: "+numCuenta+ "\n"+
                "Nombre: "+nombre+" "+apellidoP+" "+apellidoM+ "\n"+
                "Teléfono: " +telefono+"\n" + 
                "Dirección: "+direccion+"\n" + 
                "Fecha de registro: "+fechaRegistro.format(formatoFecha)+"\n"+
                "Cuenta débito: "+getCuenta("Débito").getSaldo()+"\n";
    }
}