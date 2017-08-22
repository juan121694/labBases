
public class Cliente{
	String nombre;
	String telefono;
	String direccion;
	String correo;
	String metrosPropiedad;
	String valorPropiedad;
	String valorVenta;
	String margenGanancia;
	public Cliente(String nombre,String telefono,String direccion,String correo,String metrosPropiedad,String valorPropiedad,String valorVenta){
		this.nombre=nombre;
		this.telefono=telefono;
		this.direccion=direccion;
		this.correo=correo;
		this.metrosPropiedad=metrosPropiedad;
		this.valorPropiedad=valorPropiedad;
		this.valorVenta=valorVenta;
	}
	public Cliente(String nombre,String telefono,String direccion,String correo,String metrosPropiedad,String valorPropiedad,String valorVenta,String margenGanancia){
		this.nombre=nombre;
		this.telefono=telefono;
		this.direccion=direccion;
		this.correo=correo;
		this.metrosPropiedad=metrosPropiedad;
		this.valorPropiedad=valorPropiedad;
		this.valorVenta=valorVenta;
		this.margenGanancia=margenGanancia;
	}
	public String getNombre(){
		return nombre;
	}
	public String getTelefono(){
		return telefono;
	}
	public String getDireccion(){
		return direccion;
	}
	public String getCorreo(){
		return correo;
	}
	public String getMetrosPropiedad(){
		return metrosPropiedad;
	}
	public String getValorPropiedad(){
		return valorPropiedad;
	}
	public String getValorVenta(){
		return valorVenta;
	}
	public String getMargenGanancia(){
		return margenGanancia;
	}
}