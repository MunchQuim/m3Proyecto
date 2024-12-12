package view.console;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Film> films = new ArrayList<>();

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
                default:
                    System.out.println("Opcion Incorrecta!");
            }
        } while (!opcionStr.equals("0"));
    }

    public static void darAltaUsuarios() {
        System.out.println("Ingrese nombre:");
        String nombre = keyboard.next();
        while (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacio.\nIngrese nombre:");
            nombre = keyboard.next();
        }

        System.out.println("Ingrese apellidos:");
        String apellidos = keyboard.next();
        while (apellidos.trim().isEmpty()) {
            System.out.println("Los apellidos no pueden estar vacios.\nIngrese apellidos:");
            apellidos = keyboard.next();
        }

        System.out.println("Ingrese telefono:");
        String phone = keyboard.next();
        while (!phone.matches("\\d{9}")) {
            System.out.println("El telefono debe ser un numero valido de 10 digitos.\nIngrese telefono:");
            phone = keyboard.next();
        }

        System.out.println("Ingrese email:");
        String email = keyboard.next();
        while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("El email debe tener un formato valido.\nIngrese email:");
            email = keyboard.next();
        }

        System.out.println("Ingrese contrasena:");
        String password = keyboard.next();
        while (password.trim().isEmpty()) {
            System.out.println("La contrasena no puede estar vacia.\nIngrese contrasena:");
            password = keyboard.next();
        }

        User user = new User(nombre, apellidos, phone, email, password, new ArrayList<>());
        users.add(user);
        System.out.println("Usuario agregado exitosamente!");
    }

    public static void anadirPelicula() {
        System.out.println("Ingrese Titulo de la Pelicula: ");
        String title = keyboard.next();
        while (title.trim().isEmpty()) {
            System.out.println("El titulo no puede estar vacio.\nIngrese Titulo de la Pelicula: ");
            title = keyboard.next();
        }

        System.out.println("Ingrese su duracion: ");
        while (!keyboard.hasNextInt()) {
            System.out.println("La duracion debe ser un numero entero positivo.\nIngrese su duracion: ");
            keyboard.next();
        }
        int duration = keyboard.nextInt();
        while (duration <= 0) {
            System.out.println("La duracion debe ser un numero entero positivo.\nIngrese su duracion: ");
            duration = keyboard.nextInt();
        }

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
}
