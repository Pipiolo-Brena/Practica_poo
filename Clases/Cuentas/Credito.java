package Clases.Cuentas;

import Clases.Cliente.Cuenta;

public class Credito extends Cuenta {
    private int numTarjeta;
    private double limiteCredito;

    public Credito(int numTarjeta, double limiteCredito){
        super(limiteCredito);
        this.numTarjeta = numTarjeta;
        this.limiteCredito = limiteCredito; 
    }

    //getters - setters
    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        setSaldo(limiteCredito); 
    }

    
    public String toString() {
        return "Numero de Tarjeta de Credito: " + numTarjeta + "\n"+
                "Limite de Credito=" + limiteCredito+"\\n"+
                "Credito"+getSaldo();
    }

}

