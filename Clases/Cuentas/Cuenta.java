package Clases.Cuentas;

import java.util.ArrayList;
/**
 * Cuenta
 */
/*

Métodos del objeto cuenta:
ingresarDinero: Aumenta el dinero de la cuenta.
retirarDinero: Disminuye el dinero.
verSaldo: Muestra el dinero actual.
verMovimientos: Muestra la lista de movimientos de la cuenta.
 */
public class Cuenta {
    private Double saldo;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(){
        this.saldo= 0.0;
        this.movimientos= new ArrayList<Movimiento>();
        agregarMovimiento(new Movimiento("Creacion de cuenta"));
    }

    public Cuenta(double saldo){
        this.saldo= saldo;
        this.movimientos= new ArrayList<Movimiento>();
        agregarMovimiento(new Movimiento("Creacion de cuenta"));
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

}