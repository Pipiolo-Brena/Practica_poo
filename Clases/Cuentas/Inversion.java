package Clases.Cuentas;

public class Inversion extends Cuenta {
    private int rendimiento;
    private double saldo;
    private int dias;

    public  Inversion(double saldo, int dias){
        super();
        this.saldo=saldo;
        this.dias=dias;
    }
}
