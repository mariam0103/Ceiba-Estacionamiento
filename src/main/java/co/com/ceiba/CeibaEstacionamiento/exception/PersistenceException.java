package co.com.ceiba.CeibaEstacionamiento.exception;

public class PersistenceException extends RuntimeException{

	private static final long serialVersionUID = 4645391133745075889L;
	
	public PersistenceException(String mensaje) {
		super(mensaje);
	}

}
