package es.rf.tienda.controllers;

import java.util.List;
import java.util.Map;


import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.objetos.daos.CategoriaDAO;
import es.rf.tienda.util.Validator;
import es.rf.tienda.vistas.FrCategoria;
import es.rf.tienda.vistas.LCCategoria;



public class CategoriaController implements Controlador<Categoria> {
	
	private CategoriaDAO cDAO;
	private Categoria gestor;
	private LCCategoria listado; // Frame para el listado
	private FrCategoria formulario; // Frame para el formulario

	
	public CategoriaController(){
		this.cDAO = new CategoriaDAO();
		this.listado = LCCategoria.getInstance();
		this.formulario = FrCategoria.getInstance();
		this.gestor = new Categoria();

		formulario.setController(this); // Le asigno al formulario, este controlador
		listado.setController(this); // Le asigno al formulario, este controlador
	}

	public void setOption(String[] sentencia) {
		String option = sentencia[0];
		String clave = "";
		Categoria obj = new Categoria();
		if (sentencia.length >= 2) {
			clave = sentencia[1];
			System.out.println(clave);
			obj.setId(Integer.parseInt(clave));
		}
		try {
			switch (option) {
			case ADD:
				formulario.setRecord(gestor, option);
				break;
			case VIEW:
			case UPDATE:
			case DELETE:
				formulario.setRecord(leer(obj), option);
				break;
			case LIST:
				List<Categoria> lista = leerTodos();
				listado.setDatos(lista);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void setAction(String accion, Categoria obj) {

		try {
			switch (accion) {
			case ADD:
				grabar(obj);
				break;
			case VIEW:
			case UPDATE:
			case DELETE:

			case LIST:

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setOption(new String[] { Controlador.LIST });
	}

	public Categoria leer(Categoria obj) {
		try {
			return cDAO.leerRegistro(obj);
		} catch (DAOException | DomainException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<Categoria> leerTodos() {
		try {
			return cDAO.leerTodos();
		} catch (DAOException | DomainException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<Categoria> leerSQL(String sql) {
		try {
			return cDAO.leerSQL(sql);
		} catch (DAOException | DomainException e) {

			e.printStackTrace();
		}
		return null;
	}

	public void grabar(Categoria obj) throws DAOException {
		if (cDAO.insertarRegistro(obj))
			setOption(new String[] { Controlador.LIST });
	}

	public boolean actualizar(Categoria obj) throws DAOException {
		return cDAO.actualiza(obj);
	}

	public boolean borrar(Categoria obj) throws DAOException {
		return cDAO.borrarRegistro(obj);
	}
	public Categoria montaObj(Map<String, String[]> m) throws DomainException {
		Categoria gestor = new Categoria();

			int id_categoria = 0;
			String id = m.get("id")[0];
			if (id != null && Validator.isNumeric(id))
				id_categoria = Integer.parseInt(id);

			gestor.setId_categoria(id_categoria);
			if (m.get("cat_nombre") != null)
				gestor.setCat_nombre(m.get("cat_nombre")[0]);
			if (m.get("cat_descripcion") != null)
				gestor.setCat_descripcion(m.get("cat_descripcion")[0]);
	//	}
		return gestor;
	}

	
	public Map<String, String> obtenSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
