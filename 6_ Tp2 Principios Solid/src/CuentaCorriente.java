public class CuentaCorriente extends CuentaBancaria{

    private double limiteNegativo = 15000;

    public CuentaCorriente(String titular, double saldo, int idCuenta, double limiteNegativo) {
        super(titular, saldo, idCuenta);
        this.limiteNegativo = limiteNegativo;
    }

    @Override
    public void retirar(double monto){
        if (monto > (saldo + limiteNegativo)){
            throw new IllegalStateException("Valor invalido, excede el limite");
        }
        saldo -= monto;
    }
}
