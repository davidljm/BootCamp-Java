import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
Implementar la clase Fila (Utilizando una Collection que no implemente la interfaz Queue / Deque)
 */
public class Fila<T> {
    private final List<T> elementos;

    public Fila() {
        elementos = new ArrayList<>();
    }

    // Método para agregar un elemento al final de la fila (enqueue)
    public void enqueue(T elemento) {
        elementos.add(elemento);
    }

    // Método para eliminar y devolver el elemento en el frente de la fila (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T elemento = elementos.get(0);
        elementos.remove(0);
        return elemento;
    }

    // Método para verificar si la fila está vacía
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Método para obtener el tamaño de la fila
    public int size() {
        return elementos.size();
    }

    // Método para vaciar la fila
    public void clear() {
        elementos.clear();
    }

    // Método para imprimir la fila
    public void imprimirFila() {
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        System.out.println("Elemento en el frente de la fila: " + fila.dequeue());

        System.out.println("Fila original:");
        fila.imprimirFila();

        System.out.println("Dequeue: " + fila.dequeue());

        System.out.println("Fila después del dequeue:");
        fila.imprimirFila();
    }
}
