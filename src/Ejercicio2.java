import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        System.out.println("Introduce el precio de un producto: ");
        float precio = escaner.nextFloat();

        System.out.println("Introduce la cantidad del producto:");
        int cantidad = escaner.nextInt();

        System.out.println("Introduce el porcentaje de descuento:");
        int porcentaje = escaner.nextInt();

        escaner.close();

        float subtotal = calcularSubtotal(precio, cantidad);
        float descuento = calcularDescuento(subtotal, porcentaje);
        float total = calcularTotal(subtotal, descuento);

        System.out.println("Subtotal: " + subtotal + " €");
        System.out.println("Descuento: " + descuento + " €");
        System.out.println("Total: " + total + " €");
    }

    public static float calcularSubtotal(float precio, int cantidad) {
        return precio * cantidad;
    }

    public static float calcularDescuento(float subtotal, int porcentaje) {
        return subtotal * ((float) porcentaje / 100);
    }

    public static float calcularTotal(float subtotal, float descuento) {
        return subtotal - descuento;
    }
}
