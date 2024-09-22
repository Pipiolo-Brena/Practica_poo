package  Clases.Banco;
import java.util.HashMap;

import Clases.Cliente.Cliente;


public class Banco {
    private String nombre;
    private String telefono;
    private String horario;
    private Direccion direccion;
    private HashMap<String,Cliente> clientes;

    public Banco(String nombre, String telefono, String horario,String municipio, String colonia, int codigoPostal, String calle) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.direccion = new Direccion(municipio, colonia, codigoPostal, calle); //Se inicializa la dirección
        this.clientes = new HashMap<String,Cliente>();//objetos clientes
        
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
    public void registrarCliente(String numCliente,String nombre,String aPaterno,String aMaterno,String direccion,String telefono){
        Cliente cliente= new Cliente(numCliente, nombre,aPaterno,  aMaterno,direccion,telefono);
        agregarCliente(numCliente, cliente);
        System.out.println("Registro exitoso.");
    }

    public void agregarCliente(String numCliente, Cliente cliente) {
        clientes.put(numCliente,cliente);
    }

    public Cliente buscarCliente(String llave) {
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
        return "Banco: " + nombre + "\n"+
                "Teléfono: " + telefono + "\n"+
                "Horario: " + horario + "\n"+
                "Dirección: " + direccion.toString()+"\n"+
                "Nùmero de clientes en nuestra sucursal: "+Cliente.getContadorClientes()+"\n";
    }
}
