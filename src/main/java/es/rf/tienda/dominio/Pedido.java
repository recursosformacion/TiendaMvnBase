package es.rf.tienda.dominio;

import java.util.Calendar;

public class Pedido {

	private int id_pedido;
	private int id_usuario;
	private String id_producto;
	private int car_cantidad;
	private double car_precio;
	private Direccion car_envio;
	private Direccion car_pago;
	private String car_tarjeta;
	private Calendar car_feCadud;
	private int car_ccv;
	private String car_nombre;
	private int car_stat;
	private String car_feCambio;
	
	
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public int getCar_cantidad() {
		return car_cantidad;
	}
	public void setCar_cantidad(int car_cantidad) {
		this.car_cantidad = car_cantidad;
	}
	public double getCar_precio() {
		return car_precio;
	}
	public void setCar_precio(double car_precio) {
		this.car_precio = car_precio;
	}
	public Direccion getCar_envio() {
		return car_envio;
	}
	public void setCar_envio(Direccion car_envio) {
		this.car_envio = car_envio;
	}
	public Direccion getCar_pago() {
		return car_pago;
	}
	public void setCar_pago(Direccion car_pago) {
		this.car_pago = car_pago;
	}
	public String getCar_tarjeta() {
		return car_tarjeta;
	}
	public void setCar_tarjeta(String car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}
	public Calendar getCar_feCadud() {
		return car_feCadud;
	}
	public void setCar_feCadud(Calendar car_feCadud) {
		this.car_feCadud = car_feCadud;
	}
	public int getCar_ccv() {
		return car_ccv;
	}
	public void setCar_ccv(int car_ccv) {
		this.car_ccv = car_ccv;
	}
	public String getCar_nombre() {
		return car_nombre;
	}
	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}
	public int getCar_stat() {
		return car_stat;
	}
	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}
	public String getCar_feCambio() {
		return car_feCambio;
	}
	public void setCar_feCambio(String car_feCambio) {
		this.car_feCambio = car_feCambio;
	}
	
}
