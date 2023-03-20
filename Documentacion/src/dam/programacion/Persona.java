package dam.programacion;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa una persona
 * @see dam.programacion.CuentaCorriente
 * @see dam.programacion.DNI*/
public class Persona {
    
    private String nombre;
    private DNI dni;
    private double sueldo;
    private LocalDate fechaNacimiento;
    private CuentaCorriente cuenta;
    
    //Constructor principal
    /** Crea una persona a partir de su nombre, número, letra de DNI, sueldo y 
    fecha de nacimiento pasada como parámetro
    * 
    * @param n Nombre de la persona
    * @param numDNI Parte númerica del DNI
    * @param letraDNI Letra del DNI
    * @param s Sueldo
    * @param fn Fecha de nacimiento
     */
    public Persona(String n, int numDNI, char letraDNI, double s, LocalDate fn){
        nombre= n;
        dni= new DNI(numDNI, letraDNI);
        sueldo= s;
        fechaNacimiento= fn;
        cuenta= new CuentaCorriente();
    }
    
    //Constructores secundarios
    /**Crea una persona a partir de su nombre, DNI, sueldo y fecha de 
    nacimiento pasadas como parámetros.
    * @param n Nombre de la persona
    * @param d DNI
    * @param s Sueldo
    * @param fn Fecha de nacimiento
     */
    public Persona(String n, DNI d, double s, LocalDate fn){
        this(n, d.getNumDNI(), d.getLetraDNI(), s, fn);
    }
            
    /**Crea una persona cuyo nombre y DNI se pasan como parámetro, gana 900 
    euros y ha nacido hace 20 años.
    * @param n Nombre de la persona
    * @param d DNI
     */
    //La fecha de hoy pero hace 20 años
    public Persona(String n, DNI d){
        
        this(n, d.getNumDNI(), d.getLetraDNI(), 900, LocalDate.of(
                                    LocalDate.now().getYear()-20, 
                               LocalDate.now().getMonth(), 
                           LocalDate.now().getDayOfMonth()));
    }
    
    /**Crea una persona cuyo nombre, número y letra de DNI se pasan como
    parámetro, gana 900 euros y ha nacido hace 20 años.
    * @param n Nombre de la persona
    * @param numDNI Parte númerica del DNI
    * @param letraDNI Letra del DNI
    */
    //La fecha de hoy pero hace 20 años
    public Persona(String n, int numDNI, char letraDNI){
        this(n, new DNI(numDNI, letraDNI));
    }
    
    /**Aumenta el sueldo del empleado el porcentaje indicado como parámetro. 
     * Por ejemplo, si el sueldo es 1000 y se llama al método pasando un 50, 
     * el sueldo final del empleado será 1500.
     
     *@param porcentaje Porcentaje que se aumenta el sueldo*/
    
    public void aumentarSueldo(int porcentaje){
        sueldo += (int)(sueldo*((double)porcentaje/100));
    }
    
    /**Añadirá al empleado su sueldo en su cuenta corriente.*/
    //!!sueldo es double y el método solo acepta int
    public void cobrarSueldo(){
        cuenta.addDinero((int)sueldo);
    }
    
    //Métodos añadidos en el ejercicio 12
    
    //Getters o accesors
    public String getNombre(){
        return nombre;
    }
    
    public DNI getDNI(){
        return dni;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    
    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public CuentaCorriente getCuentaCorriente(){
        return cuenta;
    }
    
    /**Devuelve true si la persona es mayor de 18 años.
     * @return True si es mayor de 18 años*/
    
    //! Creo que falla si la persona cumple hoy 18 años
    public boolean esMayorEdad(){
        int edad= Period.between(fechaNacimiento, LocalDate.now()).getYears();
        
        return edad>=18;
    }
    
    /** Devuelve true si la cuenta corriente del empleado tiene saldo positivo.
     * @return true si el saldo es positivo
     */
    //! Y si es saldo es 0?
    public boolean tieneDinero(){
        return cuenta.saldo>0;
    }
    
    /** Devuelve true si la persona gana menos de 1200 euros
     * @return true si gana menos de 1200 euros
     */
    public boolean esMileurista(){
        return sueldo<1200;
    }
}