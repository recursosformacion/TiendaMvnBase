package es.rf.tienda.dominio;


import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

public class Cliente {

		public static final int NOMBRE_LONG_MAX = 30;
		public static final int NOMBRE_LONG_MIN = 5;
		public static final int DIRECCION_LONG_MAX = 30;
		public static final int DIRECCION_LONG_MIN = 5;
		
		private int idCliente;
		private String nombre;
		private String direccion;
		private String poblacion;
		private String cPostal;
		private String provincia;
		
		
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) throws DomainException {
			if (Validator.isAlfanumeric(nombre) && 
					Validator.cumpleLongitudMax(nombre, NOMBRE_LONG_MAX) &&
					Validator.cumpleLongitudMin(nombre, NOMBRE_LONG_MIN))
						this.nombre = nombre;
			else
				throw new DomainException(ErrorMessages.ERM_001);
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) throws DomainException {
			if (Validator.isAlfanumeric(direccion) && 
					Validator.cumpleLongitudMax(direccion, DIRECCION_LONG_MAX) &&
					Validator.cumpleLongitudMin(direccion, DIRECCION_LONG_MIN))
				this.direccion = direccion;
			else
				throw new DomainException(ErrorMessages.ERM_005);
			
		}
		public String getPoblacion() {
			return poblacion;
		}
		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}
		public String getcPostal() {
			return cPostal;
		}
		public void setcPostal(String cPostal) {
			this.cPostal = cPostal;
		}
		public String getProvincia() {
			return provincia;
		}
		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}
		
		
		
}
