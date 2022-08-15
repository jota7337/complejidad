package Model;

public class Persona {
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", Date=" + Date + ", id=" + id + ", Unico=" + Unico + "]";
	}
	private  String nombre;
	private String Date;
	private int id;
	private int Unico;
	public Persona(String nombre, String date, int id, int unico) {
		this.nombre = nombre;
		this.Date = date;
		this.id = id;
		this.Unico = unico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnico() {
		return Unico;
	}
	public void setUnico(int unico) {
		Unico = unico;
	}
	
}
