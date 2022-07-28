package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;
import es.rf.tienda.util.Validator;

public class CategoriaDAO {

	private final String SELECT = "SELECT * FROM Categoria ";
	private final String UPDATE = "UPDATE categoria ";
	private final String INSERT = "INSERT INTO categoria ";
	private final String DELETE = "DELETE ON categoria ";
	
	
	public Categoria leerRegistro(Categoria clase) throws DAOException, DomainException  {
		Categoria nueva;
		String res = obtenWhere(clase);
		String sql = SELECT  + res;
		
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		try {
			rs.next();
			if (rs.isLast()) {
				return montaRegistro(rs);
			} else
				throw new DAOException("Demasiados registros en " + sql);
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen " + sql);
		}
	}


	private String obtenWhere(Categoria clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	public List<Categoria> leerTodos() throws DAOException, DomainException {
		String sql = SELECT;
		return montaLista(sql);
		
	}

	


	public List<Categoria> leerRegistros(Categoria clase) throws DAOException, DomainException {
		String where = obtenWhere(clase);
		String sql = SELECT  + where;
		return montaLista(sql);
	}
	
	private List<Categoria> montaLista(String sql) throws DAOException, DomainException {
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			while (rs.next()) {
				lista.add(montaRegistro(rs));
			}
		
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen "+ sql);	
		}
		return lista;
	}


	public boolean actualiza(Categoria clase) throws DAOException {
		String where = " WHERE id_categoria = " + clase.getId();
		int tmp = clase.getId();
		clase.setId(0);
		String update = obtenUpdate(clase);
		clase.setId(tmp);
		String sql = UPDATE  + update + where;
		return RFDataConnection.ejecutar(sql)>1;
	}

	private String obtenUpdate(Categoria clase) {
		return obtenLista(clase, ",");
	}

	public boolean insertarRegistro(Categoria clase) throws DAOException {
		clase.setId(RFDataConnection.consigueClave("Categoria", "id_categoria"));
		String salida = obtenInsert(clase);
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = RFDataConnection.ejecutar(sql);
		if (ret == 0)
			throw new DAOException("Error en " + sql);
		return true;
	}


	


	public boolean borrarRegistro(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = DELETE  + where;
		return RFDataConnection.ejecutar(sql)>0;
		
	}


	public List<Categoria> leerSQL(String where) throws DAOException, DomainException {
		String sql = SELECT  + "WHERE" + where;
		return montaLista(sql);
	}

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addCampo(salida, "id_Categoria", clase.getId_categoria(), separador);
		}
		if ((clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) || separador.equals(",")) {
			salida = Rutinas.addCampo(salida, "cat_nombre", clase.getCat_nombre(), separador);
		}
		if ((clase.getCat_descripcion() != null && clase.getCat_descripcion().compareTo("") != 0)
				|| separador.equals(",")) {
			salida = Rutinas.addCampo(salida, "cat_descripcion", clase.getCat_descripcion(), separador);
		}
		return salida;
	}
	
	public String obtenInsert(Categoria clase) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "", clase.getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_nombre(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_descripcion(), ",");
		return salida;
	}
	
	public Categoria montaRegistro(ResultSet rs) throws DomainException, DAOException {
		Categoria salida = new Categoria();
		try {
			salida.setId_categoria(rs.getInt("Id_categoria"));
			salida.setCat_nombre(rs.getString("Cat_nombre"));
			salida.setCat_descripcion(rs.getString("Cat_descripcion"));
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen montaRegistro" );
		}
		return salida;
	}


}
