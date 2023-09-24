import java.util.InputMismatchException;
import java.util.Scanner;

/*
2 - Factorial
	Metodo que recibe un entero y devuelve el factorial del mismo
 */

public class Factorial {
    public static int calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int numero;

        while (true) {
            try {
                System.out.print("Ingrese un número entero: ");
                numero = scanner.nextInt();

                if (numero >= 0) {
                    break; // Salir del bucle si se ingresa un número entero válido.
                } else {
                    System.out.println("Error: Debe ingresar un número entero no negativo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar el búfer de entrada.
            }
        }
        int factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es " + factorial);
        scanner.close();
    }
}