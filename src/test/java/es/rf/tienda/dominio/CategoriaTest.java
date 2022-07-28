package es.rf.tienda.dominio;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import es.rf.tienda.exception.DomainException;

public class CategoriaTest {
	Categoria cat;
	final int ID_CATEGORIA=1;
	final String CAT_NOMBRE="Incienso";
	final String CAT_DESCRIPCION="Barritas de incienso de 20 centimetros ";
	
	final int ID_CATEGORIA_2=2;
	final String CAT_NOMBRE_2="Conos";
	final String CAT_NOMBRE_2_CORTO="Con";
	final String CAT_NOMBRE_2_LARGO="Conos jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj";
	final String CAT_DESCRIPCION_2="Conos de incienso de 10 gramos";
	
	@BeforeEach
	public void inicio() throws DomainException{
		cat=new Categoria();
		cat.setId_categoria(ID_CATEGORIA);
		cat.setCat_nombre(CAT_NOMBRE);
		cat.setCat_descripcion(CAT_DESCRIPCION);
	}
	@Test
	public void testIsValidNO() {
		cat=new Categoria();
		assertFalse(cat.isValid());
	}
	@Test
	public void testIsValid() {
		assertTrue(cat.isValid());
	}
	
	@Test
	public void testSetId_categoria() {
		cat.setId_categoria(ID_CATEGORIA_2);
		assertEquals(ID_CATEGORIA_2, cat.getId_categoria());
	}

	@Test
	public void testSetCat_nombre() throws DomainException {
		cat.setCat_nombre(CAT_NOMBRE_2);
		assertEquals(CAT_NOMBRE_2, cat.getCat_nombre());
	}
	
	@Test 
	public void testSetCat_nombre_corto()  {
		
		assertThrows(DomainException.class,()->cat.setCat_nombre(CAT_NOMBRE_2_CORTO));
	}
	
	@Test 
	public void testSetCat_nombre_largo()  {
		assertThrows(DomainException.class,()->cat.setCat_nombre(CAT_NOMBRE_2_LARGO));
	}
	
	@Test
	public void testSetCat_descripcion() {
		cat.setCat_descripcion(CAT_DESCRIPCION_2);
		assertEquals(CAT_DESCRIPCION_2, cat.getCat_descripcion());
	}

}
