import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class NumerosPares {
    public static void main(String[] args) {
        List<Integer> numerosPares = IntStream.rangeClosed(10, 20)
                .filter(num -> num % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numerosPares);
        System.out.println("\n");
        System.out.println("\n");


        List<Integer> numerosPares2 = Stream.iterate(10, num -> num + 2)
                .limit(6) // Limitamos el tamaño a 6 para obtener los números del 10 al 20.
                .collect(Collectors.toList());
        System.out.println(numerosPares2);
        System.out.println("\n");
        System.out.println("\n");

        List<Integer> numerosPares3 = IntStream.range(10, 21)
                .filter(num -> num % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numerosPares3);


    }
}
