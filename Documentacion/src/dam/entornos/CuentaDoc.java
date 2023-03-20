package dam.entornos;

/**
 * Clase CuentaDoc, para contener la informacion de cada una de las
 * de las cuentas bancarias
 * @version 3-2023
 * @author Jose Piñeiro (original)
 * @author Miriam Romero Sellamitou (adaptacion)
 * @since 20-03-2023
 */
public class CuentaDoc {
	private String numero; //Numero de la cuenta bancaria
	private float saldo; //Saldo de la cuenta bancaria en euros
	
	/**
	 * Constructor de la clase CuentaDoc con todos los parametros
	 * @param numCta Numero de la cuenta bancaria
	 * @param saldoCta Saldo inicial de la cuenta
	 */
	public CuentaDoc(String numCta, float saldoCta) {
		numero= numCta;
		saldo= saldoCta;
	}

	/**
	 * Metodo de seleccion del numero de la cuenta
	 * @return Numero de la cuenta bancaria
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Metodo de seleccion del saldo de la cuenta
	 * @return Saldo de la cuenta bancaria
	 */
	public float getSaldo() {
		return saldo;
	}
	
	/**
	 * Metodo de acceso al numero de la cuenta
	 * @param numCta Numero de la cuenta bancaria que se desea asignar
	 */
	public void setNumero(String numCta) {
		this.numero = numCta;
	}

	/**
	 * Metodo de acceso al saldo de la cuenta
	 * @param saldoCta Valor que se desea asignar al saldo de la cuenta bancaria
	 */
	public void setSaldo(float saldoCta) {
		this.saldo = saldoCta;
	}
	
	/**
	 * Metodo que ingresa dinero en la cuenta, incrementando su saldo
	 * @param importe Valor con que se desea incrementar el saldo
	 */
	public void ingresarSaldo(float importe) {
		saldo += importe;
	}
	
	/**
	 * Metodo que saca dinero en la cuenta, decrementando su saldo
	 * @param importe Valor con que se desea decrementar el saldo
	 * @throws IllegalArgumentException Si el importe a retirar es superior
	 *  al saldo actual de la cuenta
	 */
	public void retirarSaldo(float importe) {
		if(importe>saldo) {
			throw new IllegalArgumentException("El importe a retirar no puede ser superior al saldo");
		}
		/*//No se necesita else porque si salta la excepcion se termina el metodo*/
		saldo -= importe;
	}
	
	/**
	 * Metodo que muestra el numero de la cuenta y su saldo por pantalla
	 */
	public void mostrarCuenta() {
		System.out.println("Nº cuenta: "+ numero);
		System.out.println("Saldo: "+ saldo + " €");
	}
}