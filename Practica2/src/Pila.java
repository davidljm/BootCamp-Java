import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Pila<T> {
    private List<T> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    // Método para agregar un elemento a la pila (push)
    public void push(T elemento) {
        elementos.add(elemento);
    }

    // Método para eliminar y devolver el elemento en la cima de la pila (pop)
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = elementos.size() - 1;
        T elemento = elementos.get(lastIndex);
        elementos.remove(lastIndex);
        return elemento;
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return elementos.size();
    }

    // Método para obtener el elemento en la cima de la pila sin eliminarlo
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    // Método para vaciar la pila
    public void clear() {
        elementos.clear();
    }

    // Método para imprimir la pila
    public void imprimirPila() {
        for (int i = elementos.size() - 1; i >= 0; i--) {
            System.out.println(elementos.get(i));
        }
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        System.out.println("Elemento en la cima de la pila: " + pila.peek());

        System.out.println("Pila original:");
        pila.imprimirPila();

        System.out.println("Pop: " + pila.pop());

        System.out.println("Pila después del pop:");
        pila.imprimirPila();
    }
}
