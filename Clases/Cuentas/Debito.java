package Clases.Cuentas;

import Clases.Cliente.Cuenta;

/**
 * Archivo: Debito.java
 * package Clases.Cuentas
 * La clase Debito se extiende de la clase Cuenta y representa una cuenta de débito o básica,
 * iniializando el monto de la cuenta.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Debito extends Cuenta {
    public Debito(double monto){
        super(monto);
    }

    /**
     * Método toString que retorna el saldo de la cuenta de débito
     * @return Detalles de la cuenta de débito como una cadena de texto.
     */
    public String toString(){
        return "Saldo en la cuenta: "+getSaldo();
    }
}
