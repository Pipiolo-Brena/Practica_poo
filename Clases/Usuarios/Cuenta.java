package Clases.Usuarios;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Set<Integer> numCuenta;
    private HashMap<String, Double> cuentas;
    private int rendimiento;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(Set<Integer> numCuenta){
        this.numCuenta= numCuenta;
        this.cuentas= new HashMap<String, Double>();
        this.movimientos= new ArrayList<Movimiento>();
        agregarCuentaSaldo("Debito",0.0);
        agregarMovimiento(new Movimiento("Creacion de cuenta"));
    }

    public void agregarCuentaSaldo(String cuenta, Double valor){
        cuentas.put(cuenta, valor);
    }

    public void set(String cuenta, Double valor){
        cuentas.put(cuenta, valor);
    }

    public void agregarMovimiento(Movimiento movimiento){
        movimientos.add(movimiento);
    }

    public Double getSaldo(String cuenta) { 
        return cuentas.get(cuenta); 
    }  

    public Set<Integer> getNumCuenta(){
        return numCuenta;
    }

    public String toString(){
        return ""+numCuenta;
    }
}