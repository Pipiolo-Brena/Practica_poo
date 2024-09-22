
package Clases.Banco;
public class Direccion{
    private String municipio;
    private String colonia;
    private int codigoPostal;
    private String calle;

    //constructor
    public Direccion(String municipio, String colonia, int codigoPostal, String calle){
        this.municipio = municipio;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        
    }

    public void setMunicipio(String municipio){
        this.municipio=municipio;
    }

    public String getMunicipio(){
        return municipio;
    }

    public void setColonia(String colonia){
        this.colonia=colonia;
    }

    public String getColonia(){
        return colonia;
    }

    public void setCodigoPostal(int codigoPostal){
        this.codigoPostal=codigoPostal;
    }

    public int getCodigoPostal(){
        return codigoPostal;
    }

    public void setCalle(String calle){
        this.calle=calle;
    }

    public String getCalle(){
        return calle;
    }

    public String toString(){
        return calle+", "+colonia+", "+municipio+", "+codigoPostal;
    }
}