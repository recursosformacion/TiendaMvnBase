package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {
	
	
		
	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	
	/**
	 * Campo con formato erroneo
	 */
	public final static String PROERR_004 = "El formato de  ? es erroneo; se espera ? ";

	/**
	 * Campo con rango erroneo
	 */
	public final static String PROERR_005 = "El campo  ? solo acepta valores entre ? y ? ";
	
	/**
	 * Fecha formato erroneo
	 */
	public final static String PROERR_006 = "El campo  ? ha de ser formato dd/mm/yyyy ";
	
	/**
	 * Campo con rango erroneo
	 */
	public final static String PROERR_007 = "El campo  ? ha de ser posterior a la fecha actual ";
	
	/**
	 * Contrase�a no valida
	 */
	public final static String PROERR_008 = "Contrase�a ha de ser entre 6 y 20 caracteres e incorporar (como minimo) un caracter especial, una letra y un numero ";
	
	
	/**
	 * DNI erroneo
	 */
	public final static String PROERR_009 = "El DNI indicado es erroneo; recuerde formato xx.xxx.xxx-x";
	
	/**
	 * La fecha ha de ser la del dia
	 */
	public final static String PROERR_010 = "El campo  ? ha de ser  la fecha actual ";
	
	/**
	 * The firstname was not entered by the user
	 */
	public final static String ERM_001 = "Please provide Firstname";
	
	/**
	 * The last name was not entered by the user
	 */
	public final static String ERM_002 = "Please provide Lastname";
	
	/**
	 * The username was not entered by the user
	 */
	public final static String ERM_003 = "Please provide Username";
	
	/**
	 * The password was not entered by the user
	 */
	public final static String ERM_004 = "Please provide password";
	
	/**
	 * The email was not entered by the user
	 */
	public final static String ERM_005 = "Indique direccion";
	
	/**
	 * The confirm password was not entered by the user
	 */
	public final static String ERM_006 = "Please provide confirm password";
	
	/**
	 * The phone number was not entered by the user
	 */
	public final static String ERM_007 = "Please provide phoneno";
	
	/**
	 * The user DNI was not entered by the user
	 */
	public final static String ERM_008 = "Please provide dni";
	
	/**
	 * The entered values in the password and the confirm password field are not the same
	 */
	public final static String ERM_009 = "Password and confirm password must be same !!";
	
	/**
	 * The phone was not entered correctly (only digits are allowed)
	 */
	public final static String ERM_010 = "Invalid PhoneNumber";
	
	/**
	 * The email was not written using the appropriate format (i.e. <text>@<text>.<text>
	 */
	public final static String ERM_011 = "Invalid Email ID";
	
	/**
	 * The dni  was not entered correctly (format xx.xxx.xxxx-L)
	 */
	public final static String ERM_012 = "Invalid DNI";
	
	/**
	 * The  username was not entered correctly (invalid length)
	 */
	public final static String ERM_013 = "Invalid username";
	
	/**
	 * The  password was not entered correctly (invalid length)
	 */
	public final static String ERM_014= "Invalid Password";
	
	/**
	 * The  visitor FirstName  was not entered correctly (invalid length)
	 */
	public final static String ERM_015 = "Invalid FirstName";
	
	/**
	 * The  visitor LastName  was not entered correctly (invalid length)
	 */
	public final static String ERM_016 = "Invalid LastName";
	
	/**
	 * The  visitor Address was not entered correctly (invalid length)
	 */
	public final static String ERM_017 = "Invalid Address ";
	
	/**
	 * The event name was not entered correctly (invalid length)
	 */
	public final static String ERM_018 = "Invalid Event Name";
	
	/**
	 * The event description was not entered correctly (invalid length)
	 */
	public final static String ERM_019 = "Invalid Event Description";
	
	/**
	 * The event place was not entered correctly (invalid length)
	 */
	public final static String ERM_020 = "Invalid Event Place";
	
	/**
	 * The event duration was not entered correctly (invalid length)
	 */
	public final static String ERM_021 = "Invalid Event Duration";
	
	/**
	 * The event type was not entered correctly (invalid length)
	 */
	public final static String ERM_022 = "InvalidEvent Type";
	
	/**
	 * The event seats availabe was not entered correctly 
	 */
	public final static String ERM_023 = "Invalid SeatsAvailable";
	
	/**
	 * The username password combination entered for login is invalid
	 */
	public final static String ERM_024 = "Invalid Username / Password";
	
	/**
	 * The username being registered is already in use by another visitor account
	 */
	public final static String ERM_025 = "USERNAME already exists. Please register again with different USERNAME.";
	
	/**
	 * The visitor has already registered to attend an event and attempted to register again
	 */
	public final static String ERM_026 = "User already Registered for the EVENT!";
	
	/**
	 * The visitor is attempting to update their personal information with values that are  invalid
	 */
	public final static String ERM_027 = "Error in update.. Please Check fields and retry";
		
	
	
	public static String mensajes(String mensaje, String[] datos){
		String salida="";
		int contador=0;
		for (int a = 0; a < mensaje.length();a++){
			if (mensaje.charAt(a)=='?'){
				if (contador<=datos.length)
					salida +=datos[contador++];
				else
					salida +="?" + contador++ + "?";
			}
			else
				salida += mensaje.charAt(a);
		}
		
		return salida;
	}

}
