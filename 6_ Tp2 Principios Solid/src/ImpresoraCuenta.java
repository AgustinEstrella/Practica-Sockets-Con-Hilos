public class ImpresoraCuenta {

    public void mostrarDatosCuenta (CuentaBancaria persona){
        System.out.println("Nombre del titular: " +persona.getTitular());
        System.out.println("Id del titular: " +persona.getIdCuenta());
        System.out.println("Saldo de la cuenta: " +persona.getSaldo());
    }

}
