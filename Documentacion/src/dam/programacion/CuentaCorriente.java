package dam.programacion;

import java.util.Random;

public class CuentaCorriente{
    public int numero;
    public double saldo;
    
    //Constructor principal
    /**Crea una cuenta corriente cuyo número de cuenta se pasa como parámetro y 
     * tiene el saldo indicado como parámetro.
     * @param numero Número de cuenta
     * @param saldo Saldo de la cuenta
     */
    public CuentaCorriente(int numero, double saldo){
        this.numero= numero;
        this.saldo= saldo;
    }
    
    //Constructores secundarios
    /**Crea una cuenta corriente cuyo número de cuenta se pasa como parámetro 
     * y tiene saldo 0 euros.
     * @param numero Número de cuenta
     */
    public CuentaCorriente(int numero){
        this(numero, 0);
    }
    
    
    /**Crea una cuenta con número aleatorio entre 0 y 1000, y saldo 0.*/
    public CuentaCorriente(){
        this(new Random().nextInt(0, 1001));
    }
    
    /**Añaden a la cuenta la cantidad indicada
     * @param cantidad Cantidad que se añade*/
    public void addDinero(int cantidad){
        saldo += cantidad;
    }
    
    /**Retira de la cuenta la cantidad indicada
     * @param cantidad Cantidad que se retira
     * @throws Exception Si el saldo a retirar es superior al saldo*/
    public void retirarDinero(int cantidad) throws Exception{
        if(cantidad>saldo){
            throw new Exception();
        }else{
            saldo -= cantidad;
        }
    }
}
