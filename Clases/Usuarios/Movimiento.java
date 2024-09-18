package Clases.Usuarios;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Movimiento
 */
public class Movimiento {
    private LocalDateTime fecha;
    private int cantidad;
    private String tipo;
    
    public Movimiento(int cantidad, String tipo){
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha= LocalDateTime.now();
    }

    public Movimiento(int cantidad, String tipo,int dia, int mes, int año, int hora, int  minuto){
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha= LocalDateTime.of(año, mes, dia, hora, minuto, 0);
    }

    public String toString() {
        return "Tipo: " + tipo + "\n Cantidad: " + cantidad + "\t Fecha : "+ fecha;
    }
}