import java.util.spi.CalendarDataProvider;

public class AplicacionBancaria {
    public static void main(String[] args){

        //Expandimos CuentaBancaria ya que corrompia el principio de abierto/cerrado
        //abrimos la funcion retirar para que se pueda ampliar pero no modificar,
        //dividiendo la clase en CuentaCorriente y CajaAhorro, teniendo cada uno su manera de retirar
        //la clase CuentaBancaria no se cambia, sino que se puede cambiar la logica de cada tipo de cuenta
        CuentaBancaria cuenta1 = new CuentaCorriente("Pepe", 20000, 1, 10000);
        cuenta1.depositar(500);
        cuenta1.retirar(200);

        CuentaBancaria cuenta2 = new CajaAhorro("Juan", 20000, 2);
        cuenta2.depositar(500);
        cuenta2.retirar(200);

        //Creamos la clase ImpresoraCuenta porque rompia el principio de
        //responsabilidad unica, a la cuenta bancaria no se le debe
        //atribuir el funcionamiento de un sistema de impresion
        ImpresoraCuenta impresora = new ImpresoraCuenta();
        impresora.mostrarDatosCuenta(cuenta1);
        impresora.mostrarDatosCuenta(cuenta2);

        //Creamos la clase InboxMail porque rompia el principio de
        //responsabilidad unica, a la cuenta bancaria no se le debe
        //atribuir el funcionamiento de un sistema de e-mails
        InboxMail inbox = new InboxMail();
        inbox.enviarNotificacionPorMail(cuenta1, "Notificacion enviada!");
        inbox.enviarNotificacionPorMail(cuenta2, "Notificacion enviada!");

    }
}