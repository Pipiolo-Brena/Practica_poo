package Principal;
/**
 * Main
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int op;
        do{
            System.out.println("""
            ----Administrador de computadoras---
            1. Crear computadora nueva 
            2. Modificar existente 
            3. Ver computadoras actuales 
            4. Eliminar computadora 
            5. Salir
            Ingresa tu opcion deseadafnfnfn
            """);
            op=entrada.nextInt();

            switch (op) {
                case 1 -> {
                }
                case 2-> {
                }   
                case 3-> {
                }
                case 4-> {


                }
        
                case 5 -> System.out.println("¡Gracias por usar el programa! Hasta luego.");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }while(op!=5);
        entrada.close();
    }
}