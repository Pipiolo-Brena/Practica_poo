package Metodos;
import java.util.Scanner;
import java.util.ArrayList;

import Clases.Banco.Banco;
import Clases.Cliente.Cliente;
import Clases.Cliente.Cuenta;
import Clases.Cuentas.Movimiento;

/**
 * Archivo: metodos.java
 * package Metodos
 * La clase metodos contiene una serie de métodos estáticos que proporcionan
 * funcionalidades para la creación y gestión de clientes, así como para realizar
 * operaciones en cuentas bancarias. Los métodos interactúan con las clases de clientes,
 * cuentas y movimientos, permitiendo gestionar la información en la administración del banco.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class metodos {
    public static Scanner scanner = new Scanner(System.in); // Se agregó el scanner como atributo static para poder utilizarlo en todos los métodos.
    
    /**
     * Método estático para crear un nuevo cliente en el banco.
     * Solicita al usuario los datos necesarios (nombre, apellidos, dirección, teléfono), 
     * para registrar un nuevo cliente y los envía al banco para su registro.
     * @param banco Objeto Banco en el cual se registrará el nuevo cliente.
     */
    public static void nuevoCliente(Banco banco){

        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Número de cliente: ");
        String numCliente = scanner.nextLine();
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

        banco.registrarCliente(numCliente, nombre, aPaterno, aMaterno, direccion, telefono); // Registra el cliente en el banco

    }

    /**
     * Método estático para realizar operaciones bancarias que un cliente pueda realizar.
     * Muestra un menú con diferentes opciones de operaciones bancaias,
     * gestionar cuentas de débito, inversión o crédito, y permite seleccionar la acción deseada.
     * @param banco Objeto Banco donde está registrado el cliente.
     * @param numCuenta Número de cuenta del cliente con el cual se realizarán las operaciones.
     */
    public static void  operaciones(Banco banco, String numCuenta){        
        Cliente cliente = banco.buscarCliente(numCuenta);
        int op;
        do{
            System.out.println("""
            ----OPERACIONES DE CLIENTE--
            1. Crear cuenta (Inversión, Crédito aplica en el supuesto que no tenga una o las dos)
            2. Cuenta de débito
            3. Cuenta de inversión
            4. Tarjeta de crédito
            5. Salir a menu general
            Ingresa tu opción deseada
            """);
            op=scanner.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese qué cuenta se desea adquirir (1- Inversión, 2- Crédito)");
                    int cuenta = scanner.nextInt();
                    if (cuenta == 1) {
                        if (!cliente.cuentaExiste("Inversión")) {
                            System.out.println("¿Cuál es el monto que desea transefirir de su cuenta de débito a la de inversion?");
                            int monto = scanner.nextInt();
                            System.out.println("¿A cuántos meses se desea ingresar la inversión?");
                            int diasInversion = scanner.nextInt();
                            System.out.println(cliente.abrirCuentaInversion(monto, diasInversion));
                        }else System.out.println("El cliente ya tiene una cuenta de inversión.");

                    }else if (cuenta == 2) {
                        System.out.println(cliente.abrirCuentaCredito());
                    }else System.out.println("No se recocnocio la opción.");

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

        }while(op != 5);
    }

    /**
     * Método estático que muestra la información de un cliente.
     * @param banco Objeto Banco donde está registrado el cliente.
     * @param numCliente Número de cliente cuya información se desea consultar.
     */
   public static void infoCliente(Banco banco,String numCliente){
        Cliente cliente = banco.buscarCliente(numCliente);
        if (cliente != null)
            System.out.println(cliente);
        else
            System.out.println("Cliente no encontrado.\n");
    }

    /**
     * Método estático que permite modificar los datos de un cliente.
     * Actualizar ya sea el nombre, apellidos, dirección o teléfono del cliente según lo requiera el dueño de los datos.
     * @param banco Objeto Banco donde está registrado el cliente.
     * @param numCliente Número de cliente cuya información se va a modificar.
     */
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

            // Actualiza los datos del cliente
            modificarCliente.setNombre(nuevoNombre); 
            modificarCliente.setAPaterno(nuevoAPaterno);
            modificarCliente.setAMaterno(nuevoAMaterno);
            modificarCliente.setDireccion(nuevaDireccion);
            modificarCliente.setTelefono(nuevoTelefono);
            System.out.println("Datos modificados con éxito.\n");
        }else{
            System.out.println("Cliente no encontrado.\n");
        }
    }


    /**
     * Método estático que permite realizar las operaciones sobre una cuenta de un cliente.
     * Se muestra un menú de operaciones que permte realizar operaciones como retirar dinero, 
     * depositar dinero, ver datos de la cuenta y movimientos.
     * @param cliente Cliente sobre el cual se realizarán las operaciones.
     * @param tipo Tipo de cuenta (Débito, Inversión, Crédito) sobre la que se realizarán las operaciones.
     */
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
                        double monto = scanner.nextInt();
                        System.out.println(cliente.retirarDinero(tipo, monto)); 
                    }
                    case 2-> {
                        System.out.println("¿Cuál es el monto que desea depositar a su cuenta?");
                        double monto = scanner.nextInt();
                        System.out.println(cliente.depositarDinero(tipo, monto)); 
                    } 
                    case 3-> {
                        System.out.println(cuenta);
                    }  
                    case 4-> {
                        ArrayList<Movimiento> movimientos = cuenta.getMovimientos();
                        for (Movimiento movimiento : movimientos) {
                            System.out.println(movimiento);
                        }
                    }
                    case 5-> System.out.println("Saliendo de cuenta de "+tipo.toLowerCase()+"...\n");
                    default -> System.out.println("Opción inválida.\n");
                }
            }while(op!=5);
        }else System.out.println("El cliente no tiene cuenta de "+tipo.toLowerCase()+".\n");
    }
    

}