public class CajaAhorro extends  CuentaBancaria {

    public CajaAhorro(String titular, double saldo, int idCuenta) {
        super(titular, saldo, idCuenta);
    }

    @Override
    public void retirar(double monto){
        if (monto > saldo){
            throw new IllegalStateException("Monto invalido");
        }
        saldo -= monto;
    }

}