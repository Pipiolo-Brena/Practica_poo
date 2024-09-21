package Clases.Cuentas;
import java.time.LocalDateTime;
/**
 * Movimiento
 */
public class Movimiento {
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
        return "Tipo: " + tipo + "\n"+ "Cantidad: " + cantidad + "\t Fecha : "+ fecha;
    }
}