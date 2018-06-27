package co.com.ceiba.CeibaEstacionamiento.exception;

public class CeibaException extends RuntimeException{

	private static final long serialVersionUID = 1937444020634155410L;
	
	public CeibaException(String mensaje) {
		super(mensaje);
	}
}
