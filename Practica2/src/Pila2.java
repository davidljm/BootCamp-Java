import java.util.EmptyStackException;
public class Pila2<T> {
    private Object[] elementos;
    private int tamanio;
    private static final int CAPACIDAD_INICIAL = 10;

    public Pila2() {
        elementos = new Object[CAPACIDAD_INICIAL];
        tamanio = 0;
    }
    public void push(T elemento) {
        if (tamanio == elementos.length) {
            aumentarCapacidad();
        }
        elementos[tamanio++] = elemento;
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T elemento = peek();
        elementos[--tamanio] = null; // Limpiamos la referencia al elemento
        return elemento;
    }
    public boolean isEmpty() {
        return tamanio == 0;
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elementos[tamanio - 1];
    }
    public void clear() {
        for (int i = 0; i < tamanio; i++) {
            elementos[i] = null;
        }
        tamanio = 0;
    }
    private void aumentarCapacidad() {
        int nuevaCapacidad = elementos.length * 2;
        Object[] nuevoArreglo = new Object[nuevaCapacidad];
        System.arraycopy(elementos, 0, nuevoArreglo, 0, tamanio);
        elementos = nuevoArreglo;
    }
    public void imprimirPila() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos de la pila:");
            for (int i = tamanio - 1; i >= 0; i--) {
                System.out.println(elementos[i]);
            }
        }
    }
    public static void main(String[] args) {
        Pila2<Integer> pila = new Pila2<>();

        // Push
        pila.push(6);
        pila.push(4);
        pila.push(3);

        // Peek
        System.out.println("Elemento en la cima de la pila: " + pila.peek());

        // Imprimir la pila
        System.out.println("Pila original:");
        pila.imprimirPila();

        // Pop
        try {
            System.out.println("Pop: " + pila.pop());
        } catch (EmptyStackException e) {
            System.out.println("La pila está vacía.");
        }

        // Imprimir la pila después del pop
        System.out.println("Pila después del pop:");
        pila.imprimirPila();

        // Clear
        pila.clear();

        // Verificar si la pila está vacía después de limpiarla
        System.out.println("La pila está vacía después de limpiarla: " + pila.isEmpty());
    }
}
