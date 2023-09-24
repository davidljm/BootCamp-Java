import java.util.InputMismatchException;
import java.util.Scanner;

/*
1 - Número entero capicua.
	Construir un metodo que reciba un entero como parámetro y
	devuelva boolean indicando si es capicúa o no dicho número.
	(Version No Recursiva)
 */

public class NoRecursivo {
    public static boolean esCapicua(int numero) {
        // Convertimos el número a una cadena para facilitar la inversión.
        String numeroStr = Integer.toString(numero);

        // Creaamos una cadena para almacenar el número invertido.
        String numeroInvertido = "";

        // Invertimos la cadena original.
        for (int i = numeroStr.length() - 1; i >= 0; i--) {
            numeroInvertido += numeroStr.charAt(i);
        }

        // Comparamos la cadena original con la invertida.
        return numeroStr.equals(numeroInvertido);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        while (true) {
            try {
                System.out.print("Ingrese un número entero: ");
                numero = scanner.nextInt();
                break; // Salir del bucle si se ingresa un número entero válido.
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); // Limpiar el búfer de entrada.
            }
        }
        if (esCapicua(numero)) {
            System.out.println(numero + " es un número capicúa.");
        } else {
            System.out.println(numero + " no es un número capicúa.");
        }
        scanner.close();
    }
}