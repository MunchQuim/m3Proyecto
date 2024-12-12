/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.TipoAsientosEnum;
import model.Room;
/**
 *
 * @author joaquimpinsot
 */
public final class Asiento {
    private TipoAsientosEnum tipoAsiento;
    private int index;
    private int cantidad;
    private boolean estaOcupado;
    private double precio;
    private Room sala;

    public TipoAsientosEnum getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsientosEnum tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Room getSala() {
        return sala;
    }

    public void setSala(Room sala) {
        this.sala = sala;
    }

    public Asiento(TipoAsientosEnum tipoAsiento, int index, int cantidad, boolean estaOcupado, Room sala) {
        this.tipoAsiento = tipoAsiento;
        this.index = index;
        this.cantidad = cantidad;
        this.estaOcupado = estaOcupado;
        this.sala = sala;
        asignarPrecio();
    }
    
    public void asignarPrecio(){
        switch (this.tipoAsiento) {
            case Adaptado:
                this.precio = 5;
                break;
            case Normal:
                 this.precio = 10;
                break;
            case Vip:
                 this.precio = 15;
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
