import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
    static class Tarea {
        private String titulo;
        private String descripcion;
        private boolean completada;

        public Tarea(String titulo, String descripcion, boolean completada) {
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.completada = completada;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public boolean getCompletada() {
            return completada;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setCompletada(boolean completada) {
            this.completada = completada;
        }

        @Override
        public String toString() {
            return "Tarea: " + titulo + " | Descripción: " + descripcion + " | Completada: " + completada;
        }
    }

    public static void main(String[] args) {
        Tarea tarea1 = new Tarea("Estudiar Java", "Aprender POO y métodos", true);
        Tarea tarea2 = new Tarea("Preparar práctica", "Realizar ejercicios de DDI", false);
        Tarea tarea3 = new Tarea("Subir proyecto", "Subir repositorio a Git", false);
        Tarea tarea4 = new Tarea("Estudiar Java", "Aprender POO y métodos", true);
        Tarea tarea5 = new Tarea("Preparar práctica", "Realizar ejercicios de DDI", false);

        ArrayList<Tarea> listaTareas = new ArrayList<>(List.of(tarea1, tarea2, tarea3, tarea4, tarea5));
        mostrarTareas(listaTareas);
        borrarTarea(listaTareas, 2);
        mostrarTareas(listaTareas);
    }

    public static void mostrarTareas(ArrayList<Tarea> listaTareas) {
        int contador = 0;
        for (Tarea tarea : listaTareas) {
            System.out.println(contador + ":" +tarea);
            contador += 1;
        }
    }

    public static ArrayList<Tarea> borrarTarea(ArrayList<Tarea> listaTareas, int posicion){
        try {
            listaTareas.remove(posicion);
        } catch (Exception e){
            System.out.println("No existe ninguna tarea en esa posición.");
        }
        return listaTareas;
    }
}
