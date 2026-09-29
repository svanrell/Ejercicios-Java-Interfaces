import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio16 {

    static class Tarea {
        private String titulo;
        private String descripcion;
        private boolean completada;
        private Prioridad prioridad;

        public enum Prioridad {
            BAJA,
            MEDIA,
            ALTA
        }

        public Tarea(String titulo, String descripcion, boolean completada, Prioridad prioridad) {
            if (titulo == null || titulo.isBlank()){
                throw new IllegalArgumentException("El título no puede estar vacío ni puede ser null");
            }

            this.titulo = titulo;
            this.descripcion = descripcion;
            this.completada = completada;
            this.prioridad = prioridad;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public boolean getCompletada() {
            return completada;
        }

        public void setCompletada(boolean completada) {
            this.completada = completada;
        }

        public Prioridad getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(Prioridad prioridad) {
            this.prioridad = prioridad;
        }

        public void completar() {
            this.completada = true;
        }

        @Override
        public String toString() {
            return "Tarea: " + titulo + " | Descripción: " + descripcion + " | Completada: " + completada
                    + " | Prioridad: " + prioridad;
        }
    }

    static class TareaUrgente extends Tarea {
        private LocalDate fechaLimite;

        public TareaUrgente(String titulo, String descripcion, boolean completada, Prioridad prioridad,
                            LocalDate fechaLimite) {
            super(titulo, descripcion, completada, prioridad);
            this.fechaLimite = fechaLimite;
        }

        public LocalDate getFechaLimite() {
            return fechaLimite;
        }

        public void setFechaLimite(LocalDate fechaLimite) {
            this.fechaLimite = fechaLimite;
        }

        @Override
        public String toString() {
            return super.toString() + " | Fecha límite: " + this.fechaLimite;
        }
    }

    public static void main(String[] args) {
        Tarea tareaNormal = new Tarea(
                "Estudiar Java",
                "Repasar conceptos de POO y métodos",
                false,
                Tarea.Prioridad.MEDIA);

        TareaUrgente tareaUrgente = new TareaUrgente(
                "Entrega de práctica DDI",
                "Subir el repositorio de Git antes del plazo final",
                false,
                Tarea.Prioridad.ALTA,
                LocalDate.now());

        System.out.println("Objeto Tarea:");
        System.out.println(tareaNormal);

        System.out.println("\nObjeto TareaUrgente:");
        System.out.println(tareaUrgente);

        System.out.println("\nModificando estado...");
        tareaNormal.completar();
        System.out.println("Tarea normal completada: " + tareaNormal);

        tareaUrgente.completar();
        System.out.println("Tarea urgente completada: " + tareaUrgente);

        System.out.println("\nLista combinada:");
        ArrayList<Tarea> listaTareas = new ArrayList<>(List.of(tareaNormal, tareaUrgente));
        for (Tarea tarea : listaTareas) {
            System.out.println("- " + tarea);
        }
    }
}