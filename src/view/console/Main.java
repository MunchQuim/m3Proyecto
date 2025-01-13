package view.console;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.*;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Film> films = new ArrayList<>();
    static ArrayList<Session> sessions = new ArrayList<>();
    static ArrayList<SesionDiaria> calendario = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static User sesionUsuario;

    public static void main(String[] args) {
        keyboard.useDelimiter("\n");
        String opcionStr;

        do {
            System.out.println("1- Dar de alta Usuarios ");//hecho
            System.out.println("2- Anadir una Pelicula");//hecho
            System.out.println("3- Crear Sala"); //hecho
            System.out.println("4- Crear Sesion"); // hecho
            System.out.println("5- Ver todas las Peliculas");//hecho
            System.out.println("6- Ver todas las Sesiones");//hecho
            System.out.println("7- Ver todas las Salas"); //hecho
            System.out.println("8- Comprar Pelicula");// iniciar sesion con mail y contraseña // que al buscar un dia se creen la sesionDiaria para ese dia y los asientos para la sesionDiaria.-Quim
            System.out.println("9- Ver Usuarios");//hecho
            System.out.println("10- Ver Compras por Usuario");//hecho
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
                    crearSesion();
                    break;
                case "5":
                    verTodasPeliculas();
                    break;
                case "6":
                    verTodasSesiones();
                    break;
                case "7":
                    verTodasSalas();
                    break;
                case "8":
                    if (iniciarSesion()) {
                        comprarPelicula();
                    }

                    break;
                case "9":
                    verUsuarios();
                    break;
                case "10":
                    verComprasPorUsuario();
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
        String email;
        boolean isValid;
        do {
            System.out.println("Ingrese email:");
            email = keyboard.next();
            isValid = esCorreo(email) && !isEmailUsed(email);
            if (!isValid) {
                System.out.println("Correo no valido o ya en uso. Introduce un correo electronico valido:");
            }
        } while (!isValid);

        return email.trim();
    }

    public static boolean esCorreo(String correo) {
        // Expresión regular para validar un correo electrónico
        String expresionRegular = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compilamos la expresión regular
        Pattern pattern = Pattern.compile(expresionRegular);

        // Verificamos si el correo cumple con la expresión regular
        Matcher matcher = pattern.matcher(correo);

        // Retornamos el resultado de la validación
        return matcher.matches();
    }

    public static boolean isEmailUsed(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    sesionUsuario = user;
                    return true;
                }
            }
        }
        return false;
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

    public static void crearSesion() {
        Film pelicula = validarPelicula();
        LocalTime horaInicio = validarLocalTime();
        Room sala = validarSala();//continuar

        Session sesion = new Session(pelicula, horaInicio, sala);
        sessions.add(sesion);
        System.out.println("Sesion agregada exitosamente!");
    }

    public static void verTodasSesiones() {
        for (Session sesion : sessions) {
            sesion.toString();
        }
    }

