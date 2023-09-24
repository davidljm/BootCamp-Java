import java.util.InputMismatchException;
import java.util.Scanner;

/*
1 - Número entero capicua.
	Construir un metodo que reciba un entero como parámetro y devuelva boolean
	indicando si es capicúa o no dicho número.
	(Version Recursiva)
 */

public class Recursivo {
    public static boolean esCapicua(int numero) {
        // Convertimos el número a una cadena para facilitar la inversión.
        String numeroStr = Integer.toString(numero);

        // Caso base de recursividad: Si la cadena tiene 0 o 1 caracteres, es capicúa.
        if (numeroStr.length() <= 1) {
            return true;
        }
        // Comparamos el primer y último dígito de la cadena, si estos son diferentes ya no cumple con ser capicua.
        if (numeroStr.charAt(0) != numeroStr.charAt(numeroStr.length() - 1)) {
            return false;
        }
        // Llamar recursivamente con la cadena sin el primer y último dígito.
        return esCapicua(Integer.parseInt(numeroStr.substring(1, numeroStr.length() - 1)));
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
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