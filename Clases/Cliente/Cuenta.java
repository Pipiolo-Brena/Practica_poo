package Clases.Cliente;

import java.util.ArrayList;

import Clases.Cuentas.Movimiento;
/**
 * Cuenta
 */
public class Cuenta {
    private Double saldo;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(double saldo){
        this.saldo= saldo;
        this.movimientos= new ArrayList<Movimiento>();
        agregarMovimiento(new Movimiento("Creación de cuenta"));
    }

    public void agregarMovimiento(Movimiento movimiento){
        movimientos.add(movimiento);
    }

    public Double getSaldo() { 
        return saldo; 
    }  

    public void setSaldo(double saldo) { 
        this.saldo=saldo; 
    }  

    public ArrayList<Movimiento> getMovimientos(){
        return movimientos;
    }

}