import java.util.ArrayList;
import java.util.List;

public class Ejercicio11 {
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

        public boolean completar() {
            return completada = true;
        }

        @Override
        public String toString() {
            return "Tarea: " + titulo + " | Descripción: " + descripcion + " | Completada: " + completada;
        }
    }

    public static void main(String[] args) {
        Tarea tarea1 = new Tarea("Estudiar Java", "Aprender POO y métodos", true);
        Tarea tarea2 = new Tarea("Practicar JavaFX", "Realizar ejercicios de DDI", false);
        Tarea tarea3 = new Tarea("Preparar examen", "Subir repositorio a Git", false);


        ArrayList<Tarea> listaTareas = new ArrayList<>(List.of(tarea1, tarea2, tarea3));

        System.out.println("Lista de tareas:\n");

        System.out.println("Completadas:");
        System.out.println(mostrarTareasCompletadas(listaTareas)+"\n");

        System.out.println("Incompletas:");
        System.out.println(mostrarTareasIncompletas(listaTareas)+"\n");
    }

    public static void mostrarTareas(ArrayList<Tarea> listaTareas) {
        int contador = 0;
        for (Tarea tarea : listaTareas) {
            System.out.println(contador + ":" + tarea);
            contador += 1;
        }
    }

    public static ArrayList<Tarea> borrarTarea(ArrayList<Tarea> listaTareas, int posicion) {
        try {
            listaTareas.remove(posicion);
        } catch (Exception e) {
            System.out.println("No existe ninguna tarea en esa posición.");
        }
        return listaTareas;
    }

    public static ArrayList<Tarea> buscarPorTitulo(ArrayList<Tarea> listaTareas, String texto) {
        ArrayList<Tarea> listaTareasFinal = new ArrayList<>();
        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getTitulo().contains(texto)) {
                listaTareasFinal.add(listaTareas.get(i));
            }
        }
        return listaTareasFinal;
    }

    public static ArrayList<Tarea> mostrarTareasCompletadas(ArrayList<Tarea> listaTareas){
        ArrayList<Tarea> listaTareasFinal = new ArrayList<>();
        for (int i=0; i < listaTareas.size(); i++){
            if (listaTareas.get(i).getCompletada()) {
                listaTareasFinal.add(listaTareas.get(i));
            }
        }
        return listaTareasFinal;
    }

    public static ArrayList<Tarea> mostrarTareasIncompletas(ArrayList<Tarea> lisaTareas){
        ArrayList<Tarea> listaTareasFinal = new ArrayList<>();
        for (int i=0; i < lisaTareas.size(); i++){
            if (!lisaTareas.get(i).getCompletada()){
                listaTareasFinal.add(lisaTareas.get(i));
            }
        }
        return listaTareasFinal;
    }
}
