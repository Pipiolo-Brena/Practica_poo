
package Clases.Banco;

/**
 * Archivo: Dirección.java
 * package Clases.Banco
 * La clase Direccion representa la información de la dirección del banco,
 * con los atributos: municipio, colonia, código postal y calle.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Direccion{
    private String municipio;
    private String colonia;
    private int codigoPostal;
    private String calle;

    /**
     * Constructor de la clase Direccion.
     * Inicializa los atributos de la clase con los valores proporcionados.
     * @param municipio Municipio de la dirección.
     * @param colonia Colonia de la dirección.
     * @param codigoPostal Código postal de la dirección.
     * @param calle Calle de la dirección.
     */
    public Direccion(String municipio, String colonia, int codigoPostal, String calle){
        this.municipio = municipio;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        
    }

    // Getters y setters para los atributos la classe Direccion.


    /**
     * Establece un nuevo valor para el municipio.
     * @param municipio Nuevo nombre del municipio.
     */
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }

    /**
     * Retorna el municipio de la dirección.
     * @return Municipio de la dirección.
     */
    public String getMunicipio(){
        return municipio;
    }

    /**
     * Establece un nuevo valor para la colonia.
     * @param colonia Nueva colonia de la dirección.
     */
    public void setColonia(String colonia){
        this.colonia = colonia;
    }

    /**
     * Retorna la colonia de la dirección.
     * @return Colonia de la dirección.
     */
    public String getColonia(){
        return colonia;
    }

    /**
     * Establece un nuevo valor para el código postal.
     * @param codigoPostal Nuevo código postal.
     */
    public void setCodigoPostal(int codigoPostal){
        this.codigoPostal = codigoPostal;
    }

    /**
     * Retorna el código postal de la dirección.
     * @return Código postal de la dirección.
     */
    public int getCodigoPostal(){
        return codigoPostal;
    }

    /**
     * Establece un nuevo valor para la calle.
     * @param calle Nueva calle de la dirección.
     */
    public void setCalle(String calle){
        this.calle = calle;
    }

    /**
     * Retorna la calle de la dirección.
     * @return Calle de la dirección.
     */
    public String getCalle(){
        return calle;
    }

    /**
     * Método toString que devuelve una cadena con la información de la dirección,
     * mostrando calle, colonia, municipio y código postal.
     * @return Cadena con la información completa de la dirección.
     */
    public String toString(){
        return calle+", "+colonia+", "+municipio+", "+codigoPostal;
    }
}