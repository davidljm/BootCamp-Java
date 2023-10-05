public class SumaNumeros {
    private static final Object lock = new Object();
    private static int sumaPares = 0;
    private static int sumaImpares = 0;

    public static void main(String[] args) {
        Thread threadPares = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i ++) {
                    if(esPar(i)){
                        System.out.println("Número par: " + i);
                        sumaPares += i;
                        try {
                            lock.notify(); // Notificar al otro hilo que puede ejecutarse
                            if (i < 10) {
                                lock.wait(); // Esperar para permitir que el otro hilo se ejecute
                                Thread.sleep(2000); // Esperar 2 segundos
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                System.out.println("Suma de pares: " + sumaPares);
            }
        });

        Thread threadImpares = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 9; i ++) {
                    if(!esPar(i)) {
                        System.out.println("Número impar: " + i);
                        sumaImpares += i;
                        try {
                            lock.notify(); // Notificar al otro hilo que puede ejecutarse
                            if (i < 9) {
                                lock.wait(); // Esperar para permitir que el otro hilo se ejecute
                                Thread.sleep(2000); // Esperar 2 segundos
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                System.out.println("Suma de impares: " + sumaImpares);
            }
        });
        System.out.println("Inicio de Programa \n");
        threadImpares.start();
        threadPares.start();

    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }
}