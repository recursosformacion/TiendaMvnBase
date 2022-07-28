package es.rf.tienda.exception;

public class DAOException extends Exception {
	
	public DAOException(){
		super();
	}
	
	public DAOException(String mensaje){
		super(mensaje);
	}
}
