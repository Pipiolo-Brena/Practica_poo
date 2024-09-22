package Principal;
/**
 * Main
 */
import java.util.Scanner;


import Clases.Banco.Banco;
import Metodos.metodos;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Los altos", "5536778827","L - S de 10 a 19", "CDMX","Miramontes", 8976, "Monterrey");
        
        Scanner entrada = new Scanner(System.in);
        int op;
        do{
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
            op=entrada.nextInt();

            switch (op) {
                case 1 -> {
                    metodos.nuevoCliente(banco);
                }
                case 2-> {
                    System.out.println("Ingresa el número de cliente para ver la información");
                    String numCliente=entrada.nextLine();
                    metodos.infoCliente(banco,numCliente);

                }   
                case 3-> {
                    System.out.println("Ingresa el número de cliente para ver la información");
                    String numCliente=entrada.nextLine();
                    metodos.modificarCliente(banco, numCliente);

                }
                case 4-> {
                    System.out.println("Ingresa el número de cliente");
                    String numCliente=entrada.nextLine();
                    numCliente = numCliente.replaceAll("[^0-9]", "");
                    if(banco.buscarCliente(numCliente) != null)  //Se agregó este control por si el número de usuario de cliente no se encuentra
                        metodos.operaciones(banco, numCliente);
                    else
                        System.out.println("Cliente no encontrado.\n");
                }

                case 5-> {
                    System.out.println(banco);

                }
        
                case 6 -> System.out.println("¡Gracias por usar el programa! Hasta luego. \n Nos ubicamos en "+banco.getDireccion());
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }while(op!=6);
        entrada.close();
    }
}