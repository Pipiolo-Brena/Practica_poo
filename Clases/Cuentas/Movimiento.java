package Clases.Cuentas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Movimiento
 */
public class Movimiento {
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' hh:mm:ss a");
    private LocalDateTime fecha;
    private double cantidad;
    private String tipo;
    
    public Movimiento(double cantidad, String tipo){
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha= LocalDateTime.now();
    }

    public Movimiento(String tipo){
        this.tipo=tipo;
        this.fecha= LocalDateTime.now();
    }

    public Movimiento(double cantidad, String tipo,int dia, int mes, int año, int hora, int  minuto){
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha= LocalDateTime.of(año, mes, dia, hora, minuto, 0);
    }

    public String toString() {
        return "Tipo: " + tipo + "\n"+ 
                "Cantidad: " + cantidad + "\t Fecha : "+ fecha.format(formatoFecha);
    }
}