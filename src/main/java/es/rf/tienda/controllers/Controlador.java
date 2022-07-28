package es.rf.tienda.controllers;

import java.util.List;
import java.util.Map;

import es.rf.tienda.exception.DAOException;

public interface Controlador<S> {
	
	public static final String ID = "id";

	public static final String ADD = "add";
	public static final String VIEW = "ver";
	public static final String UPDATE = "upd";
	public static final String DELETE = "del";
	public static final String LIST = "lis";
	
	public S leer(S obj);
	public List<S> leerTodos();
	public List<S> leerSQL(String sql);
	public void grabar(S obj) throws DAOException;
	public boolean actualizar(S obj) throws DAOException;
	public boolean borrar(S obj) throws DAOException;
	public Map<String,String> obtenSelect();
	


}
