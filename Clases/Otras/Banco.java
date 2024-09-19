package  Clases.Otras;
import java.util.HashMap;
import java.util.Collections;
import java.util.Set;

import Clases.Usuarios.Cliente;

public class Banco {
    private String nombre;
    private String telefono;
    private String horario;
    private Direccion direccion;
    private HashMap<Set<Integer>,Cliente> clientes;

    public Banco(String nombre, String telefono, String horario,String municipio, String colonia, int codigoPostal, String calle) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.direccion = new Direccion(municipio, colonia, codigoPostal, calle); //Se corrige y se inicializa la dirección
        this.clientes = new HashMap<Set<Integer>,Cliente>();//objetos clientes
        
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
    public void registrarCliente(int numCliente,String nombre,String aPaterno,String aMaterno,String direccion,int telefono){
        Set<Integer> set = Collections.singleton(numCliente);//Pasa de ser un int a ser un set Integer
        Cliente cliente= new Cliente(set, nombre,aPaterno,  aMaterno,direccion,telefono);
        agregarCliente(set, cliente);
    }

    public void agregarCliente(Set<Integer> numCliente, Cliente cliente) {
        clientes.put(numCliente,cliente);
    }

    public Cliente getClientes(Set<Integer> llave) {
        return clientes.get(llave);
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
