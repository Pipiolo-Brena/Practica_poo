package Clases.Cuentas;

import Clases.Cliente.Cuenta;

public class Debito extends Cuenta {
    public Debito(double monto){
        super(monto);
    }

    public String toString(){
        return "Saldo en la cuenta"+getSaldo();
    }
}
