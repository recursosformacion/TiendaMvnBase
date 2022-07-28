package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

public class Direccion {

		public static final int NOMBRE_LONG_MAX = 30;
		public static final int NOMBRE_LONG_MIN = 5;
		public static final int DIRECCION_LONG_MAX = 30;
		public static final int DIRECCION_LONG_MIN = 5;
		
		private int id_direccion;
		private int id_usuario;
		private String dir_nombre;
		private String dir_direccion;
		private String dir_poblacion;
		private String dir_cPostal;
		private String dir_provincia;
		private String dir_pais;
		private String dir_correoE;


		
		public int getId_direccion() {
			return id_direccion;
		}

		public void setId_direccion(int id_direccion) {
			this.id_direccion = id_direccion;
		}

		public int getId_usuario() {
			return id_usuario;
		}

		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
		}
		
		public String getDir_poblacion() {
			return dir_poblacion;
		}

		public void setDir_poblacion(String dir_poblacion) {
			this.dir_poblacion = dir_poblacion;
		}

		public String getDir_cPostal() {
			return dir_cPostal;
		}

		public void setDir_cPostal(String dir_cPostal) {
			this.dir_cPostal = dir_cPostal;
		}

		public String getDir_provincia() {
			return dir_provincia;
		}

		public void setDir_provincia(String dir_provincia) {
			this.dir_provincia = dir_provincia;
		}

		public String getDir_pais() {
			return dir_pais;
		}

		public void setDir_pais(String dir_pais) {
			this.dir_pais = dir_pais;
		}

		public String getDir_correoE() {
			return dir_correoE;
		}

		public void setDir_correoE(String dir_correoE) {
			this.dir_correoE = dir_correoE;
		}

		public String getDir_nombre() {
			return dir_nombre;
		}

		public String getDir_direccion() {
			return dir_direccion;
		}

		public void setDir_nombre(String dir_nombre) throws DomainException {
			if (Validator.isAlfanumeric(dir_nombre) && 
					Validator.cumpleLongitudMax(dir_nombre, NOMBRE_LONG_MAX) &&
					Validator.cumpleLongitudMin(dir_nombre, NOMBRE_LONG_MIN))
						this.dir_nombre = dir_nombre;
			else
				throw new DomainException(ErrorMessages.ERM_001);
		}
		
		public void setDir_direccion(String dir_direccion) throws DomainException {
			if (Validator.isAlfanumeric(dir_direccion) && 
					Validator.cumpleLongitudMax(dir_direccion, DIRECCION_LONG_MAX) &&
					Validator.cumpleLongitudMin(dir_direccion, DIRECCION_LONG_MIN))
				this.dir_direccion = dir_direccion;
			else
				throw new DomainException(ErrorMessages.ERM_005);
			
		}
		
		
		
		
}
