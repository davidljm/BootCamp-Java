import java.util.Scanner;

public class InvertirString {
    // Método recursivo para invertir un String
    public String invertirString(String str) {
        // Caso base: Si la cadena está vacía o tiene un solo carácter, devolvemos la cadena original.
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Paso recursivo: Tomamos el primer carácter de la cadena y lo concatenamos
        // con la inversión del resto de la cadena (todos los caracteres excepto el primero).
        char primerCaracter = str.charAt(0);
        String restoDeCadena = str.substring(1);

        return invertirString(restoDeCadena) + primerCaracter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena para invertir: ");
        String cadena = scanner.nextLine();

        InvertirString inversor = new InvertirString();

        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + inversor.invertirString(cadena));

        scanner.close();
    }
}
