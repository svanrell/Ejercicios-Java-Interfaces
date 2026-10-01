import java.time.LocalDate;
import java.util.*;

public class Ejercicio19 {

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

    public static void crearTarea(List<Tarea> tareas, String titulo, String descripcion, boolean completado,
            Tarea.Prioridad prioridad) {
        try {
            Tarea nuevaTarea = new Tarea(titulo, descripcion, completado, prioridad);
            tareas.add(nuevaTarea);
            System.out.println("Tarea creada correctamente: " + nuevaTarea);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear la tarea: " + e.getMessage());
        }
    }

    public static void mostrarTareas(List<Tarea> tareas) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }
        for (Tarea tarea : tareas) {
            if (tarea == null) {
                System.out.println("La tarea no puede ser null");
                continue;
            }
            System.out.println(tarea);
        }
        System.out.println("Se han mostrado todas las tareas que existen");
    }

    public static void buscarTareas(List<Tarea> tareas, String texto) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }
        boolean encontrada = false;
        for (Tarea tarea : tareas) {
            if (tarea != null && tarea.getTitulo().equalsIgnoreCase(texto)) {
                System.out.println(tarea);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se ha encontrado ninguna tarea con el título: " + texto);
        }
        System.out.println("Se han buscado todas las tareas");
    }

    public static void mostrarTareasPendientes(List<Tarea> tareas) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }

        for (Tarea tarea : tareas) {
            if (tarea != null && !tarea.getCompletada()) {
                System.out.println(tarea);
            }
        }
        System.out.println("Se han mostrado todas las tareas pendientes");
    }

    public static void mostrarTareasCompletadas(List<Tarea> tareas) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }

        for (Tarea tarea : tareas) {
            if (tarea != null && tarea.getCompletada()) {
                System.out.println(tarea);
            }
        }
        System.out.println("Se han mostrado todas las tareas completadas");
    }

    public static void completarTareas(List<Tarea> tareas, int index) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }

        if (index < 0 || index >= tareas.size()) {
            System.out.println("El número introducido no corresponde a ninguna tarea existente");
            return;
        }

        tareas.get(index).completar();
        System.out.println("La tarea: " + tareas.get(index) + " se ha completado correctamente");
    }

    public static void eliminarTarea(List<Tarea> tareas, int index) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }

        if (index < 0 || index >= tareas.size()) {
            System.out.println("El número introducido no corresponde a ninguna tarea existente");
            return;
        }

        tareas.remove(index);
        System.out.println("La tarea de índice: " + index + " se ha eliminado correctamente");
    }

    public static void mostrarEstadisticas(List<Tarea> tareas) {
        if (tareas == null || tareas.isEmpty()) {
            System.out.println("No se pueden introducir valores NULL o vacíos...");
            return;
        }

        int total = tareas.size();
        int completadas = 0;
        int pendientes = 0;

        for (Tarea tarea : tareas) {
            if (tarea != null) {
                if (tarea.getCompletada()) {
                    completadas++;
                } else {
                    pendientes++;
                }
            }
        }

        System.out.println("Total de tareas: " + total);
        System.out.println("Tareas completadas: " + completadas);
        System.out.println("Tareas pendientes: " + pendientes);
    }

    private static void gestionarMenu(Scanner scanner, List<Tarea> tareas) {
        int opcion;
        do {
            mostrarOpciones();
            opcion = comprobarOpcion(scanner);
            ejecutarOpcion(opcion, scanner, tareas);
        } while (opcion != 0);
    }

    private static void mostrarOpciones() {
        System.out.println("\nLISTA DE OPCIONES DISPONIBLES: ");
        System.out.println("1. Crear tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Buscar tareas");
        System.out.println("4. Mostrar tareas pendientes");
        System.out.println("5. Mostrar tareas completadas");
        System.out.println("6. Completar una tarea");
        System.out.println("7. Eliminar una tarea");
        System.out.println("8. Mostrar estadísticas");
        System.out.println("0. Salir");
    }

    private static int comprobarOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Introduce un número válido: ");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    private static void ejecutarOpcion(int opcion, Scanner scanner, List<Tarea> tareas) {
        switch (opcion) {

            case 1:
                System.out.println("\nIntroduce un título: ");
                String titulo = scanner.nextLine();

                System.out.println("\nIntroduce una descripción: ");
                String descripcion = scanner.nextLine();
                if (descripcion == null || descripcion.isBlank()) {
                    System.out.println("No puedes añadir una descripción con el valor NULL o que esté vacío");
                    break;
                }

                System.out.println("\n¿La tarea está completada? (true/false)");
                while (!scanner.hasNextBoolean()) {
                    System.out.println("Introduce true o false: ");
                    scanner.next();
                }
                boolean completado = scanner.nextBoolean();

                System.out.println("\n¿Qué prioridad tiene? (BAJA/MEDIA/ALTA)");
                String prioridadTexto = scanner.next().toUpperCase();
                Tarea.Prioridad prioridad = switch (prioridadTexto) {
                    case "BAJA" -> Tarea.Prioridad.BAJA;
                    case "MEDIA" -> Tarea.Prioridad.MEDIA;
                    case "ALTA" -> Tarea.Prioridad.ALTA;
                    default -> null;
                };

                if (prioridad == null) {
                    System.out.println("Prioridad no válida. Debe ser BAJA, MEDIA o ALTA.");
                    break;
                }

                System.out.println("\nCreando tarea...");
                crearTarea(tareas, titulo, descripcion, completado, prioridad);
                break;

            case 2:
                System.out.println("\nMostrando tareas...");
                mostrarTareas(tareas);
                break;

            case 3:
                System.out.println("\nIntroduce el título de la tarea: ");
                String textoBuscar = scanner.nextLine();
                while (textoBuscar.isBlank()) {
                    System.out.println("El título no puede estar vacío. Introduce el título: ");
                    textoBuscar = scanner.nextLine();
                }
                System.out.println("\nBuscando tareas...");
                buscarTareas(tareas, textoBuscar);
                break;

            case 4:
                System.out.println("\nMostrando tareas pendientes...");
                mostrarTareasPendientes(tareas);
                break;

            case 5:
                System.out.println("\nMostrando tareas completadas...");
                mostrarTareasCompletadas(tareas);
                break;

            case 6:
                System.out.println("\nIntroduce el índice de la tarea a completar: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Introduce un número válido: ");
                    scanner.next();
                }

                int index = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\nCompletando tarea...");
                completarTareas(tareas, index);
                break;

            case 7:
                System.out.println("\nIntroduce el índice de la tarea a eliminar: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Introduce un número válido: ");
                    scanner.next();
                }

                int indexEliminar = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\nEliminando tarea...");
                eliminarTarea(tareas, indexEliminar);
                break;

            case 8:
                System.out.println("\nMostrando estadísticas...");
                mostrarEstadisticas(tareas);
                break;

            case 0:
                System.out.println("\nSaliendo del programa...");
                break;

            default:
                System.out.println("Introduce un valor dentro del intervalo permitido (0-8)");
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

        gestionarMenu(scanner, tareas);

        scanner.close();
    }
}
