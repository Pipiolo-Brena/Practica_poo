package  Clases.Otras;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import Clases.Usuarios.Cliente;

public class Banco {
    private String nombre;
    private String telefono;
    private String horario;
    private Direccion direccion;
    private Hashtable<Set<Integer>,Cliente> clientes;

    public Banco(String nombre, String telefono, String horario,String municipio, String colonia, int codigoPostal, String calle) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.direccion = new Direccion(municipio, colonia, codigoPostal, calle); //Se corrige y se inicializa la dirección
        this.clientes = new Hashtable<Set<Integer>,Cliente>();//objetos clientes
        
    }

    public void setDireccion(String municipio, String colonia, int codigoPostal, String calle){
        this.direccion.setMunicipio(municipio);
        this.direccion.setColonia(colonia);
        this.direccion.setCodigoPostal(codigoPostal);
        this.direccion.setCalle(calle);
    }

    public Direccion getDireccion(){
        return direccion;
    }

    //Corresponde a clientes
    public void agregarCliente(Integer llave, Cliente cliente) {
        clientes.put(llave, cliente);
    }

    public Cliente getClientes(Set<Integer> llave) {
        clientes.get(llave);
    }

    //getters-setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String toString() {
        return "Librería: " + nombre + "\nTeléfono: " + telefono + "\nHorario: " + horario + "\nDirección: " + direccion.toString();
    }
}
