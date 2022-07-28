package es.rf.tienda.dominio;

import java.util.Calendar;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

public class Usuario {
private int id_usuario;				// identificador de usuario
	
	private String user_nombre;			// nombre de usuario
	
	private String user_email;			// Correo electronico del usuario
	
	private String user_pass;			// Contraseña del usuario
	
	private String user_tipo;			// Tipo de usuario
	
	private String user_dni;			// DNI del usuario
	
	private Calendar user_fecAlta;			// Fecha alta
	
	private Calendar user_fecConfirmacion;	// Fecha en que confirma el correo
	
	private Direccion  user_pago;		// Datos direccion de pago
	
	private Direccion  user_envio;		// Datos direccion de envio
	
	/**
	 * Longitud nombre usuario
	 * 
	 */
	public static final int USER_NOMBRE_LONG_MIN = 5;
	public static final int USER_NOMBRE_LONG_MAX = 100;
	
	/**
	 * Longitud correo electronico
	 * 
	 */
	public static final int USER_EMAIL_LONG_MIN = 6;
	public static final int USER_EMAIL_LONG_MAX = 100;

	/**
	 * @return el id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * @param id_usuario el id_usuario a establecer
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @param user_nombre 
	 * @return el user_nombre
	 * @throws DomainException 
	 */
	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, USER_NOMBRE_LONG_MIN, USER_NOMBRE_LONG_MAX))
			if (Validator.isAlfanumeric(user_nombre))
				this.user_nombre = user_nombre;
			else
				throw new DomainException(
						ErrorMessages.mensajes(ErrorMessages.PROERR_004, new String[] { "Nombre Usuario", "Alfanumerico" }));
		else
			throw new DomainException(ErrorMessages.mensajes(ErrorMessages.PROERR_003,
					new String[] { "Nombre Usuario", "" + USER_NOMBRE_LONG_MIN, "" + USER_NOMBRE_LONG_MAX }));
	}

	

	/**
	 * @param user_email el user_email a establecer
	 * @throws DomainException 
	 */
	public void setUser_email(String user_email) throws DomainException {
		if (Validator.cumpleLongitud(user_email, USER_EMAIL_LONG_MIN, USER_EMAIL_LONG_MAX))
			if (Validator.isAlfanumeric(user_email))
				this.user_email = user_email;
			else
				throw new DomainException(
						ErrorMessages.mensajes(ErrorMessages.PROERR_004, new String[] { "Correo electronico", "Alfanumerico" }));
		else
			throw new DomainException(ErrorMessages.mensajes(ErrorMessages.PROERR_003,
					new String[] { "Correo electronico", "" + USER_EMAIL_LONG_MIN, "" + USER_EMAIL_LONG_MAX }));
	}

	
	/**
	 * @param user_pass el user_pass a establecer
	 * @throws DomainException 
	 */
	public void setUser_pass(String user_pass) throws DomainException {
		if(Validator.esUsuarioPasswordValida(getUser_nombre(), user_pass))
			this.user_pass = user_pass;
		else
			throw new DomainException(ErrorMessages.PROERR_008);
		
	}

	
	/**
	 * @param user_tipo el user_tipo a establecer
	 */
	public void setUser_tipo(String user_tipo) {
		this.user_tipo = user_tipo;
	}


	/**
	 * @param user_dni el user_dni a establecer
	 * @throws DomainException 
	 */
	public void setUser_dni(String user_dni) throws DomainException {
		if(Validator.cumpleDNI(user_dni))
			this.user_dni = user_dni;
		else
			throw new DomainException(ErrorMessages.PROERR_009);
		
	}

	/**
	 * @param user_fecAlta el user_fecAlta a establecer
	 * @throws DomainException 
	 */
	public void setUser_fecAlta(Calendar user_fecAlta) throws DomainException {
		Calendar max=Calendar.getInstance();
		Calendar min=Calendar.getInstance();
		max.add(Calendar.DAY_OF_YEAR, +1);
		min.add(Calendar.DAY_OF_YEAR, -1);
		if (Validator.valDateIgual(user_fecAlta, Calendar.getInstance())) 
			this.user_fecAlta = user_fecAlta;
		else
			throw new DomainException(ErrorMessages.mensajes(ErrorMessages.PROERR_010,
					new String[] { "Fecha alta" }));
			
		
	}

	/**
	 * @return el user_fecConfirmacion
	 */
	public Calendar getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	/**
	 * @param user_fecConfirmacion el user_fecConfirmacion a establecer
	 */
	public void setUser_fecConfirmacion(Calendar user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}

	/**
	 * @return el user_pago
	 */
	public Direccion getUser_pago() {
		return user_pago;
	}

	/**
	 * @param user_pago el user_pago a establecer
	 */
	public void setUser_pago(Direccion user_pago) {
		this.user_pago = user_pago;
	}

	

	/**
	 * @param user_envio el user_envio a establecer
	 */
	public void setUser_envio(Direccion user_envio) {
		this.user_envio = user_envio;
	}
	
	/**
	 * @return user_nombre el nombre de usuario
	 */
	public String getUser_nombre() {
		return user_nombre;
	}

	/**
	 * @return el user_email
	 */
	public String getUser_email() {
		return user_email;
	}
	
	/**
	 * @return el user_envio
	 */
	public Direccion getUser_envio() {
		return user_envio;
	}
	
	/**
	 * @return el user_pass
	 */
	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * @return el user_tipo
	 */
	public String getUser_tipo() {
		return user_tipo;
	}


	/**
	 * @return el user_dni
	 */
	public String getUser_dni() {
		return user_dni;
	}
	

	/**
	 * @return el user_fecAlta
	 */
	public Calendar getUser_fecAlta() {
		return user_fecAlta;
	}
}
