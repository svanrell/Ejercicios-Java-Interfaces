import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Introduce un número entre 1 y 3:");

        if (escaner.hasNextInt()) {
            int numero = escaner.nextInt();
            System.out.println(calcularPrioridad(numero));
        } else {
            System.out.println("La prioridad no es válida");
        }

        escaner.close();
    }

    public static String calcularPrioridad(int numero) {
        switch (numero) {
            case 1:
                return "1: Prioridad baja.";
            case 2:
                return "2: Prioridad media.";
            case 3:
                return "3: Prioridad alta.";
            default:
                return "La prioridad no es válida";
        }
    }
}
