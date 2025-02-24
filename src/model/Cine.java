/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

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
    
    
    
}
