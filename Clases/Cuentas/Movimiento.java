package Clases.Cuentas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Archivo: Movimiento.java
 * package Clases.Cuentas
 * La clase Movimiento representa una transacción realizada en una cuenta bancaria.
 * Cada movimiento contiene información sobre la cantidad de dinero, el tipo de movimiento 
 * (depósito o retiro), y la fecha en la se dio la operación bancaria.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Movimiento {
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' hh:mm:ss a");  // Define el formato que tendrá el atributo, el cuál mostrará la fecha del movimiento.
    private LocalDateTime fecha;    // Atributo que almacena la fecha y hora en la que se realizó el movimiento.
    private double cantidad;    // Atributo que almacena la cantidad de dinero involucrada en el movimiento.
    private String tipo;    // Atributo que almacena el tipo de movimiento ("Depósito", "Retiro")
    
    /**
     * Constructor Movimiento
     * Crea un objeto Movimiento con una cantidad y un tipo de operación, usando la fecha y hora actuales.
     * @param cantidad La cantidad de dinero involucrada en el movimiento.
     * @param tipo El tipo de movimiento (depósito o retiro).
     */
    public Movimiento(double cantidad, String tipo){
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    /**
     * Constructor 2, Movimiento sin cantidad.
     * Crea un objeto Movimiento solo con el tipo de operación, usando la fecha y hora actuales.
     * Este constructor puede ser utilizado para operaciones que no involucran cantidades específicas, 
     * como la apertura de cuenta.
     * @param tipo El tipo de movimiento.
     */
    public Movimiento(String tipo){
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    /**
     * Constructor 3, Movimiento, con fecha personalizada.
     * Crea un objeto Movimiento con una cantidad, un tipo de operación, una fecha y hora específicas.
     * Este constructor permite establecer movimientos con fechas específicas.
     * @param cantidad La cantidad de dinero involucrada en el movimiento.
     * @param tipo El tipo de movimiento.
     * @param dia El día del movimiento.
     * @param mes El mes del movimiento.
     * @param año El año del movimiento.
     * @param hora La hora del movimiento.
     * @param minuto El minuto del movimiento.
     */
    public Movimiento(double cantidad, String tipo,int dia, int mes, int año, int hora, int  minuto){
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.of(año, mes, dia, hora, minuto, 0);
    }

    /**
     * Método toString que retorna la información de la cuenta de los movimientos bancarios,
     * como el de cuenta, cantidad y fecha de apertura
     * @return Detalles del movimiento como una cadena de texto.
     */
    public String toString() {
        return "Tipo: "+tipo+"\n"+ 
                "Cantidad: "+cantidad+"\t Fecha : "+fecha.format(formatoFecha);
    }
}