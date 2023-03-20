package dam.programacion;


/**Clase que representa un <b>DNI</b>*/
public class DNI {
    private int numero;
    private char letra;
    
    /**Constructor principal del DNI
     * @param n Numero del DNI
     * @param l Letra del DNI*/
    public DNI(int n, char l){
        numero= n;
        letra= l;
    }
    
    /**Constructor secundario del DNI
     * @param dni String completo del DNI (numero y letra juntos)*/
    public DNI(String dni){
        this(Integer.parseInt(dni.substring(0,7)), 
                dni.charAt(8));
    }
    
    /**
     * Getter para el numero del DNI
     * @return numero del DNI*/
    public int getNumDNI(){
        return numero;
    }
    
    /**
     * Getter para la letra del DNI
     * @return letra del DNI*/
    public char getLetraDNI(){
        return letra;
    }
}