/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joaquimpinsot
 */
public class Room {
    private String numSala;
    private int asientos;
    private int asientosVip;

    public Room(String numSala, int asientos, int asientosVip) {
        this.numSala = numSala;
        this.asientos = asientos;
        this.asientosVip = asientosVip;
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public int getAsientosVip() {
        return asientosVip;
    }

    public void setAsientosVip(int asientosVip) {
        this.asientosVip = asientosVip;
    }

    @Override
    public String toString() {
        return "Room{" + "numSala=" + numSala + ", asientos=" + asientos + ", asientosVip=" + asientosVip + '}';
    }
    
}
