/*la clase Cliente define una entidad que puede ser persistida en una base de datos utilizando JPA. Los campos de la clase
 *  representan las propiedades de un cliente, y la clase proporciona métodos de acceso y constructores para trabajar con
 *   instancias de clientes en la aplicación.*/

package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*Estas anotaciones de JPA indican que la clase Cliente es una entidad persistente y que se mapeará a una tabla llamada
 "cliente" en la base de datos.*/
@Entity 
@Table(name = "cliente")
public class Cliente {
	@Id  /* indica que el campo id es la clave primaria de la entidad.*/
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*especifica que el valor del campo id se generará automáticamente 
	utilizando una estrategia de identidad*/
	private int id;
	private int razonSocial;
	private String nombre;
	private String telefono;
	private String direccion;
	
	

	public Cliente() {
		
	}

	public Cliente(int id, int razonSocial, String nombre, String telefono, String direccion) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(int razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	

}
