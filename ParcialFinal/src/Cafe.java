
public class Cafe {
	
	private String nombre;
	private double precio;
	private int id;
	public Cafe(String nombre, double precio, int id) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
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
	@Override
	public String toString() {
		return " "+ nombre + "\n $" + precio ;
	}
	

}
