package model;

import java.util.ArrayList;
import model.*;

public class Users extends UserWithDiscount {

    private String Nombre;
    private String Apellidos;
    private String Phone;
    private String Cuenta_Banco;
    private ArrayList Compras;

    public Users() {
    }

    public Users(String Nombre, String Apellidos, String Phone, String Cuenta_Banco, ArrayList Compras) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Phone = Phone;
        this.Cuenta_Banco = Cuenta_Banco;
        this.Compras = Compras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCuenta_Banco() {
        return Cuenta_Banco;
    }

    public void setCuenta_Banco(String Cuenta_Banco) {
        this.Cuenta_Banco = Cuenta_Banco;
    }

    public ArrayList getCompras() {
        return Compras;
    }

    public void setCompras(ArrayList Compras) {
        this.Compras = Compras;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users{");
        sb.append("Nombre=").append(Nombre);
        sb.append(", Apellidos=").append(Apellidos);
        sb.append(", Phone=").append(Phone);
        sb.append(", Cuenta_Banco=").append(Cuenta_Banco);
        sb.append(", Compras=").append(Compras);
        sb.append('}');
        return sb.toString();
    }
}
