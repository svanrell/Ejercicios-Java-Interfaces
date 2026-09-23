import java.util.ArrayList;

public class Ejercicio12 {
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

    static class Proyecto{
        private String nombre;
        private ArrayList<Tarea> listaTareas;

        public Proyecto(String nombre){
            this.nombre = nombre;
            this.listaTareas = new ArrayList<>();
        }

        public Proyecto(String nombre, ArrayList<Tarea> listaTareas){
            this.nombre = nombre;
            this.listaTareas = listaTareas != null ? listaTareas : new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public ArrayList<Tarea> getTareas() {
            return listaTareas;
        }

        public ArrayList<Tarea> getListaTareas() {
            return listaTareas;
        }

        public void setListaTareas(ArrayList<Tarea> listaTareas) {
            this.listaTareas = listaTareas;
        }

        public void addTarea(Tarea tarea){
            this.listaTareas.add(tarea);
        }

        public void removeTarea(Tarea tarea){
            this.listaTareas.remove(tarea);
        }
    }

    public static void main(String[] args) {
        Proyecto proyecto1 = new Proyecto("Proyecto DI");

        Tarea tarea1 = new Tarea("Estudiar Java", "Aprender POO y métodos", true);
        Tarea tarea2 = new Tarea("Practicar JavaFX", "Realizar ejercicios de DDI", false);
        Tarea tarea3 = new Tarea("Subir proyecto", "Subir repositorio a Git", false);

        proyecto1.addTarea(tarea1);
        proyecto1.addTarea(tarea2);
        proyecto1.addTarea(tarea3);

        System.out.println("Tareas del proyecto " + proyecto1.getNombre() + ":");
        for (Tarea tarea : proyecto1.getTareas()) {
            System.out.println("- " + tarea);
        }
    }
}
