



public class Encargado {
	 private int id;
	 private String nombre;
	 private int contra;
	public Encargado( String nombre) {
		super();
		this.id = 2022;
		this.nombre = nombre;
		this.contra = 1010;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getContra() {
		return contra;
	}
	public void setContra(int contra) {
		this.contra = contra;
	}
	@Override
	public String toString() {
		return "Encargado [id=" + id + ", nombre=" + nombre + ", contra=" + contra + "]";
	}
	 
	 
	}