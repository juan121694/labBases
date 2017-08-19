
public class Cliente{
	String nombre;
	String telefono;
	String direccion;
	String correo;
	String metrosPropiedad;
	String valorPropiedad;
	String valorVenta;
	public Cliente(String nombre,String telefono,String direccion,String correo,String metrosPropiedad,String valorPropiedad,String valorVenta){
		this.nombre=nombre;
		this.telefono=telefono;
		this.direccion=direccion;
		this.correo=correo;
		this.metrosPropiedad=metrosPropiedad;
		this.valorPropiedad=valorPropiedad;
		this.valorVenta=valorVenta;
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
}