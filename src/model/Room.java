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
    private int numAsientos;
    private boolean[] asientos;
    private int numAsientosVip;
    private boolean[] asientosVip;

    public Room(String numSala, int asientos, int asientosVip) {
        this.numSala = numSala;
        this.numAsientos = asientos;
        this.numAsientosVip = asientosVip;
        this.asientos = new boolean[asientos];
        this.asientosVip = new boolean[asientos];
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public int getNumAsientosVip() {
        return numAsientosVip;
    }

    public void setNumAsientosVip(int numAsientosVip) {
        this.numAsientosVip = numAsientosVip;
    }

    public void setAsiento(int index, boolean value) {
        this.asientos[index] = value;
    }

    public void setAsientoVip(int index, boolean value) {
        this.asientosVip[index] = value;
    }

    public boolean getAsiento(int index) {
        return this.asientos[index];
    }

    public boolean getAsientoVip(int index) {
        return this.asientosVip[index];
    }

    @Override
    public String toString() {
        return "Room{" + "numSala=" + numSala + ", asientos=" + numAsientos + "\n" + summaryAsientos() +", asientosVip=" + numAsientosVip + "\n" + summaryAsientosVip()+'}';
    }

    public String summaryAsientos() {
        String text = "";
        String variable;
        int index = 0;
        for (boolean value : asientos) {
            if (value) {
                variable = "X";
            } else {
                variable = " ";
            }
            text += "[" + variable + "]";
            index++;
            if (index % 10 == 0) {
                text += "\n";
            }
        }
        return text;
    }
    public String summaryAsientosVip() {
        String text = "";
        String variable;
        int index = 0;
        for (boolean value : asientosVip) {
            if (value) {
                variable = "X";
            } else {
                variable = " ";
            }
            text += "[" + variable + "]";
            index++;
            if (index % 10 == 0) {
                text += "\n";
            }
        }
        return text;
    }

}
