import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Ejercicio18 {

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
            if (titulo == null || titulo.isBlank()) {
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

        List<Tarea> tareas = new ArrayList<>(List.of(tareaNormal, tareaUrgente));

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSISTEMA DE PROCESAMIENTO DE TAREAS");
        System.out.println("Opción 1: Mostrar todas las tareas");
        System.out.println("Opción 2: Marcar todas las tareas como completadas");
        System.out.println("Opción 3: Mostrar únicamente el título de cada tarea");
        System.out.print("\nSelecciona una opción (1-3): ");

        int opcion = scanner.nextInt();

        scanner.close();

        switch (opcion) {
            case 1:
                procesarTareas(tareas, tarea -> System.out.println(tarea));
                break;
            case 2:
                procesarTareas(tareas, tarea -> {
                    tarea.completar();
                    System.out.println("Se ha completado la tarea: " + tarea);
                });
                break;
            case 3:
                procesarTareas(tareas, tarea -> System.out.println("Título: " + tarea.getTitulo()));
                break;
            default:
                System.out.println("Introduce un valor dentro del intervalo permitido (1-3)...");
        }
    }

    public static void procesarTareas(List<Tarea> tareas, Consumer<Tarea> accion) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }

        for (Tarea tarea : tareas) {
            accion.accept(tarea);
        }
    }
}
