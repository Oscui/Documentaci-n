package dam.programacion;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una Oficina
 * @see dam.programacion.Persona*/
public class Oficina {
    private String nombre;
    private ArrayList<Persona> trabajadores;
    
    /**
     * Constructor secundario
     * Crea una oficina que se llama como indica el nombre recibido, y 
    la lista de trabajadores está vacía.
    * @param n Nombre de la oficina
    */
    private Oficina(String n){
        nombre= n;
        trabajadores= new ArrayList<>();
    }
    
    
    /**
     * Constructor principal
     * Crea una oficina que se llama como indica el nombre recibido, y un tipo
     * @param n Nombre de la oficina
     * @param tipo Tipo
     */
    private Oficina(String n, int tipo){
        nombre= n;
        trabajadores= new ArrayList<>();
        
        if(tipo>0 && tipo<=3){
            List<Persona> personas= List.of(
                                    new Persona("Antonio Pérez Pérez", 
                                    new DNI(11111111, 'H'),
                                  900,
                                 LocalDate.of(2000,2,28)),
                
                                    new Persona("Luis López López", 
                                    new DNI(22222222, 'J'),
                                  1000,
                                 LocalDate.of(1995,9,10)),
                                    
                                    new Persona("Ana Díaz Díaz", 
                                    new DNI(33333333, 'P'),
                                  1200,
                                 LocalDate.of(1985,5,21)));
            
            for(int i=0;i<tipo;i++){
                trabajadores.add(personas.get(i));
            }    
        }
    }
    
    
    /**Crea una oficina llamada "Industrias DAM", que es de tipo 3.*/
    private Oficina(){
        this("Industrias DAM", 3);
    }
    
    //////////////////////////////////////////////
    //Ejercicio 27//
    //////////////////////////////////////////////
    
    /**Devuelve una oficina de tipo 0
     * @param n Nombre de la oficina*/
    public static Oficina getOficinaVacia(String n){
        return new Oficina(n);
    }
    
    /**Devuelve una oficina de tipo 1
     * @param n Nombre de la oficina*/
    public static Oficina getOficinaSmall(String n){
        return new Oficina(n,1);
    }
    
    /**Devuelve una oficina de tipo 2
     * @param n Nombre de la oficina*/
    public static Oficina getOficinaMediana(String n){
        return new Oficina(n,2);
    }
    
    /**Devuelve una oficina de tipo 3
     * @param n Nombre de la oficina*/
    public static Oficina getOficinaGrande(String n){
        return new Oficina(n,3);
    }
    
    //////////////////////////////////////////
    
    /**Añade a la oficina el trabajador pasado como parámetro.
     * @param p Empleado que se va a añadir*/
    public void addEmpleado(Persona p){
        trabajadores.add(p);
    }
    
    /**Crea una persona con los parámetros recibidos y la añade a la oficina.
     * @param nombre Nombre del empleado
     * @param DNI DNI del empleado en String
     * @param sueldo Sueldo del empleado
     * @param fechaNac Fecha de nacimiento del empleado
     */
    public void addEmpleado(String nombre, String DNI, double sueldo, LocalDate fechaNac){
        trabajadores.add(new Persona(nombre, 
                Integer.parseInt(DNI.substring(0, 8)),
                DNI.charAt(8), sueldo, fechaNac));
    
    }
    
    //Añadido del ejercicio 14
    /**Devuelve el número de trabajadores que hay en la oficina*/
    public int getTotalEmpleados(){
        return trabajadores.size();
    }
    
    /**Devuelve el número de trabajadores que son mileuristas.
     * @return Número de empleados mileuristas*/
    public int getTotalEmpleadosMileuristas(){
        int contador= 0;
        for(int i=0;i<trabajadores.size();i++){
            if(trabajadores.get(i).esMileurista()){
                contador++;
            }
        }
        return contador;
    }
    
    /**Devuelve una lista formada por todos los empleados que son mileuristas
     * @return Lista de empleados mileuristas*/
    public List<Persona> getMileuristas(){
        List<Persona> listaM= new ArrayList<>();
        for(int i=0;i<trabajadores.size();i++){
            Persona trabajador= trabajadores.get(i);
            if(trabajador.esMileurista()){
                listaM.add(trabajador);
            }
        }
        return listaM;
    }
    
    /**Devuelve true si la persona pasada como parámetro trabaja en la empresa.
     * @param p Persona que queremos comprobar si trabaja en la empresa
     * @return True si trabaja en la empresa*/
    public boolean trabaja(Persona p){
        return trabajadores.contains(p);
    }
    
    /**Hace que todos los empleados cobren su sueldo.*/
    public void pagarEmpleados(){
        for(Persona i: trabajadores){
            i.cobrarSueldo();
        }
    }
    
    /**Muestra por pantalla un listado con todos los empleados de la empresa. 
     * Por cada empleado se mostrará su nombre, su sueldo y si es mileurista.*/
    public void mostrarInformeEmpleados(){
        for(Persona i: trabajadores){
            //Muestra el número de empleado
            System.out.println("Empleado "+(trabajadores.indexOf(i)+1));
            //Muestra el nombre, sueldo y si es mileurista
            System.out.println(i.getNombre()+"\n"+i.getSueldo()+"\n"
                                +(i.esMileurista() ? "Es mileurista" : "No es mileurista"));
        }
    }
    
    /**getSueldoMedio: Devuelve la media de los sueldos de todos los empleados 
     * de la oficina. Si la oficina no tiene empleados el método lanza una excepción.
     * @return Media de los suel
     * @throws Exception*/
    public double getSueldoMedio() throws Exception{
        if(trabajadores.isEmpty()){
            throw new Exception();
        }else{
            double acumulador= 0;
            for(Persona i: trabajadores){
                acumulador +=i.getSueldo();
            }
            return acumulador/trabajadores.size();
        }
    }
}