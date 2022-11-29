
public class Venta {
	
	private Cafe cafe;
	private double cantidad;
	private boolean tarjeta;
	private double precio;



	public Venta(Cafe cafe, double cantidad, boolean tarjeta, double precio) {
		super();
		this.cafe = cafe;
		this.cantidad = cantidad;
		this.tarjeta = tarjeta;
		this.precio = precio;
	}
	



	public Cafe getCafe() {
		return cafe;
	}




	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}




	public double getCantidad() {
		return cantidad;
	}




	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}




	public boolean isTarjeta() {
		return tarjeta;
	}




	public void setTarjeta(boolean tarjeta) {
		this.tarjeta = tarjeta;
	}




	public double getPrecio() {
		return precio;
	}




	public void setPrecio(double precio) {
		this.precio = precio;
	}




	@Override
	public String toString() {
		if(tarjeta) {
			return " Cafe: " + cafe.getNombre() + "\ncantidad: " + cantidad + "\nPosee descuento por tarjeta socio "+ "\nTotal"+ precio;
		}else {
			return " Cafe " + cafe.getNombre() + "\ncantidad: " + cantidad + "\nNo posee descuento por tarjeta socio"+ "\nTotal"+precio;
		}
		
	}
	

}
