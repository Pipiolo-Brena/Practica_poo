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
            ----Administrador de computadoras---
            1. Registrar Nuevo cliente 
            2. Ver información de cliente  
            3. Modificar datos de cliente
            4. Operaciones de caja
            5. Salir
            Ingresa tu opcion deseadafnfnfn
            """);
            op=entrada.nextInt();

            switch (op) {
                case 1 -> {
                    metodos.nuevoCliente(banco);
                }
                case 2-> {
                    System.out.println("Ingresa el numero de cliente para ver la informacion");
                    int numCliente=entrada.nextInt();
                    metodos.infoCliente(banco,numCliente);

                }   
                case 3-> {
                    System.out.println("Ingresa el numero de cliente para ver la informacion");
                    int numCliente=entrada.nextInt();
                    metodos.modificarCliente(banco, numCliente);

                }
                case 4-> {
                    System.out.println("Ingresa el numero de cliente");
                    int numCliente=entrada.nextInt();
                    metodos.operaciones(banco, numCliente);

                }
        
                case 5 -> System.out.println("¡Gracias por usar el programa! Hasta luego.");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }while(op!=5);
        entrada.close();
    }
}