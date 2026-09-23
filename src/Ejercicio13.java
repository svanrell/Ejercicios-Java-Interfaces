import java.util.ArrayList;

public class Ejercicio13 {
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

    static class Proyecto {
        private String nombre;
        private ArrayList<Tarea> listaTareas;

        public Proyecto(String nombre) {
            this.nombre = nombre;
            this.listaTareas = new ArrayList<>();
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
        Proyecto proyecto1 = new Proyecto("Proyecto DI");

        // 3 tareas completadas
        proyecto1.addTarea(new Tarea("Estudiar Java", "Aprender POO y métodos", true));
        proyecto1.addTarea(new Tarea("Configurar entorno", "Instalar JDK y extensiones", true));
        proyecto1.addTarea(new Tarea("Diseñar interfaz", "Boceto de la ventana principal", true));

        // 5 tareas pendientes
        proyecto1.addTarea(new Tarea("Practicar JavaFX", "Realizar ejercicios de DDI", false));
        proyecto1.addTarea(new Tarea("Subir proyecto", "Subir repositorio a Git", false));
        proyecto1.addTarea(new Tarea("Conectar base de datos", "Crear pool de conexiones", false));
        proyecto1.addTarea(new Tarea("Crear pruebas unitarias", "Testear lógica de negocio", false));
        proyecto1.addTarea(new Tarea("Documentar código", "Generar JavaDoc del proyecto", false));

        System.out.println("Proyecto: " + proyecto1.getNombre() + "\n");
        System.out.println("Total de tareas: " + proyecto1.getNumeroTareas());
        System.out.println("Completadas: " + proyecto1.getNumeroCompletadas());
        System.out.println("Pendientes: " + proyecto1.getNumeroPendientes());
    }
}
