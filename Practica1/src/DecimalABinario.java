import java.util.InputMismatchException;
import java.util.Scanner;

/*
3 - Metodo que recibe un entero en formato decimal y devuelve un double en formato binario.
 */

public class DecimalABinario {
    public static double decimalABinario(int numeroDecimal) {
        if (numeroDecimal == 0) {
            return 0;
        }
        int valorAbsoluto = Math.abs(numeroDecimal); // Calculamos el valor absoluto del número decimal.
        StringBuilder binario = new StringBuilder();

        while (valorAbsoluto > 0) {
            int residuo = valorAbsoluto % 2; // Calcula el residuo de la división por 2.
            binario.insert(0, residuo); // Agrega el residuo al principio de la cadena.
            valorAbsoluto /= 2; // Divide el valor absoluto por 2.
        }

        if (numeroDecimal < 0) {
            binario.insert(0, "-"); // Si el número decimal era negativo, agrega un signo negativo al principio.
        }

        return Double.parseDouble(binario.toString()); // Convierte la cadena binaria a double.
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int numeroDecimal = 0;

        boolean numeroValido = false;

        while (!numeroValido) {
            try {
                System.out.print("Ingrese un número decimal: ");
                numeroDecimal = scanner.nextInt();
                numeroValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número decimal válido.");
                scanner.nextLine(); // Limpiar el búfer de entrada.
            }
        }
        double numeroBinario = decimalABinario(numeroDecimal);
        System.out.println("El número binario de " + numeroDecimal + " es " + numeroBinario);
        scanner.close();
    }
}