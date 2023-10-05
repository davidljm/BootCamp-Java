import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Map;

public class Alumno {
    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private String curso;
    private double nota;
    private int edad;


    // Constructor
    public Alumno(int id, int dni, String nombre, String apellido, String curso, double nota, int edad) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.nota = nota;
        this.edad = edad;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", curso='" + curso + '\'' +
                ", nota=" + nota +
                ", edad=" + edad +
                '}';
    }

    // Método para generar un DNI aleatorio de 8 dígitos entre 20,000,000 y 40,000,000
    public static int generarDNI() {
        Random random = new Random();
        int minimo = 20000000;
        int maximo = 40000000;
        int dniGenerado;
        // Generar un número aleatorio entre minimo y maximo

        return dniGenerado = random.nextInt(maximo - minimo + 1) + minimo;
    }
    public static String obtenerNombreAleatorio() {
        int indiceAleatorio;

        ArrayList<String> listaNombres = new ArrayList<>();
        listaNombres.add("Juan");
        listaNombres.add("María");
        listaNombres.add("Carlos");
        listaNombres.add("Laura");
        listaNombres.add("Pedro");
        listaNombres.add("David");
        listaNombres.add("Adrian");
        listaNombres.add("Esteban");
        listaNombres.add("Ruth");
        listaNombres.add("Carla");
        Random random = new Random();
        indiceAleatorio = random.nextInt(listaNombres.size());
        return listaNombres.get(indiceAleatorio);
    }

    public static String obtenerApellidoAleatorio() {
        int indiceAleatorio;

        ArrayList<String> listaApellido = new ArrayList<>();
        listaApellido.add("Perez");
        listaApellido.add("Rodriguez");
        listaApellido.add("Mulé");
        listaApellido.add("Chara");
        listaApellido.add("Monzon");
        listaApellido.add("Gimenez");
        listaApellido.add("Merlini");
        listaApellido.add("Riquelme");
        listaApellido.add("Fabra");
        listaApellido.add("Gallardo");
        Random random = new Random();
        indiceAleatorio = random.nextInt(listaApellido.size());
        return listaApellido.get(indiceAleatorio);
    }

    public static String obtenerCursos() {
        int indiceAleatorio;

        ArrayList<String> listaCursos = new ArrayList<>();
        listaCursos.add("1 A");
        listaCursos.add("1 B");
        listaCursos.add("2 A");
        listaCursos.add("2 B");
        listaCursos.add("3 A");
        listaCursos.add("3 B");
        listaCursos.add("4 A");
        listaCursos.add("4 B");
        Random random = new Random();
        indiceAleatorio = random.nextInt(listaCursos.size());
        return listaCursos.get(indiceAleatorio);
    }


    public static double obtenerNota(){
        // Crear un formato para limitar a dos decimales
        DecimalFormat df = new DecimalFormat("#.##");

        Random random = new Random();
        double valorFormateado;
        double valor = random.nextDouble() * 10;
        if (valor < 1){
            valor = random.nextDouble() * 10;
            String resultado = df.format(valor);
            // Convertir el resultado nuevamente a double (si es necesario)
            valorFormateado = Double.parseDouble(resultado);
        }else{
            // Aplicar el formato al valor
            String resultado = df.format(valor);

            // Convertir el resultado nuevamente a double (si es necesario)

            valorFormateado = Double.parseDouble(resultado);
        }
        return valorFormateado;
    }

    public static void main(String[] args) {

        List<Alumno> listaAlumnos = new ArrayList<>();

        // Cargar la lista con datos aleatorios
        Random random = new Random();
        for (int i = 1; i <= 15; i++) {
            Alumno alumno = new Alumno(i, generarDNI(), obtenerNombreAleatorio(), obtenerApellidoAleatorio(),
                    obtenerCursos(), obtenerNota(),
                    random.nextInt(15) + 18);
            listaAlumnos.add(alumno);
        }

        System.out.println("Lista de Alumnos:");
        //Mostrar todos los alumnos de la lista
        listaAlumnos.forEach(System.out::println);


        System.out.println("\nAlumnos ordenados de menor a mayor por edad:");
        //Mostrar todos los alumnos ordenados de menor a mayor por edad
        listaAlumnos.stream()
                .sorted(Comparator.comparingInt(Alumno::getEdad))
                .forEach(System.out::println);


        System.out.println("\nAlumnos cuyo nombre empiece con la letra D:");
        //Mostrar aquellos alumnos cuyo nombre empiece con un carácter dado:
        char caracter = 'D'; // Cambia esto al carácter que desees
        listaAlumnos.stream()
                .filter(alumno -> alumno.getNombre().charAt(0) == caracter)
                .forEach(System.out::println);

        //Sumar todas las edades de los alumnos
        int sumaEdades = listaAlumnos.stream()
                .mapToInt(Alumno::getEdad)
                .sum();
        System.out.println("\nSuma de edades: " + sumaEdades);

        //Obtener un mapa
        Map<Double, List<Alumno>> mapaNotas = listaAlumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getNota));
        mapaNotas.forEach((nota, alumnos) -> {
            System.out.println("\nNota: " + nota);
            alumnos.forEach(System.out::println);
        });
    }
}
