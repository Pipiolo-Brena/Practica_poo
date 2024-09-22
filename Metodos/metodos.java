package Metodos;
import java.util.Scanner;
import java.util.ArrayList;

import Clases.Banco.Banco;
import Clases.Cliente.Cliente;
import Clases.Cliente.Cuenta;
import Clases.Cuentas.Movimiento;
/**
 * metodos
 */
public class metodos {
    public static Scanner scanner = new Scanner(System.in);//Se agregó el scanner como atributo static para poder utilizarlos en todos los métodos
    public static void  nuevoCliente(Banco banco){

        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Número de cliente: ");
        String numCliente = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido Paterno: ");
        String aPaterno = scanner.nextLine();
        System.out.print("Apellido Materno: ");
        String aMaterno = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        banco.registrarCliente(numCliente, nombre, aPaterno, aMaterno, direccion, telefono);

    }

    public static void  operaciones(Banco banco, String numCuenta){        
        Cliente cliente= banco.buscarCliente(numCuenta);
        int op;
        do{
            System.out.println("""
            ----OPERACIONES DE CLIENTE--
            1. Crear cuenta(Inversión, Crédito aplica en el supuesto que no tenga una o las dos)
            2. Cuenta de débito
            3. Cuenta de inversión
            4. Tarjeta de crédito
            5. Salir a menu general
            Ingresa tu opción deseada
            """);
            op=scanner.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese que cuenta se desea adquirir(1- Inversión,2-Crédito)");
                    int cuenta=scanner.nextInt();
                    if (cuenta==1) {
                        if (!cliente.cuentaExiste("Inversión")) {
                            System.out.println("¿Cuál es el monto que desea transefirir de su cuenta de débito a la de inversion?");
                            int monto=scanner.nextInt();
                            System.out.println("¿A cuántos meses se desea ingresar la inversión?");
                            int diasInversion=scanner.nextInt();
                            System.out.println(cliente.abrirCuentaInversion(monto, diasInversion));
                        }else System.out.println("El cliente ya tiene una cuenta de inversión");

                    }else if (cuenta==2) {
                        System.out.println(cliente.abrirCuentaCredito());
                    } else System.out.println("No se recocnocio la opción");

                }
                case 2-> {
                    operacionesCuenta(cliente, "Débito");
                }   
                case 3-> {
                    operacionesCuenta(cliente, "Inversión");

                }
                case 4-> {
                    operacionesCuenta(cliente, "Crédito");
                }
        
                case 5 -> System.out.println("¡Gracias por usar el programa! Hasta luego.\n");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.\n");
            }

        }while(op!=5);
    }

   public static void infoCliente(Banco banco,String numCliente){
        Cliente cliente = banco.buscarCliente(numCliente);
        if (cliente != null)
            System.out.println(cliente);
        else
            System.out.println("Cliente no encontrado.");
    }

    public static void modificarCliente(Banco banco, String numCliente){
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
            String nuevoTelefono = scanner.nextLine();

            modificarCliente.setNombre(nuevoNombre);
            modificarCliente.setAPaterno(nuevoAPaterno);
            modificarCliente.setAMaterno(nuevoAMaterno);
            modificarCliente.setDireccion(nuevaDireccion);
            modificarCliente.setTelefono(nuevoTelefono);
            System.out.println("Datos modificados con éxito. \n");
        }else{
            System.out.println("Cliente no encontrado.\n");
        }
    }


    public static void operacionesCuenta(Cliente cliente,String tipo){
        int op;
        if(cliente.cuentaExiste(tipo)){
            do{
                Cuenta cuenta = cliente.getCuenta(tipo);
                System.out.println("""
                ----OPERACIONES DE CUENTA---
                1. Retirar Dinero
                2. Depositar dinero 
                3. Ver datos de cuenta
                4. Ver movimientos
                5. Salir de cuenta
                Ingresa tu opción deseada
                """);
                op=scanner.nextInt();

                switch (op) {
                    case 1 -> {
                        System.out.println("¿Cuál es el monto que desea retirar de su cuenta?");
                        double monto=scanner.nextInt();
                        System.out.println(cliente.retirarDinero(tipo, monto)); 
                    }
                    case 2-> {
                        System.out.println("¿Cuál es el monto que desea depositar a su cuenta?");
                        double monto=scanner.nextInt();
                        System.out.println(cliente.depositarDinero(tipo, monto)); 
                    } 
                    case 3-> {
                        System.out.println(cuenta);
                    }  
                    case 4-> {
                        ArrayList<Movimiento> movimientos= cuenta.getMovimientos();
                        for (Movimiento movimiento : movimientos) {
                            System.out.println(movimiento);
                        }
                    }
                    case 5-> System.out.println("Saliendo de cuenta de "+tipo.toLowerCase()+"\n");
                    default -> System.out.println("Opción inválida\n");
                }
            }while(op!=5);
        }else System.out.println("El cliente no tiene cuanta de "+ tipo.toLowerCase()+"\n");
    }
    

}