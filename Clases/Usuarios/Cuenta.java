package Clases.Usuarios;

import Metodos.metodos;

import java.util.ArrayList;
import java.util.Hashtable;
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
    private int numCuenta;
    private Hashtable<String, Double> cuentas = new Hashtable<String, Double>( );
    private int rendimiento;
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public Double getSaldo(String tipo) { 
        return cuentas.get(tipo); 
    }

    public void setSaldo(String tipo,Double saldo){
        cuentas.put(tipo, saldo);
    }   
}