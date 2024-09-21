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

    public static void  operaciones(Banco banco, int numCuenta){        
        Scanner entrada = new Scanner(System.in);
        Cliente cliente= banco.buscarCliente(numCuenta);
        int op;
        do{
            System.out.println("""
            ----Operaciones de la cuenta---
            1. Crear cuenta(Inversion, Credito aplica en el supuesto que no tenga una o las dos)
            2. Cienta de debito
            3. Cuenta de inversion
            4. Tarjeta de credito
            5. Salir a menu general
            Ingresa tu opcion deseada
            """);
            op=entrada.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese que cuenta se desea adquirir(1- Inversion,2-Credito)");
                    int cuenta=entrada.nextInt();
                    if (cuenta==1) {
                        if (!cliente.cuentaExiste("Inversion")) {
                            System.out.println("¿Cual es el monto que desea transefirir de su cuenta de debito a la de inversion?");
                            int monto=entrada.nextInt();
                            System.out.println("¿A cuentos meses se desea ingresar la inversion?");
                            int diasInversion=entrada.nextInt();
                            cliente.abrirCuentaInversion(monto, diasInversion);
                        }else System.out.println("El cliente ya tiene una cuenta de inversion");

                    }else if (cuenta==2) {
                        System.out.println(cliente.abrirCuentaCredito());
                    } else System.out.println("No se recocnocio la opcion");

                }
                case 2-> {
                    operacionesCuenta(cliente, "Debito");
                }   
                case 3-> {
                    operacionesCuenta(cliente, "Inversion");

                }
                case 4-> {
                    operacionesCuenta(cliente, "Credito");
                }
        
                case 6 -> System.out.println("¡Gracias por usar el programa! Hasta luego.");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }while(op!=6);
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


    public static void operacionesCuenta(Cliente cliente,String tipo){
        Scanner entrada= new Scanner(System.in);
        if(cliente.cuentaExiste(tipo)){
            Cuenta cuenta = cliente.getCuenta(tipo);
            System.out.println("""
            ----Operaciones Generales de cuenta---
            1. Retirar Dinero
            2. Depositar dinero 
            3. Ver datos de cuenta
            4. Ver movimientos
            Ingresa tu opcion deseada
            """);
            int op=entrada.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("¿Cual es el monto que desea retirar de su cuenta?");
                    double monto=entrada.nextInt();
                    System.out.println(cliente.retirarDinero(tipo, monto)); 
                    cuenta.agregarMovimiento(new Movimiento(monto, "Retiro de dinero"));
                }
                case 2-> {
                    System.out.println("¿Cual es el monto que desea depositar a su cuenta?");
                    double monto=entrada.nextInt();
                    System.out.println(cliente.depositarDinero(tipo, monto)); 
                    cuenta.agregarMovimiento(new Movimiento(monto, "Deposito de dinero"));
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
                default -> System.out.println("Opción inválida");
            }
        }else System.out.println("El clinte no tiene cuanta de "+ tipo);
    }

}