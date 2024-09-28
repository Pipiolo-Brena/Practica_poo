package Clases.Cuentas;

import Clases.Cliente.Cuenta;

/**
 * Archivo: Credito.java
 * package Clases.Cuentas
 * La clase Credito se extiende de la clase Cuenta y representa una cuenta de tarjeta de crédito
 * con un número de tarjeta, un límite de crédito y un crédito disponible.
 * Esta clase gestiona los detalles de la tarjeta de crédito de un cliente.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Credito extends Cuenta {
    private String numTarjeta;
    private  double limiteCredito;
    private final double creditoDisponible;

    /**
     * Constructor de la clase Credito.
     * Inicializa una nueva tarjeta de crédito con un número de tarjeta y un límite de crédito.
     * La clase padre 'Cuenta' también es inicializada con el límite de crédito como saldo inicial.
     * @param numTarjeta Número de la tarjeta de crédito.
     * @param limiteCredito Límite de crédito asignado a la tarjeta.
     */
    public Credito(String numTarjeta, double limiteCredito){
        super(limiteCredito);
        this.numTarjeta = numTarjeta;
        this.limiteCredito = limiteCredito; 
        creditoDisponible = limiteCredito;
    }

    // Getters y setters para los atributos la classe Credito.

    /**
     * Método para obtener el número de tarjeta de crédito.
     * @return El número de la tarjeta de crédito.
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Método para establecer un nuevo número de tarjeta de crédito.
     * @param numTarjeta El nuevo número de tarjeta.
     */
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    /**
     * Método para obtiene el límite de crédito de la tarjeta.
     * @return El límite de crédito asignado.
     */
    public double getLimiteCredito() {
        return limiteCredito;
    }

    /**
     * Método para establecer un nuevo límite de crédito para la tarjeta.
     * También actualiza el saldo de la cuenta a este nuevo límite.
     * @param limiteCredito El nuevo límite de crédito.
     */
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        setSaldo(limiteCredito); 
    }

    /**
     * Método para obtiene el crédito disponible de la tarjeta.
     * @return El crédito total disponible inicialmente.
     */
    public double getCreditoDisponible() {
        return creditoDisponible;
    }
    
    /**
     * Método toString que retorna los detalles de la tarjeta de crédito.
     * Incluye el número de tarjeta, el límite de crédito y el saldo disponible actual.
     * @return Detalles de la tarjeta de crédito como una cadena de texto.
     */
    public String toString() {
        return "Numero de Tarjeta de Crédito: "+numTarjeta+"\n"+
                "Límite de Crédito: "+limiteCredito+"\n"+
                "Crédito disponible: "+getSaldo();
    }

}

