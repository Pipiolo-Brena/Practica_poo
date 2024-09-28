package Clases.Cuentas;

import Clases.Cliente.Cuenta;

/**
 * Archivo: Inversion.java
 * package Clases.Cuentas
 * La clase Inversión se extiende de la clase Cuenta y representa una cuenta de inversión 
 * con rendimiento a plazos según los meses seleccionados.
 * Esta clase gestiona los detalles de una cuenta de inversión.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Inversion extends Cuenta {
    private double rendimiento;
    private int meses;

    /**
     * Constructor de la clase Inversion.
     * Inicializa la cuenta de iversión según el saldo de la cuenta.
     * @param saldo Saldo inicial que entra a plazo determinado.
     * @param meses Plazo en meses, según el rendimiento que se espera obtener.
     */
    public Inversion(double saldo, int meses){
        super(saldo);
        this.meses=meses;
        this.rendimiento=calcularRendimiento(meses);

    }

    /**
     * Método propio que calcula el rendimiento de la inversión en función del plazo seleccionado.
     * @param meses Plazo en meses que se somete el monto a inversión.
     * @return rendimiento Tendimiento obtenido según los meses.
     */
    private double calcularRendimiento(int meses){
        return (meses < 3) ? 0.2 : ((meses > 3) && (meses < 8)) ? 0.25 : 0.35;
    }

    /**
     * Método toString que retorna la información de la cuenta de inversión,
     * como el saldo con el que se apertura la cuenta, rendimiento y plazo en meses.
     * @return Detalles de la cuenta de inversión como una cadena de texto.
     */
    public String toString(){
        return "Inversión: " +getSaldo()+"\n"+
                "Rendimiento: "+rendimiento+"\n"+
                "Tiempo de inversión en meses: "+meses;
    }
}
