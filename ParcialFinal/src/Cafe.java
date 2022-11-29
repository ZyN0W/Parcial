
public class Cafe {
	
	private String nombre;
	private double precio;
	private int id;
	private double cant_total;
	public Cafe(String nombre, double precio, int id) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.cant_total = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCant_total() {
		return cant_total;
	}
	public void setCant_total(double cant_total) {
		this.cant_total = cant_total;
	}
	@Override
	public String toString() {
		return "\nCafe nombre: " + nombre + " precio" + precio + " id: " + id + " Cantidad total: " + cant_total ;
	}
	

}
