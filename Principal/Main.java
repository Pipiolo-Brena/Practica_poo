package Principal;

import java.util.Scanner;

import Clases.Banco.Banco;
import Metodos.metodos;

/**
 * Archivo: Main.java
 * package Principal
 * La Clase Main contiene el método principal engloba la gestión bancaria.
 * El programa permite registrar nuevos clientes, modificar sus datos, realizar operaciones 
 * en sus cuentas y consultar información del banco.
 * @author Equipo 5
 * @version 2024.09.22
 */

 
public class Main {


     /**
     * Constructor por defecto para la clase Main.
     */
    public Main() {
        // Constructor por defecto
    }

    /**
     * Método principal 'main' donde se ejecuta el ciclo principal del programa.
     * Aqui se interactúa con el usuario para seleccionar opciones del menú principal 
     * que facilita la gestión bancaria.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

         // Se crea un objeto de la clase Banco, que almacena los detalles del banco.
        Banco banco = new Banco("Los altos", "5536778827","L - S de 10 a 19", "CDMX","Miramontes", 8976, "Monterrey");
        
        Scanner entrada = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario.
        int op; // Variable para almacenar la opción del menú seleccionada por el usuario.
        
        // Ciclo do-while que controla el menú principal del programa.
        do{

            // Menú principal de opciones disponibles para la gestión del banco.
            System.out.println("""
            ----ADMINISTRADOR DE BANCO---
            1. Registrar Nuevo cliente 
            2. Ver información de cliente  
            3. Modificar datos de cliente
            4. Operaciones de caja
            5. Datos de Banco
            6. Salir
            Ingresa tu opción deseada
            """);
            op = entrada.nextInt();  // Lee la opción seleccionada por el usuario.
            entrada.nextLine();  // Limpieza del buffer de entrada.

            // Estructura switch para manejar las opciones del menú.
            switch (op) {

                // Opción 1: Registro de nuevo cliente en el banco utilizando el método 'nuevoCliente'.
                case 1 -> {
                    metodos.nuevoCliente(banco);
                }

                // Opción 2: Ver la información de un cliente dado.
                case 2-> {
                    System.out.println("Ingresa el número de cliente para ver la información");
                    String numCliente=entrada.nextLine();
                    metodos.infoCliente(banco,numCliente);

                }   

                // Opción 3: Para modificar los datos de un cliente existente.
                case 3-> {
                    System.out.println("Ingresa el número de cliente para ver la información");
                    String numCliente=entrada.nextLine();
                    metodos.modificarCliente(banco, numCliente);

                }

                // Opción 4: Realizar operaciones bancarias como depósitos o retiros.
                case 4-> {
                    System.out.println("Ingresa el número de cliente");
                    String numCliente = entrada.nextLine();
                    numCliente = numCliente.replaceAll("[^0-9]", "");
                    if(banco.buscarCliente(numCliente) != null)  // Se agregó este control por si el número de usuario de cliente no se encuentra.
                        metodos.operaciones(banco, numCliente);
                    else
                        System.out.println("Cliente no encontrado.\n");
                }

                // Opción 5: Muestra la información del banco.
                case 5-> {
                    System.out.println(banco);

                }
        
                // Opción 6: Salir del programa y mostrar un mensaje de despedida.
                case 6 -> System.out.println("¡Gracias por usar el programa! Hasta luego. \n Nos ubicamos en "+banco.getDireccion());
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }while(op!=6);  // El ciclo se repite hasta que el usuario selecciona la opción para salir (número 6).
        entrada.close();   // Se cierra el objeto Scanner al finalizar el programa.
    }
}
