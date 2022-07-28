package es.rf.tienda.dominio;

public class Pais extends Modelo {

	Pais(String tabla, String pk) {
		super("Pais", "id_pais");
	}
	private int id_Pais;
	private String pais_Nombre;
	
	public int getId_Pais() {
		return id_Pais;
	}
	public void setId_Pais(int id_Pais) {
		this.id_Pais = id_Pais;
	}
	public String getPais_Nombre() {
		return pais_Nombre;
	}
	public void setPais_Nombre(String pais_Nombre) {
		this.pais_Nombre = pais_Nombre;
	}
	@Override
	public boolean isValid() {
		return true;
	}
	@Override
	public int getId() {
		return getId_Pais();
	}
	@Override
	public void setId(int id) {
		setId_Pais(id);
		
	}
	@Override
	public String[] toArray() {
		return new String[]{getId_Pais() + "",getPais_Nombre()};
	}
	
	
}
