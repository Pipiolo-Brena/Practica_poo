package Metodos;
import java.util.Scanner;

import Clases.Banco.Banco;
/**
 * metodos
 */

 /* */
public class metodos {

    public static void  nuevoCliente(Banco banco){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Número de cliente: ");
        int numCliente = scanner.nextInt();
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

    public static void  infoCliente(){

    }

    public static void modificarDatos(){

    }


}