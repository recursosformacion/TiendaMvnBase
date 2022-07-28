package es.rf.tienda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.rf.tienda.exception.DAOException;

/* *****************************************************
 * NOMBRE: RFDataConnection.java
 * 
 * DESCRIPCION: 
 * 
 * @author Miguel Garcia * ****************************************************
 */
public class RFDataConnection {

	/** variable singleton **/
	private static RFDataConnection instancia;
	
	/**
	 * Variable para obtener la conexi�n
	 */
	private static Connection conn;

	/**
	 * Driver JDBC
	 */
	private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

	/**
	 * Direcci�n de la BD
	 */
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	/**
	 * Nombre de la DB
	 */
	private final static String DATABASE = "";

	/**
	 * Usuario para acceder a BD
	 */
	private final static String USUARIO = "alumno";

	/**
	 * Password para acceder a la BD
	 */
	private final static String PASSWORD = "Curso2022";

	private static String userACT = USUARIO;
	private static String passACT = PASSWORD;

	private RFDataConnection() throws DAOException {	
		conn = getConnection();
	}

	public static RFDataConnection getInstance() throws DAOException {
		if (instancia == null) {
			instancia = new RFDataConnection();
		}
		return instancia;
	}
	

	/*
	 * *************************************************************************
	 * ************** NOMBRE: getConnection *
	 * 
	 * DESCRIPCI�N:
	 * 
	 * Get connection a la BD
	 * 
	 * @return Un objeto Connection al servidor de la BD
	 * 
	 * @throws DAOException En caso que no se logre la conexi�n con la BD AUTOR:
	 * Miguel Garcia
	 * 
	 **************************************************************************************/
	private static Connection getConnection() throws DAOException {

		try {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName(JDBC_DRIVER);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				try {
					conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
					conn.setAutoCommit(false);
					//conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					System.out.println("Conexi�n al servidor lista para ser usada");
				} else {
					System.out.println("Conexion erronea");
					throw new DAOException("No se ha podido conectar con la BD");
				}
			}
		} catch (SQLException e) {
			System.out.println("Conexion erronea");
			throw new DAOException("No se ha podido conectar con la BD");
		}

		return conn;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: closeConnection *
	 * 
	 * DESCRIPCI�N:
	 * 
	 * Cierra la conexi�n a la BD
	 * 
	 * @throws DAOException, si existe cualquier error al acceder la BD
	 * 
	 * AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static void closeConnection() throws DAOException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("No se ha podido cerrar la conexi�n a la BD");
			throw new DAOException("Error al cerrar conexi�n a BD");
		} finally {
			conn = null;
		}
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: commit *
	 * 
	 * DESCRIPCI�N:
	 * 
	 * Commit connection
	 * 
	 * @param conn Objeto Commit contra el cual se realizar� un commit
	 * 
	 * @throws DAOException, si existe cualquier error al acceder la BD FECHA:
	 * 
	 * AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static void commit() throws DAOException {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error al realizar commit");
		}
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: rollback *
	 * 
	 * DESCRIPCI�N:
	 * 
	 * Rollback connection
	 * 
	 * @param conn Objeto Connection contra el cual se realizar� un rollback
	 * 
	 * @throws DAOException, si existe cualquier error al acceder la BD
	 * 
	 * AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static void rollback() throws DAOException {

		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error al realizar rollback");
		}
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: closeStatement *
	 * 
	 * DESCRIPCI�N:
	 * 
	 * Close preparedStatement
	 * 
	 * @param ps PreparedStatement que se cerrar�
	 * 
	 * @throws DAOException, si existe cualquier error al acceder la BD FECHA:
	 * 
	 * AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static void closeStatement(PreparedStatement ps) throws DAOException {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("No ha sido posible realizar operaci�n close sobre elemento Statement");
		}
	}

	public static void closeStatement(Statement ps) throws DAOException {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("No ha sido posible realizar operaci�n close sobre elemento Statement");
		}
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: closeResulSet *
	 * 
	 * DESCRIPCI�N: Close preparedStatement
	 * 
	 * @param rs Resultset a cerrar
	 * 
	 * @throws DAOException, si existe cualquier error al acceder la BD FECHA:
	 * 
	 * AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static void closeResulSet(ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("No ha sido posible realizar operaci�n close sobre elemento ResultSet");
		}
	}

	public static int ejecutar(String sql) throws DAOException {
		System.out.println("Ejecutar:" + sql);
		conn = getConnection();
		Statement stm = null;
		int retorno;
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			retorno = stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw (new DAOException("error en " + sql));
		} finally {
			closeStatement(stm);
		}
		return retorno;

	}

	public static ResultSet ejecutarQuery(String sql) throws DAOException {
		System.out.println("EjecutarQuery:" + sql);
		conn = getConnection();
		Statement stm = null;
		ResultSet retorno;
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			retorno = stm.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw (new DAOException("error en " + sql));
		} finally {
			//closeStatement(stm);
		}
		return retorno;
	}

	public static int consigueClave(String tabla, String campo) throws DAOException {
		String sql = "SELECT MAX(" + campo + ") FROM " + tabla;
		ResultSet rs = ejecutarQuery(sql);
		try {
			if /* (!rs.first()) */ (rs.next())
				System.out.println("Tiene datos");
			else
				return 1;
			// rs.next();
			return rs.getInt(0) + 1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error buscando PK :" + sql);
		}

	}

	public static String getUserACT() {
		return userACT;
	}

	public static void setUserACT(String userACTn) {
		userACT = userACTn;
	}

	public static String getPassACT() {
		return passACT;
	}

	public static void setPassACT(String passACTn) {
		passACT = passACTn;
	}

	public static String getPassword() {
		return PASSWORD;
	}
}
