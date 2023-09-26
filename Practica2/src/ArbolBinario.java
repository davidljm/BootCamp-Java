class Nodo<T> {
    T valor;
    Nodo<T> izquierda;
    Nodo<T> derecha;

    public Nodo(T valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ArbolBinario<T> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar un valor en el árbol
    public void insertar(T valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo<T> insertarRec(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            nodo = new Nodo<>(valor);
            return nodo;
        }

        if (valor.hashCode() < nodo.valor.hashCode()) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        } else if (valor.hashCode() > nodo.valor.hashCode()) {
            nodo.derecha = insertarRec(nodo.derecha, valor);
        }

        return nodo;
    }

    // Recorrido inOrden (izquierda, raíz, derecha)
    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo<T> nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inOrdenRec(nodo.derecha);
        }
    }

    // Recorrido preOrden (raíz, izquierda, derecha)
    public void preOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrdenRec(nodo.izquierda);
            preOrdenRec(nodo.derecha);
        }
    }

    // Recorrido postOrden (izquierda, derecha, raíz)
    public void postOrden() {
        postOrdenRec(raiz);
    }

    private void postOrdenRec(Nodo<T> nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierda);
            postOrdenRec(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.print("InOrden: ");
        arbol.inOrden();
        System.out.println();

        System.out.print("PreOrden: ");
        arbol.preOrden();
        System.out.println();

        System.out.print("PostOrden: ");
        arbol.postOrden();
        System.out.println();
    }
}
