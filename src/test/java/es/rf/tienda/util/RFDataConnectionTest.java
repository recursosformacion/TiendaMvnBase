package es.rf.tienda.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DAOException;

public class RFDataConnectionTest {
	private static RFDataConnection conn;
	public final static String CLAVE_1 = "99";
	public final static String TEXTO_1 = "Esto es categoria";
	public final static String DESCRIPCION1 = "Esta es la descripcion 1 de la categoria";
	public static String INSERT_1;
	public final static String SELECT_G = "SELECT * FROM categoria WHERE ";
	public final static String SELECT_1 = "SELECT * FROM categoria ";

	@BeforeAll
	public static void inicio() throws DAOException, SQLException {
		INSERT_1 = "INSERT INTO categoria VALUES('" + CLAVE_1 + "','" + TEXTO_1 + "','" + DESCRIPCION1 + "')";
		
		int filas = RFDataConnection.ejecutar("DELETE categoria WHERE id_categoria = 99 ");
		conn = RFDataConnection.getInstance();
	}

	@AfterAll
	public static void fin() throws DAOException {
		RFDataConnection.closeConnection();
	}

	@Test
	public void testInsertar() throws SQLException, DAOException {
		int filas = RFDataConnection.ejecutar(INSERT_1);
		
		System.out.println("Registros afectados:" + filas);
		

		ResultSet rs = RFDataConnection.ejecutarQuery(SELECT_G + "id_categoria = '" + CLAVE_1 + "'");
		rs.next();

	}

	@Test
	public void listado() throws SQLException, DAOException{
		ResultSet rs = RFDataConnection.ejecutarQuery(SELECT_1);
		while (rs.next()){
			System.out.print(rs.getString("id_categoria") + "\t");
			System.out.print((rs.getString("cat_nombre") + "                                              ").substring(0, 30) + "\t");
			System.out.println(rs.getString("cat_descripcion"));
			
			
		}
	}
	/*
	 * @Test public void testCommit() throws DAOException, SQLException {
	 * Statement stm = conn.createStatement();
	 * stm.executeUpdate("Update EMP set JOB = JOB"); RFDataConnection.commit();
	 * }
	 * 
	 * @Test public void testRollback() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement();
	 * stm.executeUpdate("Update EMP set sal = sal + 10000 ");
	 * RFDataConnection.rollback(); }
	 * 
	 * @Test public void testCloseStatement() throws SQLException, DAOException
	 * { Statement stm = conn.createStatement();
	 * RFDataConnection.closeStatement(stm);
	 * assertTrue("Cerrar statment",stm.isClosed()); }
	 * 
	 * @Test public void testCloseResulSet() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement(); ResultSet rs =
	 * stm.executeQuery("SELECT * FROM EMP");
	 * RFDataConnection.closeResulSet(rs);
	 * 
	 * }
	 */
}
