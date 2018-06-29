/**
 * @author Byron T
 * 
 */
public class Cliente {
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer telefono;

	
	public Cliente(String cedula, String nombre, String apellido, String direccion, Integer telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	

	public String getDni() {
		return cedula;
	}

	
	public void setDni(String cedula) {
		this.cedula = cedula;
	}

	
	public String getName() {
		return nombre;
	}

	
	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public String getSurnombre() {
		return apellido;
	}

	
	public void setSurnombre(String apellido) {
		this.apellido = apellido;
	}

	
	public String getAddress() {
		return direccion;
	}

	
	public void setAddress(String direccion) {
		this.direccion = direccion;
	}

	
	public Integer getTelephone() {
		return telefono;
	}

	
	public void setTelephone(Integer telefono) {
		this.telefono = telefono;
	}

}
