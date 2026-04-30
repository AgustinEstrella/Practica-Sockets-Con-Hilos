import java.net.SocketTimeoutException;
import java.util.InputMismatchException;

public class ModeloPersona {

    String nombre;
    String apellido;
    String dni;
    String pasaporte;
    String telefono;
    String direccion;
    String cp;

    public ModeloPersona() {
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        //Sacamos los espacios vacios al comienzo y final, para evitar cosas como (   Estrella   )
        nombre = nombre.trim();

        if (nombre.length() < 3 || nombre.length() > 20){
            throw new IllegalArgumentException("El nombre debe tener entre 3 y 20 caracteres");
        }

        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$")){
            throw new IllegalArgumentException("El nombre solo debe contener letras");
        }

        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {

        if (apellido == null || apellido.isBlank()){
            throw new IllegalArgumentException("El apellido no puede estar vacio");
        }

        //Sacamos los espacios vacios al comienzo y final, para evitar cosas como (   Estrella   )
        apellido = apellido.trim();

        if (apellido.length() < 3 || apellido.length() > 20){
            throw new IllegalArgumentException("El apellido debe tener entre 3 y 20 caracteres");
        }

        if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$")){
            throw new IllegalArgumentException("El apellido solo debe contener letras");
        }

        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {

        //Si no ponemos dni lo deja vacio
        if (dni == null || dni.isBlank()){
            this.dni = "";
            return;
        }

        dni = dni.trim();

        if (!dni.matches("^[0-9]{8}$")){
            throw new IllegalArgumentException("El dni debe tener 8 numeros");
        }

        //Convierte el dni String a un int para verificar los limites de ingreso
        int dniEnNumero = Integer.parseInt(dni);
        if (dniEnNumero < 10000000 || dniEnNumero > 60000000){
            throw new IllegalArgumentException("El rango de numero del DNI debe ser entre 10.000.000 y 60.000.000");
        }

        this.dni = dni;
    }

    public String getPasaporte() {
        return pasaporte;
    }
    public void setPasaporte(String pasaporte) {

        if (pasaporte == null || pasaporte.isBlank()){
            this.pasaporte = "";
            return;
        }

        pasaporte = pasaporte.trim();

        if (!pasaporte.matches("^[A-Z][0-9]{8}$")){
            throw new IllegalArgumentException("El pasaporte debe comenzar con una letra A-Z y 8 numeros seguidos");
        }

        //Extraigo los numeros del pasaporte
        String parteNumerica = pasaporte.substring(1);
        //Convierto el string de numeros a un int
        int numerosPasaporte = Integer.parseInt(parteNumerica);

        if (numerosPasaporte < 10000000 || numerosPasaporte > 60000000){
            throw new IllegalArgumentException("El numero del pasaporte no puede ser menor que 10.000.000 o mayor que 60.000.000");
        }

        this.pasaporte = pasaporte;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {

        if (telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("El numero de telefono no puede estar vacio");
        }

        telefono = telefono.trim();

        if (!telefono.matches("^\\+54[0-9]{7,12}$")){
            throw new IllegalArgumentException("El numero de telefono debe ingresarse todo junto, tener mas de 6 digitos y debe incluir +54");
        }

        this.telefono = telefono;
    }

    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {

        if (cp == null || cp.isBlank()){
            throw new IllegalArgumentException("El codigo postal no puede estar vacio");
        }

        cp = cp.trim();

        if (!cp.matches("^[0-9]{4}$")) {
            throw new IllegalArgumentException("El código postal debe tener exactamente 4 dígitos numéricos (ej: 5500)");
        }

        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {

        if (direccion == null || direccion.isBlank()){
            throw new IllegalArgumentException("La direccion no puede estar vacia");
        }

        direccion = direccion.trim();

        if (direccion.length() > 50){
            throw new IllegalArgumentException("Direccion invalida, max 50 caracteres");
        }

        this.direccion = direccion;
    }

    public boolean tieneIdentificacion(){
        boolean tieneDni = this.dni != null && !this.dni.isBlank();
        boolean tienePasaporte = this.pasaporte != null && !this.pasaporte.isBlank();

        return tieneDni || tienePasaporte;
    }

}