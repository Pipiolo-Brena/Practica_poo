package Metodos;
import java.util.Scanner;

import Clases.Banco.Banco;
import Clases.Banco.Cliente;
/**
 * metodos
 */

 /* */
public class metodos {

    public static void  nuevoCliente(Banco banco){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Número de cliente: ");
        Integer numCliente = scanner.nextInt();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido Paterno: ");
        String aPaterno = scanner.nextLine();
        System.out.print("Apellido Materno: ");
        String aMaterno = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        int telefono = scanner.nextInt();

        banco.registrarCliente(numCliente, nombre, aPaterno, aMaterno, direccion, telefono);

    }

    public static void  operaciones(){
        
    }

   public static void infoCliente(Banco banco,int numCliente){
        Cliente cliente = banco.buscarCliente(numCliente);
        if (cliente != null){
            System.out.println(cliente);
        }else{
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void modificarCliente(Banco banco, int numCliente){
        Scanner scanner = new Scanner(System.in);
        Cliente modificarCliente = banco.buscarCliente(numCliente);
        if (modificarCliente != null){
            System.out.print("Actualizar nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Actualizar Apellido Paterno: ");
            String nuevoAPaterno = scanner.nextLine();
            System.out.print("Acctualizar Apellido Materno: ");
            String nuevoAMaterno = scanner.nextLine();
            System.out.print("Actualizar dirección: ");
            String nuevaDireccion = scanner.nextLine();
            System.out.print("Actualizar teléfono: ");
            int nuevoTelefono = scanner.nextInt();

            modificarCliente.setNombre(nuevoNombre);
            modificarCliente.setAPaterno(nuevoAPaterno);
            modificarCliente.setAMaterno(nuevoAMaterno);
            modificarCliente.setDireccion(nuevaDireccion);
            modificarCliente.setTelefono(nuevoTelefono);
            System.out.println("Datos modificados con éxito.");
        }else{
            System.out.println("Cliente no encontrado.");
        }
    }


}