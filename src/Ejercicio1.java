import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        System.out.println("Escribe tu nombre:");
        String nombre = escaner.nextLine();

        System.out.println("Escribe tu edad:");
        if (escaner.hasNextInt()) {
            int edad = escaner.nextInt();
            System.out.println("Hola, " + nombre + ". Tienes " + edad + " años.");
            System.out.println("Dentro de 5 años tendrás " + (edad + 5) + " años.");
        } else {
            System.out.println("La edad introducida no es válida.");
        }

        escaner.close();
    }
}