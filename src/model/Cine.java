/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joaquimpinsot
 */
public class Cine {

    private ArrayList<User> users;
    private ArrayList<Film> films;
    private ArrayList<Session> sessions;
    private ArrayList<SesionDiaria> calendario;
    private ArrayList<Room> rooms;
    private User sesionUsuario;
    private int intentos;

    public Cine(ArrayList<User> users, ArrayList<Film> films, ArrayList<Session> sessions, ArrayList<SesionDiaria> calendario, ArrayList<Room> rooms, User sesionUsuario) {
        this.users = users;
        this.films = films;
        this.sessions = sessions;
        this.calendario = calendario;
        this.rooms = rooms;
        this.sesionUsuario = sesionUsuario;
        this.intentos = 3;
    }

    public Cine() {
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(User newUser) {
        this.users.add(newUser);
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(Film newFilm) {
        this.films.add(newFilm);
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Session newSession) {
        this.sessions.add(newSession);
    }

    public ArrayList<SesionDiaria> getCalendario() {
        return calendario;
    }

    public void setCalendario(SesionDiaria newSesionDiaria) {
        this.calendario.add(newSesionDiaria);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Room newRoom) {
        this.rooms.add(newRoom);
    }

    public User getSesionUsuario() {
        return sesionUsuario;
    }

    public void setSesionUsuario(User sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean validarTelefono(String phone) {
        String result = phone.replaceAll("[ -]", "");
        return (result.length() == 9 && result.matches("\\d+"));
    }

    public boolean validarEmail(String correo) {
        // Expresión regular para validar un correo electrónico
        String expresionRegular = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compilamos la expresión regular
        Pattern pattern = Pattern.compile(expresionRegular);

        // Verificamos si el correo cumple con la expresión regular
        Matcher matcher = pattern.matcher(correo);

        // Retornamos el resultado de la validación
        return matcher.matches();
    }

    public boolean isEmailUsed(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTitleUsed(String title) {
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean canLogin(String email, String password) {
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

    public boolean isRoomNumberUsed(String numSala) {
        for (Room room : rooms) {
            if (room.getNumSala().equals(numSala)) {
                return true;
            }
        }
        return false;
    }

    public Film obtenerPelicula(String nombre) {
        for (Film film : films) {
            if (film.getTitle().equals(nombre)) {
                return film;
            }
        }
        return null;
    }

    public boolean isDate(String pDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate myDate = LocalDate.parse(pDate, format);
            return myDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public boolean isNumericPositive(String str) {
        int num;
        try {
            num = Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return false;
        }

        return num > 0;
    }

    public boolean isNumericBetween(int a, int b, String str) {
        int num;
        try {
            num = Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return false;
        }

        return (num >= a && num <= b);
    }

    public boolean validarStringNoVacio(String str) {
        return str.replaceAll("[ ]", "").length() > 0;
    }

    public static boolean validarSoloLetras(String str) {
        return str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")&&str.replaceAll(" ","").length()>0;
    }
}
