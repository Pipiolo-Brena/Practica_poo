package Clases.Cuentas;

import Clases.Cliente.Cuenta;

public class Credito extends Cuenta {
    private String numTarjeta;
    private  double limiteCredito;
    private final double creditoDisponible;

    public Credito(String numTarjeta, double limiteCredito){
        super(limiteCredito);
        this.numTarjeta = numTarjeta;
        this.limiteCredito = limiteCredito; 
        creditoDisponible = limiteCredito;
    }

    //getters - setters
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        setSaldo(limiteCredito); 
    }

    public double getCreditoDisponible() {
        return creditoDisponible;
    }
    
    public String toString() {
        return "Numero de Tarjeta de Crédito: " + numTarjeta + "\n"+
                "Límite de Crédito=" + limiteCredito+"\n"+
                "Crédito"+getSaldo();
    }

}

