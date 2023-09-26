import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialRecursivo {
    public long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcularFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese un número entero: ");
                int numero = scanner.nextInt();

                FactorialRecursivo factorialCalculator = new FactorialRecursivo();
                long resultado = factorialCalculator.calcularFactorial(numero);

                System.out.println("El factorial de " + numero + " es " + resultado);
                break; // Salir del bucle si se ingresa un número entero válido.
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar el búfer de entrada.
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Manejar error de número negativo.
            }
        }
        scanner.close();
    }
}
