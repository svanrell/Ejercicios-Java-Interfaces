import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        String[] tareas = {"Estudiar Java", "Preparar práctica", "Revisar ejercicios", "Subir proyecto"};

        System.out.println("Introduce el nombre de la tarea a buscar:");
        String texto = escaner.nextLine();
        escaner.close();

        int posicion = buscarTarea(tareas, texto);
        System.out.println(posicion);
    }

    public static int buscarTarea(String[] tareas, String texto) {
        int posicion = -1;
        for (int i = 0; i < tareas.length; i++) {
            if (texto.equalsIgnoreCase(tareas[i])) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
}
