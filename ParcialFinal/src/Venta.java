
public class Venta {
	
	private Cafe cafe;
	private double cantidad;
	private boolean tarjeta;
	private double precio;
    private int id;


	public Venta(Cafe cafe, double cantidad, boolean tarjeta, double precio, int id) {
		super();
		this.cafe = cafe;
		this.cantidad = cantidad;
		this.tarjeta = tarjeta;
		this.precio = precio;
		this.id = 0;
	}
	



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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
			return "\nCafe: " + cafe.getNombre() + "\ncantidad: " + cantidad + "\nCon descuento"+ "\nTotal"+ precio + "\nId: " + id + " - - ";
		}else {
			return "\nCafe " + cafe.getNombre() + "\ncantidad: " + cantidad + "\nSin descuento "+ "\nTotal: "+precio+"\nId: " + id + " - - ";
		}
		
	}
	

}
