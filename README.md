# Ejercicios de Java — Desarrollo de Interfaces (DDI)

Colección de ejercicios prácticos de Java para el módulo de Desarrollo de Interfaces (DDI).

---

## Estructura del Proyecto

```text
ejerciciosJava/
├── .gitignore
├── README.md
└── src/
    ├── Ejercicio1.java
    ├── Ejercicio2.java
    ├── Ejercicio3.java
    ├── Ejercicio4.java
    ├── Ejercicio5.java
    ├── Ejercicio6.java
    ├── Ejercicio7.java
    ├── Ejercicio8.java
    ├── Ejercicio9.java
    ├── Ejercicio10.java
    ├── Ejercicio11.java
    ├── Ejercicio12.java
    ├── Ejercicio13.java
    ├── Ejercicio14.java
    ├── Ejercicio15.java
    ├── Ejercicio16.java
    ├── Ejercicio17.java
    ├── Ejercicio18.java
    └── Ejercicio19.java
```

---

## Contenido de los Ejercicios

### Bloque 1: Ejercicios 1 a 6

* **Ejercicio 1**: Lectura por teclado con `Scanner`.
* **Ejercicio 2**: Funciones de cálculo de importes:
  * `calcularSubtotal(precio, cantidad)`
  * `calcularDescuento(subtotal, porcentaje)`
  * `calcularTotal(subtotal, descuento)`
* **Ejercicio 3**: Estructura `switch` para niveles de prioridad:
  * `calcularPrioridad(numero)`
* **Ejercicio 4**: Manejo y recorrido de arrays (`String[]`):
  * `formatearTareas(tareas)`
* **Ejercicio 5**: Búsqueda lineal en arrays con `equalsIgnoreCase`:
  * `buscarTarea(tareas, texto)`
* **Ejercicio 6**: Creación de la clase `Tarea`:
  * Getters y setters (`getTitulo`, `setTitulo`, `getDescripcion`, `setDescripcion`, `getCompletada`, `setCompletada`)
  * `toString()`

---

### Bloque 2: Ejercicios 7 a 14

* **Ejercicio 7**: Modificación de estado en `Tarea`:
  * `completar()`
* **Ejercicio 8**: Listas dinámicas con `ArrayList<Tarea>`:
  * `mostrarTareas(listaTareas)`
* **Ejercicio 9**: Eliminación por índice con control de errores (`try-catch`):
  * `borrarTarea(listaTareas, posicion)`
* **Ejercicio 10**: Filtrado por coincidencia de texto (`contains`):
  * `buscarPorTitulo(listaTareas, texto)`
* **Ejercicio 11**: Segregación de listas según estado:
  * `mostrarTareasCompletadas(listaTareas)`
  * `mostrarTareasIncompletas(listaTareas)`
* **Ejercicio 12**: Creación de la clase `Proyecto` (relación 1:N con `Tarea`):
  * `addTarea(tarea)`
  * `removeTarea(tarea)`
  * `getTareas()`
* **Ejercicio 13**: Estadísticas en la clase `Proyecto`:
  * `getNumeroTareas()`
  * `getNumeroCompletadas()`
  * `getNumeroPendientes()`
* **Ejercicio 14**: Integración de enum `Prioridad`:
  * `enum Prioridad { BAJA, MEDIA, ALTA }`
  * `getPrioridad()` y `setPrioridad(prioridad)`
  * Adaptación del constructor y `toString()` para reflejar la prioridad de cada tarea.

---

### Bloque 3: Ejercicios 15 a 19

* **Ejercicio 15**: Herencia y polimorfismo con subclases:
  * Creación de la clase `TareaUrgente` que hereda de `Tarea`.
  * Atributo adicional `fechaLimite` (`LocalDate`).
  * Sobrescritura de `toString()` y manejo polimórfico en colecciones (`List<Tarea>`).
* **Ejercicio 16**: Validación de datos y control de excepciones:
  * Comprobación en el constructor de `Tarea` (`titulo == null || titulo.isBlank()`).
  * Lanzamiento de `IllegalArgumentException` ante datos inválidos.
* **Ejercicio 17**: Ordenación de colecciones con `Comparator` y expresiones lambda:
  * Ordenación por título (`Comparator.comparing(tarea -> tarea.getTitulo())`).
  * Ordenación por prioridad (`Comparator.comparing(tarea -> tarea.getPrioridad())`).
  * Recorrido mediante `forEach` y lambdas.
* **Ejercicio 18**: Programación funcional e interfaces funcionales (`Consumer<T>`):
  * Método de orden superior `procesarTareas(List<Tarea> tareas, Consumer<Tarea> accion)`.
  * Ejecución de distintas acciones sobre la lista mediante expresiones lambda.
* **Ejercicio 19**: Aplicación completa de consola con menú interactivo (`Scanner`):
  * Menú interactivo continuo (`gestionarMenu`, `mostrarOpciones`, `ejecutarOpcion`).
  * Operaciones CRUD y utilidades sobre `List<Tarea>`:
    * Creación de tareas con validación de entradas (`crearTarea`).
    * Listado general (`mostrarTareas`), búsqueda por título (`buscarTareas`) y filtrado por estado (`mostrarTareasPendientes`, `mostrarTareasCompletadas`).
    * Marcado de completado (`completarTareas`) y eliminación por índice (`eliminarTarea`) con validación de límites.
    * Estadísticas globales del proyecto (`mostrarEstadisticas`).
