package Classes;

public class Guitarra extends Instrumento{
    private int cantCuerdas;

    public Guitarra (int cantCuerdas, int stock, double precio, String marca, String modelo){
        super(precio, marca, modelo, stock);
        this.cantCuerdas = cantCuerdas;
    }

    public int getCantCuerdas(){
        return cantCuerdas;
    }


}
