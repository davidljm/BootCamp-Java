public class Fila2<T> {
    private final Object[] elementos;
    private final int capacidad;
    private int tamanio;
    private int frente;
    private int finalCola;

    public Fila2(int capacidad) {
        this.capacidad = capacidad;
        elementos = new Object[capacidad];
        tamanio = 0;
        frente = 0;
        finalCola = 0;
    }
    public void enqueue(T elemento) {
        if (tamanio == capacidad) {
            throw new IllegalStateException("La fila está llena");
        }
        elementos[finalCola] = elemento;
        finalCola = (finalCola + 1) % capacidad;
        tamanio++;
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La fila está vacía");
        }
        T elemento = (T) elementos[frente];
        elementos[frente] = null; // Limpiamos la referencia al elemento
        frente = (frente + 1) % capacidad;
        tamanio--;
        return elemento;
    }
    public boolean isEmpty() {
        return tamanio == 0;
    }
    public void imprimirFila() {
        if (isEmpty()) {
            System.out.println("La fila está vacía.");
        } else {
            System.out.println("Elementos de la fila:");
            int indice = frente;
            for (int i = 0; i < tamanio; i++) {
                System.out.println(elementos[indice]);
                indice = (indice + 1) % capacidad;
            }
        }
    }

    public static void main(String[] args) {
        Fila2<Integer> fila = new Fila2<>(5);

        // Enqueue
        fila.enqueue(3);
        fila.enqueue(6);
        fila.enqueue(1);

        // Imprimir la fila
        fila.imprimirFila();

        // Dequeue
        try {
            System.out.println("Dequeue: " + fila.dequeue());
        } catch (IllegalStateException e) {
            System.out.println("La fila está vacía.");
        }

        // Imprimir la fila después del dequeue
        fila.imprimirFila();

        // Verificar si la fila está vacía después del dequeue
        System.out.println("La fila está vacía después del dequeue: " + fila.isEmpty());
    }
}
