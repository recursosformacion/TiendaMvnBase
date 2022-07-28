package es.rf.tienda.dominio;

public abstract class Modelo implements Cloneable{
	
	private  String pk= "id_categoria";
	private  String tabla = "categoria";
	
	Modelo(String tabla, String pk){
		this.tabla=tabla;
		this.pk=pk;
	}
	
	public  String getTabla() {
		return tabla;
	}
	
	public  String getNombrePk() {
		return pk;
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public abstract boolean isValid();
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String[] toArray();
	

}
