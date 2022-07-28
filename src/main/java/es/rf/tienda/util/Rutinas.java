package es.rf.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Rutinas {

	private static final String DATE_PATTERN = "dd/MM/yyyy";
	
	/**
	 * Crea un dato etiquetado
	 * 
	 * @param etiqueta
	 * @param valor
	 * @return
	 */
	public static String etiquetar(String etiqueta, String valor) {
		StringBuffer salida = new StringBuffer();
		salida.append("<" + etiqueta + ">");
		salida.append(valor);
		salida.append("</" + etiqueta + ">");
		return salida.toString();
	}

	/**
	 * Recibe una fecha en formato dd/mm/yyyy y devuelve un objeto Calendar con
	 * dicho valor
	 * 
	 * @param fecha
	 * @return
	 */
	public static Calendar convierteACalendar(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(fecha));
		} catch (ParseException e) {
			return null;
		}
		return calendar;
	}

	public static String convierteAString(Calendar fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha.getTime());
	}

	public static boolean esFechaLogica(String fecha) {
		Calendar test = convierteACalendar(fecha);
		if (test != null) {
			String testS = convierteAString(test);
			return fecha.equals(testS);
		}
		return false;
	}
	
public static boolean esFechaLogica2(String fecha) {
		
		if (fecha != null && fecha.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
			try {
				sdf.setLenient(false);
				sdf.parse(fecha);
			} catch (ParseException e) {
				return false;
			}
			return true;
		} else
			return false;
	}
	/**
	 * Compara dos fechas en formato calendar, devolviendo -1, 0 y +1
	 * @param Calendar cal1
	 * @param Calendar cal2
	 * @return
	 */
	public static int fechaCompareTo(Calendar cal1, Calendar cal2) {
	    if (cal1 == null || cal2 == null)
	        return 0;
	    if (isSameDay(cal1,cal2)) return 0;
	    return cal1.compareTo(cal2);
	}
	       
	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
	    if (cal1 == null || cal2 == null)
	        return false;
	    return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
	            && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) 
	            && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
	}
	
	public static void ponerACeroHora(Calendar fecha){	    
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
		fecha.set(Calendar.HOUR_OF_DAY, 0);
	}

	public static String addCampo(String salida, String nombreCampo, Calendar valor, String separador) {
		if (valor != null) {
	//		return addSalidaSencilla(salida, nombreCampo, "'" + Rutinas.convierteAString(valor) + "'", separador);
			if (nombreCampo == null)
				return addSalidaSencilla(salida, nombreCampo, "'" + Rutinas.convierteAString(valor) + "'", separador);
			else {
		/*	*********************** solucion 1 ********************************************************
		 * 		String fechas = "";
				fechas = nombreCampo + ">= '" + Rutinas.convierteAString(valor) + "' " + separador ;
				fechas+= nombreCampo + "< TO_DATE('" + Rutinas.convierteAString(valor) + "','dd/mm/yyyy') +1 ";
				return addSalidaSencilla(salida, "", fechas, separador); */
		/*************************** solucion 2 *********************************************************/		
				return addSalidaSencilla(salida, "TO_DATE (" + nombreCampo + ",'dd/mm/yy')", 
						"TO_DATE('" + Rutinas.convierteAString(valor) + "','dd/mm/yy')", separador); 
			}
		}
		else
			return addSalidaSencilla(salida, nombreCampo, null, separador);

	}

	public static String addCampo(String salida, String nombreCampo, double valor, String separador) {
		salida = Rutinas.addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
		return salida;
	}

	public static String addCampo(String salida, String nombreCampo, long valor, String separador) {
		salida = Rutinas.addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
		return salida;
	}

	public static String addCampo(String salida, String nombreCampo, String valor, String separador) {
		if (valor != null)
			return addSalidaSencilla(salida, nombreCampo, "'" + valor + "'", separador);
		else
			return addSalidaSencilla(salida, nombreCampo, null, separador);
	}
	/*
	 * String salida=""; salida=addSalida(salida,"importe",134.20,",");
	 * ---------------->salida = importe=134.20
	 * salida=addSalida(salida,"nombre","Miguel",","; ---------------->salida =
	 * importe=134.20,nombre="Miguel" salida=addSalida(salida,"tipo",22,",")
	 * ---------------->salida = importe=134.20,nombre="Miguel",tipo=22
	 */

	/**
	 * Completa SQL A�adiendo el nombre del campo y su valor (sis e pasa)
	 * Pensado para INSERT y UPDATES
	 * 
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return Devuelve una string con los valores a�adidos
	 */

	/**
	 * Recibe una String parcialmente construida y que tiene que completar, El
	 * nombre del campo se a�ade solo si no es nulo A continuacion del nombre
	 * del campo, se a�ade un signo "=" solo si se ha a�adido nombre del campo a
	 * continuacion se a�ade el valor recibido
	 * 
	 * @param salida
	 *            : Parte de la string ya construida
	 * @param nombreCampo
	 *            : Nombre del campo que se va a a�adir
	 * @param valor
	 *            : Valor del campo
	 * @param separador
	 *            : Separador que se tiene que a�adir entre campos
	 * @return : String que recibimos parcialmente construida a la que le hemos
	 *         añadido el nuevo campo
	 */
	public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
		if (salida != null && salida.length() > 0)
			salida += " " + separador + " ";
		if (nombreCampo != null && nombreCampo.length() != 0)
			salida += nombreCampo + " = ";
		salida += valor;
		return salida;
	}
	
	
}