//    public static int validarAsientos(String tipoAsiento) {
//        int numAsientos = 0;
//        boolean isValid = false;
//    public static int validarNumeroAsientos(String tipoAsiento, int maxAsientos) {
//        int numAsientos = -1;
//        String strAsientos;
//        while (numAsientos < 0 || numAsientos > maxAsientos) {
//            //solicitar al usuario que ingrese el num de asientos
//            System.out.println("Ingrese " + tipoAsiento + " (Maximo " + maxAsientos + "): ");
//            strAsientos = keyboard.next();
//            // verificar si la entrada es un numero positivo
//            if (isNumericPositive(strAsientos)) {
//                numAsientos = Integer.parseInt(strAsientos);
//                //validar que el numero de asientos no exceda el maximo permitido
//                if (numAsientos > maxAsientos) {
//                    System.out.println("Entrada invalida. El número de asientos no puede exceder de " + maxAsientos + ".");
//                }
//            } else {
//                System.out.println("Entrada invalida. Por favor, ingrese un número entero positivo.");
//            }
//        }
//        return numAsientos;
//    }
    public static void verComprasPorUsuario() {
        for (User user : users) {
            user.getInfoTickets();
        }
    }

    public static boolean isRoomNumberUsed(String numSala) {
        for (Room room : rooms) {
            if (room.getNumSala().equals(numSala)) {
                return true;
            }
        }
        return false;
    }

    public static boolean iniciarSesion() {
        // si hay sesion iniciada
        //preguntar si quieres comprar una pelicula con el usuario X (email)
        // si sí, nada, si no, borra la sesion;
        //si no hay sesion iniciada
        // con que usuario quieres iniciar sesion (email)
        // inserte la contraseña
        // si es correcta, no entra en el bucle y guarda la sesion en sesion usuario
        // si no es correcta, contraseña no correcta, quiere seguir intentandolo?
        // si si, continua
        // si no, sale al menu
        if (sesionUsuario != null) {
            String respuesta = "";
            do {
                System.out.println("Has iniciado sesion con " + sesionUsuario.getEmail());
                System.out.println("Quieres comprar una pelicula con este usuario? s/n");
                respuesta = keyboard.next().toLowerCase();
            } while (!respuesta.equals("s") && !respuesta.equals("n"));

            if (respuesta.equals("n")) {
                sesionUsuario = null;
            }
        }
        if (sesionUsuario == null) {
            String email = "";
            String respuesta = "";
            String password = "";
            boolean buclePedirCorreo = true;
            boolean buclePedirContrasena = true;
            do {
                System.out.println("Vamos a iniciar tu sesion");
                System.out.println("Necesito tu correo electronico");
                email = keyboard.next();
                if (!isEmailUsed(email)) {
                    do {
                        System.out.println("Correo desconocido, quieres volverlo a intentar? s/n");
                        respuesta = keyboard.next().toLowerCase();
                    } while (!respuesta.equals("s") && !respuesta.equals("n"));
                    if (respuesta.equals("n")) {
                        System.out.println("saliendo..");
                        return false;
                    }
                } else {
                    buclePedirContrasena = false;
                }
            } while (buclePedirCorreo);
            do {
                System.out.println("Necesito tu contraseña");
                password = keyboard.next();
                if (!login(email, password)) {
                    do {
                        System.out.println("contraseña erronea, quieres volverlo a intentar? s/n");
                        respuesta = keyboard.next().toLowerCase();
                    } while (!respuesta.equals("s") && !respuesta.equals("n"));
                    if (respuesta.equals("n")) {
                        System.out.println("saliendo..");
                        return false;
                    }
                } else {
                    System.out.println("Sesion iniciada como " + sesionUsuario.getEmail());
                    buclePedirContrasena = false;
                }
            } while (buclePedirContrasena);
        }
        return true;
    }

    public static void comprarPelicula() {
        if (!films.isEmpty()) {
            verTodasPeliculas();
            
            //escoger la pelicula
            // ver todas las sesiones
            //para escoger una sesion
            //y escoger un dia
            // si la sesion diaria no existe toca crearla con todos sus asientos
            
            //escoger un tipo de asiento
            //visualizar todos los disponibles y comprar uno valido;
            //

        }
    }
    public static void crearSesionDiaria(Session sesion,LocalDate dia){
        //se crea un arraylist de Asientos llamado asientosNormales;
        //se crea un arraylist de Asientos llamado asientosVip;
        //se crea un arraylist de Asientos llamado asientosAdaptados;
        
        //a traves de la sesion, vamos a la sala asignada, y la sala asignada, tiene el numero de asientos de cada tipo
        // se hacen 3 bucles for de la longitud del numero de asientos y por cada uno de ellos crea un asiento, con (enum TipoAsientosEnum,....
        //....indice del bucle+1, false, el objeto sala asignado a la sesion.) que se añaden al array.
        // y ya;
            
    }
    public static int validarAsientos(String tipoAsiento) {
        int numAsientos;
        do {
            System.out.println("Numero de asientos " + tipoAsiento + " (Maximo 50): ");
            numAsientos = keyboard.nextInt();
        } while (!isNumericBetween(1, 50, String.valueOf(numAsientos)));
        return numAsientos;
    }
    public static void crearSala() {
        String numSala = validarStringNoVacio("Numero de Sala");
        if (isRoomNumberUsed(numSala)) {
            System.out.println("Error: El numero de sala ya esta en uso. Por favor, elige otro numero.");
            return;
        }
 
        int numAsientos = validarAsientos("normales");
        int numAsientosVip = validarAsientos("VIP");
        int numAsientosAdaptados = validarAsientos("adaptados");
 
        Room room = new Room(numSala, numAsientos, numAsientosVip, numAsientosAdaptados);
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

    public static Room validarSala() { //devuelve una sala validada
        System.out.println("Estas son todas nuestras salas");
        verTodasSalas();
        String numSala;
        Room sala = null;
        do {
            System.out.println("Que numero de sala vas a usar");
            numSala = keyboard.next();
            for (Room room : rooms) {
                if (room.getNumSala().equals(numSala)) {
                    sala = room;
                }
            }
        } while (sala == null);
        return sala;
    }

    public static Film validarPelicula() {
        String input;
        Film pelicula = null;
        do {
            verTodasPeliculas();
            System.out.println("Ingrese el nombre de la pelicula:");
            input = keyboard.next();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("El campo no puede estar vacio. Por favor, intentalo de nuevo.");
            } else {
                for (Film film : films) {
                    if (film.getTitle().equals(input)) {
                        pelicula = film;
                    }
                }
                if (pelicula == null) {
                    System.out.println("Inserte una pelicula correcta");
                }
            }
        } while (pelicula == null);

        return pelicula;
    }

    public static LocalTime validarLocalTime() {
        String strHora = null;
        String strMinutos = null;
        System.out.println("Voy a necesitar la hora y luego los minutos del localTime");
        do {
            System.out.println("Cual es la hora");
            strHora = keyboard.next();
        } while (!isNumericBetween(0, 23, strHora));
        do {
            System.out.println("cuales son los minutos");
            strMinutos = keyboard.next();
        } while (!isNumericBetween(0, 59, strMinutos));
        int hora = Integer.parseInt(strHora);
        int minuto = Integer.parseInt(strMinutos);
        LocalTime localtime = LocalTime.of(hora, minuto);
        return localtime;
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
