package Clases.Cliente;

import java.util.ArrayList;

import Clases.Cuentas.Movimiento;

/**
 * Archivo: Cuenta.java
 * package Clases.Cuenta
 * La clase Cuenta representa una cuenta bancaria genérica que almacena un saldo y
 * registra una lista de movimientos. Los movimientos pueden ser depósitos, retiros
 * relacionados con la cuenta.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Cuenta {
    private Double saldo;
    private ArrayList<Movimiento> movimientos;

    /**
     * Constructor de la clase Cuenta.
     * Inicializa la cuenta con un saldo inicial y crea un movimiento indicando
     * que la cuenta fue creada.
     * @param saldo El saldo inicial de la cuenta.
     */
    public Cuenta(double saldo){
        this.saldo = saldo;
        this.movimientos = new ArrayList<Movimiento>();
        agregarMovimiento(new Movimiento("Creación de cuenta"));
    }

    /**
     * Método que agrega un movimiento a la lista de movimientos de la cuenta.
     * @param movimiento Objeto Movimiento que representa una operación realizada en la cuenta.
     */
    public void agregarMovimiento(Movimiento movimiento){
        movimientos.add(movimiento);
    }

    /**
     * Método que retorna el saldo actual de la cuenta.
     * @return El saldo disponible en la cuenta.
     */
    public Double getSaldo() { 
        return saldo; 
    }  

    /**
     * Método que establece un nuevo saldo para la cuenta.
     * @param saldo El nuevo saldo que se quiere establecer.
     */
    public void setSaldo(double saldo) { 
        this.saldo = saldo; 
    }  

    /**
     * Método que organza la colección, retorna la lista de movimientos realizados en la cuenta.
     * @return Una lista de objetos Movimiento que representan las operaciones de la cuenta.
     */
    public ArrayList<Movimiento> getMovimientos(){
        return movimientos;
    }

}