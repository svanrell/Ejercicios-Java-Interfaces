import java.util.ArrayList;
import java.util.List;

public class Ejercicio14 {
    static class Tarea {
        private String titulo;
        private String descripcion;
        private boolean completada;
        private Prioridad prioridad;

        public Tarea(String titulo, String descripcion, boolean completada, Prioridad prioridad) {
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.completada = completada;
            this.prioridad = prioridad;
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

        public Prioridad getPrioridad(){
            return prioridad;
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

        public void setPrioridad(Prioridad prioridad){
            this.prioridad = prioridad;
        }

        public boolean completar() {
            return completada = true;
        }

        public enum Prioridad {
            BAJA,
            MEDIA,
            ALTA,
        }

        @Override
        public String toString() {
            return "Tarea: " + titulo + " | Descripción: " + descripcion + " | Completada: " + completada + " | Prioridad: " + prioridad;
        }
    }

    static class Proyecto {
        private String nombre;
        private ArrayList<Tarea> listaTareas;

        public Proyecto(String nombre, ArrayList<Tarea> listaTareas) {
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
            this.listaTareas = listaTareas != null ? listaTareas : new ArrayList<>();
        }

        public void addTarea(Tarea tarea) {
            this.listaTareas.add(tarea);
        }

        public void removeTarea(Tarea tarea) {
            this.listaTareas.remove(tarea);
        }

        public int getNumeroTareas() {
            return listaTareas.size();
        }

        public int getNumeroCompletadas() {
            int tareasCompletadas = 0;
            for (Tarea tarea : listaTareas) {
                if (tarea.getCompletada()) {
                    tareasCompletadas++;
                }
            }
            return tareasCompletadas;
        }

        public int getNumeroPendientes() {
            int tareasPendientes = 0;
            for (Tarea tarea : listaTareas) {
                if (!tarea.getCompletada()) {
                    tareasPendientes++;
                }
            }
            return tareasPendientes;
        }
    }

    public static void main(String[] args) {
        Tarea tarea1 = new Tarea("Estudiar Java", "Aprender POO y métodos", true, Tarea.Prioridad.ALTA);
        Tarea tarea2 = new Tarea("Configurar entorno", "Instalar JDK y extensiones", true, Tarea.Prioridad.MEDIA);
        Tarea tarea3 = new Tarea("Diseñar interfaz", "Boceto de la ventana principal", true, Tarea.Prioridad.BAJA);
        Tarea tarea4 = new Tarea("Practicar JavaFX", "Realizar ejercicios de DDI", false, Tarea.Prioridad.ALTA);
        Tarea tarea5 = new Tarea("Subir proyecto", "Subir repositorio a Git", false, Tarea.Prioridad.MEDIA);
        Tarea tarea6 = new Tarea("Conectar base de datos", "Crear pool de conexiones", false, Tarea.Prioridad.ALTA);
        Tarea tarea7 = new Tarea("Crear pruebas unitarias", "Testear lógica de negocio", false, Tarea.Prioridad.MEDIA);
        Tarea tarea8 = new Tarea("Documentar código", "Generar JavaDoc del proyecto", false, Tarea.Prioridad.BAJA);

        Proyecto proyecto1 = new Proyecto("Proyecto DI", new ArrayList<>(List.of(
                tarea1, tarea2, tarea3, tarea4, tarea5, tarea6, tarea7, tarea8
        )));

        System.out.println("Tareas del proyecto " + proyecto1.getNombre() + ":\n");
        for (Tarea tarea : proyecto1.getTareas()) {
            System.out.println("- " + tarea);
        }
    }
}