package view.console;

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
            System.out.println("1- Dar de alta Usuarios ");
            System.out.println("2- Anadir una Pelicula");
            System.out.println("3- Crear Sala");
            System.out.println("4- Crear Sesion");
            System.out.println("5- Ver todas las Peliculas");
            System.out.println("6- Ver todas las Sesiones");
            System.out.println("7- Ver todas las Salas");
            System.out.println("8- Comprar Pelicula");
            System.out.println("9- Ver Usuarios");
            System.out.println("10- Ver Compras por Usuario");
            System.out.println("11- Borrar Usuario");
            System.out.println("0- Salir");
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
                    break;
                case "4":
                    break;
                case "5":
                    verTodasPeliculas();
                    break;
                case "6":
                    break;
                case "7":
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

    public static String validarCampoNoVacio(String campo) {
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
        String nombre = validarCampoNoVacio("nombre");
        String apellidos = validarCampoNoVacio("apellidos");
        String phone = validarTelefono();
        String email = validarEmail();
        String password = validarCampoNoVacio("contrasena");

        User user = new User(nombre, apellidos, phone, email, password);
        users.add(user);
        System.out.println("Usuario agregado exitosamente!");
    }

    public static int validarDuracion() {
        int duration = -1;

        while (duration <= 0) {
            System.out.println("Ingrese la duracion de la pelicula: ");
            if (keyboard.hasNextInt()) {
                duration = keyboard.nextInt();
                if (duration <= 0) {
                    System.out.println("La duracion debe ser un numero entero positivo. Intentelo de nuevo.");
                }
            } else {
                System.out.println("Entrada invalida. Por favor, ingrese un numero entero positivo.");
                keyboard.next();
            }
        }
        return duration;
    }

    public static void anadirPelicula() {

        String title = validarCampoNoVacio("Titulo Pelicula");
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
    
    public static void crearSala(){
        
    }
    

   
    
    public static void verTodasSalas(){
    
    }
    
}
