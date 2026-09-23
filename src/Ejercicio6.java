public class Ejercicio6 {
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

        System.out.println(tarea1);
        System.out.println(tarea2);
        System.out.println(tarea3);
    }
}
