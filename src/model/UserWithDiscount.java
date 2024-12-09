
package model;

public class UserWithDiscount {
    private int Descuento;

    public UserWithDiscount(int Descuento) {
        this.Descuento = Descuento;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserWithDiscount{");
        sb.append("Descuento=").append(Descuento);
        sb.append('}');
        return sb.toString();
    }
    
    
}
