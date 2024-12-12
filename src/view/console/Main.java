package view.console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Film> films = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        keyboard.useDelimiter("\n");
        String opcionStr;

        do {
            System.out.println("1- Dar de alta Usuarios ");//hecho// verificacion no repetir correos falta por hacer
            System.out.println("2- Anadir una Pelicula");//hecho
            System.out.println("3- Crear Sala"); //hecho
            System.out.println("4- Crear Sesion");
            System.out.println("5- Ver todas las Peliculas");//hecho
            System.out.println("6- Ver todas las Sesiones");
            System.out.println("7- Ver todas las Salas"); //hecho
            System.out.println("8- Comprar Pelicula");// iniciar sesion con mail y contraseña
            System.out.println("9- Ver Usuarios");//hecho
            System.out.println("10- Ver Compras por Usuario");
            System.out.println("11- Borrar Usuario");//hecho
            System.out.println("0- Salir");//hecho
            opcionStr = keyboard.next();

            switch (opcionStr) {
                case "0":
                    System.out.println("Chao!");
                    break;
                case "1":
                    darAltaUsuarios();
                    break;
                case "2":
                    anadirPelicula();
                    break;
                case "3":
                    crearSala();
                    break;
                case "4":
                    break;
                case "5":
                    verTodasPeliculas();
                    break;
                case "6":
                    break;
                case "7":
                    verTodasSalas();
                    break;
                case "8":
                    break;
                case "9":
                    verUsuarios();
                    break;
                case "10":
                    break;
                case "11":
                    borrarUsuario();
                    break;
                default:
                    System.out.println("Opcion Incorrecta!");
            }
        } while (!opcionStr.equals("0"));
    }

    public static String validarStringNoVacio(String campo) {
        String input;
        do {
            System.out.println("Ingrese " + campo + ":");
            input = keyboard.next();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("El " + campo + " no puede estar vacio. Por favor, intentalo de nuevo.");
            }
        } while (input == null || input.trim().isEmpty());
        return input.trim();
    }

    public static String validarTelefono() {
        String phone;
        boolean isValid;

        do {
            System.out.println("Ingrese telefono:");
            phone = keyboard.next();

            if (phone.length() == 9 && phone.matches("\\d+")) {
                isValid = true;
            } else {
                isValid = false;
                System.out.println("Telefono no valido. Introduce un numero de 9 digitos:");
            }
        } while (!isValid);

        return phone.trim();
    }

    public static String validarEmail() {
        //modificar
        String email;
        boolean isValid;
        do {
            System.out.println("Ingrese email:");
            email = keyboard.next();
            isValid = email.contains("@") && (email.contains(".com") || email.contains(".es"));
            if (!isValid) {
                System.out.println("Correo no valido. Introduce un correo electronico valido:");
            }
        } while (!isValid);

        return email.trim();
    }

    public static void darAltaUsuarios() {
        String nombre = validarStringNoVacio("nombre");
        String apellidos = validarStringNoVacio("apellidos");
        String phone = validarTelefono();
        String email = validarEmail();
        String password = validarStringNoVacio("contrasena");

        User user = new User(nombre, apellidos, phone, email, password);
        users.add(user);
        System.out.println("Usuario agregado exitosamente!");
    }

    public static int validarDuracion() {
        int duration = -1;
        String strDuration;
        while (duration <= 0) {

            System.out.println("Ingrese la duracion de la pelicula: ");
            strDuration = keyboard.next();
            if (isNumericPositive(strDuration)) {
                duration = Integer.parseInt(strDuration);
            } else {
                System.out.println("Entrada invalida. Por favor, ingrese un numero entero positivo.");
            }
        }
        return duration;
    }

    public static void anadirPelicula() {

        String title = validarStringNoVacio("Titulo Pelicula");
        int duration = validarDuracion();

        Film film = new Film(title, duration);
        films.add(film);
        System.out.println("Pelicula agregada exitosamente!");
    }

    public static void verUsuarios() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de Usuarios:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public static void verTodasPeliculas() {
        if (films.isEmpty()) {
            System.out.println("No hay peliculas registradas.");
        } else {
            System.out.println("Lista de Peliculas:");
            for (Film film : films) {
                System.out.println(film);
            }
        }
    }

    public static void borrarUsuario() {
        System.out.println("Ingrese el email del usuario a borrar:");
        String email = keyboard.next();
        User userToRemove = null;

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            users.remove(userToRemove);
            System.out.println("Usuario borrado exitosamente!");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static int validarAsientos(String tipoAsiento) {
        int numAsientos = 0;
        boolean isValid = false;
        String strAsientos;

        do {
            System.out.println("Ingrese el numero de asientos " + tipoAsiento + " (entre 1 y 50):");
            strAsientos = keyboard.next();
            if (isNumericBetween(1, 50, strAsientos)) {
                numAsientos = Integer.parseInt(strAsientos);
                isValid = true;
            } else {
                System.out.println("Numero de asientos " + tipoAsiento + " no valido. Introduce un numero entre 5 y 50:");
            }
        } while (!isValid);

        return numAsientos;
    }

    public static int[] validarTotalAsientos() {
        int numAsientos, numAsientosVip, numAsientosAdaptados;
        boolean isValid = false;

        do {
            numAsientos = validarAsientos("normales");
            numAsientosVip = validarAsientos("VIP");
            numAsientosAdaptados = validarAsientos("adaptados");

            if (numAsientos + numAsientosVip + numAsientosAdaptados <= 50) {
                isValid = true;
            } else {
                System.out.println("El total de asientos no puede exceder 50. Por favor, intentalo de nuevo.");
            }
        } while (!isValid);

        return new int[]{numAsientos, numAsientosVip, numAsientosAdaptados};
    }

    public static void crearSala() {
        String numSala = validarStringNoVacio("Numero de Sala");
        int[] asientos = validarTotalAsientos();

        Room room = new Room(numSala, asientos[0], asientos[1], asientos[2]);
        rooms.add(room);
        System.out.println("Sala creada exitosamente!");
    }
    
    public static void verTodasSalas() {
        if (rooms.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            System.out.println("Lista de Salas:");
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    public static boolean isDate(String pDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate myDate = LocalDate.parse(pDate, format);
            return myDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public static boolean isNumericPositive(String str) {
        int num;
        try {
            num = Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return false;
        }

        return num > 0;
    }

    public static boolean isNumericBetween(int a, int b, String str) {
        int num;
        try {
            num = Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return false;
        }

        return (num >= a && num <= b);
    }
}
