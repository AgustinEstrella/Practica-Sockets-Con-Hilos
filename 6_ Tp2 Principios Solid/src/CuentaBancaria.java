public abstract class CuentaBancaria {
    private String titular;
    private int idCuenta;
    protected double saldo;

    public CuentaBancaria(String titular, double saldo, int idCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.idCuenta = idCuenta;
    }

    public void depositar(double monto){
        if (monto < 0){
            throw new IllegalArgumentException("Valor invalido");
        }
        saldo += monto;
        System.out.println("Depositado $" +monto);
    }

    public abstract void retirar(double monto);

    public String getTitular() {
        return titular;
    }
    public int getIdCuenta() {
        return idCuenta;
    }
    public double getSaldo() {
        return saldo;
    }

}