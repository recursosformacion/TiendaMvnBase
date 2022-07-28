package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

/**
 * 
 * Nombre Categoría Descripción Lista de categorías
 * 
 * @author Miguel Garcia
 * @version 13 de abr. de 2022
 *
 */
public class Categoria {

	
	
	private int id_categoria; // identificador categoría

	private String cat_nombre; // nombre de la categoría

	private String cat_descripcion; // descripción de la categoría
	
	

	/**
	 * Longitud nombre
	 * 
	 */
	public static final int CAT_NOMBRE_LONG_MIN = 5;
	public static final int CAT_NOMBRE_LONG_MAX = 50;
	public static final int CAT_DESCRIPCION_MAX = 200;

	

	public boolean isValid() {
		return !Validator.isVacio(cat_nombre) && id_categoria > 0;
	}
	
	public int getId() {
		return getId_categoria();
	}
	public void setId(int id) {
		setId_categoria(id);
	}

	/**
	 * Getter para identificador de categoría
	 * 
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Setter para identificador de categoria
	 * 
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	/**
	 * Getter para el nombre de categoria
	 * 
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;
	}

	/**
	 * Setter para el nombre de categoria
	 * 
	 * @throws DomainException
	 * 
	 */
	public void setCat_nombre(String cat_nombre) throws DomainException {
		if (Validator.cumpleLongitud(cat_nombre, CAT_NOMBRE_LONG_MIN, CAT_NOMBRE_LONG_MAX))
			if (Validator.isAlfanumeric(cat_nombre)) {
				this.cat_nombre = cat_nombre;
			} else {
				throw new DomainException(ErrorMessages.mensajes(ErrorMessages.PROERR_004,
						new String[] { "Nombre Categoria", "Alfanumerico" }));
			} else
			throw new DomainException(ErrorMessages.mensajes(ErrorMessages.PROERR_003,
					new String[] { "Nombre Categoria", "" + CAT_NOMBRE_LONG_MIN, "" + CAT_NOMBRE_LONG_MAX }));
	}

	/**
	 * Getter para la descripción de categoria
	 * 
	 * @return cadena con la descripción de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}

	/**
	 * setter para la descripcion de categoria
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null) {
				return false;
			}
		} else if (!cat_descripcion.equals(other.cat_descripcion)) {
			return false;
		}
		if (cat_nombre == null) {
			if (other.cat_nombre != null) {
				return false;
			}
		} else if (!cat_nombre.equals(other.cat_nombre)) {
			return false;
		}
		if (id_categoria != other.id_categoria) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categoria [isValid()=" + isValid() + ", getId_categoria()=" + getId_categoria() + ", getCat_nombre()="
				+ getCat_nombre() + ", getCat_descripcion()=" + getCat_descripcion() + ", hashCode()=" + hashCode()
				+ "]";
	}

	
	public String[] toArray() {
		return new String[]{getId_categoria() + "",getCat_nombre(),getCat_descripcion()};
	}

}
