public class Ejercicio4 {
    public static void main(String[] args) {
        String[] tareas = {"Estudiar Java", "Preparar práctica", "Revisar ejercicios", "Subir proyecto"};
        System.out.println(formatearTareas(tareas));
    }

    public static String formatearTareas(String[] tareas) {
        String resultado = "";
        for (int i = 0; i < tareas.length; i++) {
            resultado += (i + 1) + ". " + tareas[i] + "\n";
        }
        return resultado;
    }
}
