package es.rf.tienda.util;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class RutinasTest {
	
	final String FECHA_CORRECTA="20/10/2017";
	final String FECHA_INCORRECTA_1="40/12/2017";
	final String FECHA_INCORRECTA_2="0/12/2017";
	final String FECHA_INCORRECTA_3="10/14/2017";
	final String FECHA_INCORRECTA_4="10/0/2017";
	final String FECHA_INCORRECTA_5="-3/12/2017";
	final String FECHA_INCORRECTA_6="12345";
	
	final String NOMBRE_CAMPO_1="nombreUsuario";
	final String VALOR_CAMPO_1="miguel";
	final String NOMBRE_CAMPO_2="importe";
	final double VALOR_CAMPO_2=123.45;
	final String NOMBRE_CAMPO_3="tipo";
	final int VALOR_CAMPO_3=555;
	final String NOMBRE_CAMPO_4="fecha";
	final Calendar FECHA = Calendar.getInstance();
	
	
	@Test
	public void testEsFechaLogicaTRUE() {
		assertTrue(Rutinas.esFechaLogica(FECHA_CORRECTA));
	}
	@Test
	public void testEsFechaLogicaNO1() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_1));
	}
	@Test
	public void testEsFechaLogicaNO2() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_2));
	}
	@Test
	public void testEsFechaLogicaNO3() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_3));
	}
	@Test
	public void testEsFechaLogicaNO4() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_4));
	}
	@Test
	public void testEsFechaLogicaNO5() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_5));
	}
	@Test
	public void testEsFechaLogicaNO6() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_6));
	}
	@Test
	public void testConvierteACalendar() {
		Calendar test = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String testS = sdf.format(test.getTime());
		Calendar dato = Rutinas.convierteACalendar(testS);
		if (!sonIgualesCalendars(dato,test))
				fail("Error convierte a calendar");
	}

	@Test
	public void testConvierteAString() {
		Calendar test = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String testS = sdf.format(test.getTime());
		assertEquals(testS,Rutinas.convierteAString(test));
	}

	

	@Test
	public void testAddCampoStringStringDoubleString() {
		String salida="";
		assertEquals(NOMBRE_CAMPO_2+" = "+VALOR_CAMPO_2, 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_2, VALOR_CAMPO_2, ","));
	}
	@Test
	public void testAddCampoStringStringDoubleString2() {
		String salida="";
		salida=Rutinas.addCampo(salida, NOMBRE_CAMPO_1, VALOR_CAMPO_1, ",");
		salida=Rutinas.addCampo(salida, NOMBRE_CAMPO_2, VALOR_CAMPO_2, ",");
		String previsto=NOMBRE_CAMPO_1+" = '"+VALOR_CAMPO_1+"' , "+NOMBRE_CAMPO_2+" = "+VALOR_CAMPO_2;
		assertEquals(previsto,salida);
	}

	@Test
	public void testAddCampoStringStringStringString() {
		String salida="";
		assertEquals(NOMBRE_CAMPO_1+" = '"+VALOR_CAMPO_1+"'", 
				Rutinas.addCampo(salida, NOMBRE_CAMPO_1, VALOR_CAMPO_1, ","));
	}
	@Test
	public void testAddCampoStringStringStringStringNULL() {
		String dato = null;
		String salida="";
		assertEquals(NOMBRE_CAMPO_1+" = null", 
				Rutinas.addCampo(salida, NOMBRE_CAMPO_1, dato, ","));
	}

	@Test
	public void testAddCampoStringStringIntString() {
		String salida="";
		assertEquals(NOMBRE_CAMPO_3+" = "+VALOR_CAMPO_3, 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_3, VALOR_CAMPO_3, ","));
	}
	@Test
	public void testAddCampoStringNuloIntString() {
		String salida="";
		assertEquals(""+VALOR_CAMPO_3, 
						Rutinas.addCampo(salida, "", VALOR_CAMPO_3, ","));
	}

	@Test
	@Disabled
	public void testAddCampoStringStringCalendarString() {
		String salida="";
		
		assertEquals(NOMBRE_CAMPO_4+" = '"+Rutinas.convierteAString(FECHA)+"'", 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_4, FECHA, ","));
	}
	@Test
	@Disabled
	public void testAddCampoStringStringCalendarStringNULL() {
		String salida="";
		Calendar nulo=null;
		assertEquals(NOMBRE_CAMPO_4+" = null", 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_4, nulo, ","));
	}
	

	public boolean sonIgualesCalendars(Calendar dato, Calendar test){
		if ((dato.get(Calendar.YEAR)!= test.get(Calendar.YEAR)) |
				(dato.get(Calendar.MONTH)!= test.get(Calendar.MONTH))|
				(dato.get(Calendar.DAY_OF_MONTH)!= test.get(Calendar.DAY_OF_MONTH)))
			return false;
		return true;
	}
}
