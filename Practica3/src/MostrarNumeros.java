public class MostrarNumeros {
    public static void main(String[] args) {
        // Crear e iniciar un hilo para mostrar números
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(3000); // Retardo de 3 segundos (3000 milisegundos)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restaurar la interrupción
                    return; // Salir del hilo si se produce una interrupción
                }
            }
        });

        thread.start(); // Iniciar el hilo

        // Esperar a que el hilo termine
        try {
            thread.join();
        } catch (InterruptedException ignored) {
            
        }
        System.out.println("Fin del programa");
    }
}
