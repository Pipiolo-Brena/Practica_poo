package Principal;
/**
 * Main
 */
import java.util.Scanner;
import java.util.Set;
import java.util.Hashtable;

import Clases.Otras.Banco;
import Clases.Usuarios.Cliente;
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
                    metodos.modificarDatos();

                }   
                case 3-> {
                    metodos.infoCliente();

                }
                case 4-> {
                    metodos.operaciones();

                }
        
                case 5 -> System.out.println("¡Gracias por usar el programa! Hasta luego.");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }while(op!=5);
        entrada.close();
    }
}