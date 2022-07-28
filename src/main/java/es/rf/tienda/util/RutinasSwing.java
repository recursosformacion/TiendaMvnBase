package es.rf.tienda.util;

import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.controllers.CategoriaController;
import es.rf.tienda.controllers.Controlador;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

public class RutinasSwing {

	/**
	 * Recibe modelo y opcion y devuelve array con
	 * 0 - texto del boton;
	 * 1 - titulo a presentar
	 * 2 - si/no para controlar acceso a los campos
	 * 
	 * @param modelo
	 * @param opcion
	 * @return
	 */
	public static String[] textos(String modelo, String opcion) {
		String boton="",titulo="",readonly = "";
		switch (opcion) {
		case Controlador.ADD:
			boton="Añadir";
			titulo = "Alta de " + modelo;
			readonly = "no";
			break;
		case Controlador.VIEW:
			boton="Cerrar";
			titulo = "Vista de " + modelo;
			readonly = "si";
			break;
		case Controlador.UPDATE:
			boton="Modificar";
			titulo = "Modificacion de " + modelo;
			readonly = "no";
			break;
		case Controlador.DELETE:
			boton="Borrar";
			titulo = "Borrar " + modelo;
			readonly = "si";
			break;
		case Controlador.LIST:
			boton="";
			titulo = "Listado de " + modelo;
			readonly = "si";
			break;
		}
		return new String[]{boton,titulo,readonly};
	}
}
