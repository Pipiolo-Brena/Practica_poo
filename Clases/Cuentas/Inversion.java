package Clases.Cuentas;

import Clases.Cliente.Cuenta;

public class Inversion extends Cuenta {
    private double rendimiento;
    private int meses;

    public  Inversion(double saldo, int meses){
        super(saldo);
        this.meses=meses;
        this.rendimiento=calcularRendimiento(meses);

    }

    private double calcularRendimiento(int meses){
        return meses<3?0.2:meses>3&meses<8?0.25:0.35;
    }

    public String toString(){
        return "Inversion: "+ getSaldo()+"\\n"+
                "Rendimiento: "+rendimiento+"\\n"+
                "Tiempo de inversion en meses: "+meses;
    }
}
