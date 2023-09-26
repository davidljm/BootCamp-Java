import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductoSinMultiplicacion {
    // Método recursivo para calcular el producto de dos enteros (a y b) sin multiplicación.
    public int calcularProducto(int a, int b) {
        // Caso base: Si uno de los números es 0, el resultado es 0.
        if (a == 0 || b == 0) {
            return 0;
        }

        // Caso base: Si b es igual a 1, el resultado es a.
        if (b == 1) {
            return a;
        }

        // Caso base: Si a es igual a 1, el resultado es b.
        if (a == 1) {
            return b;
        }

        // Caso recursivo: Restamos 1 de 'a' y multiplicamos 'b' recursivamente.
        // Luego, sumamos 'b' al resultado de la llamada recursiva.
        return calcularProducto(a - 1, b) + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese el primer número entero: ");
                int numero1 = scanner.nextInt();

                System.out.print("Ingrese el segundo número entero: ");
                int numero2 = scanner.nextInt();

                ProductoSinMultiplicacion productoCalculator = new ProductoSinMultiplicacion();
                int resultado = productoCalculator.calcularProducto(numero1, numero2);

                System.out.println("El producto entre " + numero1 + " y " + numero2 + " es " + resultado);
                break; // Salir del bucle si se ingresan números enteros válidos.
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar números enteros válidos.");
                scanner.nextLine(); // Limpiar el búfer de entrada.
            }
        }
        scanner.close();
    }
}
