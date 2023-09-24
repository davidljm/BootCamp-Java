import java.util.InputMismatchException;
import java.util.Scanner;

/*
2 - Factorial
	Metodo que recibe un entero y devuelve el factorial del mismo
	Tipo Generico
 */

public class FactorialGen<T extends Number> {
    public long calcularFactorial(T n) {
        long numero = n.longValue(); // Convertir el valor genérico a long
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        long factorial = 1;
        for (long i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese un número entero: ");
                int numero = scanner.nextInt();

                FactorialGen<Integer> factorialCalculator = new FactorialGen<>();
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