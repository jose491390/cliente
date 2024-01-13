/*la clase ClienteService implementa la interfaz IClienteService y utiliza la interfaz Icliente (extensión de CrudRepository)
 *  para realizar operaciones CRUD en la entidad Cliente. Esta implementación se utiliza como un servicio en la capa de servicio
 *   de la aplicación.*/

package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.Icliente;
import com.example.demo.interfaceservice.IClienteService;
import com.example.demo.modelo.Cliente;


@Service /*se utiliza para indicar que esta clase es un servicio de Spring y debe ser escaneada para ser manejada */
public class ClienteService implements IClienteService {
	
	/*se utiliza para inyectar la dependencia de la interfaz Icliente en la clase. Esto se hace para que la clase ClienteService
	 *  pueda utilizar los métodos proporcionados por CrudRepository para interactuar con la base de datos.*/
	@Autowired
	private Icliente data;

	/*Se implementan los métodos definidos en la interfaz IClienteService utilizando la instancia de Icliente (que es una
	 *  extensión de CrudRepository) para realizar operaciones CRUD en la entidad Cliente.*/
	
	@Override
	/*Retorna la lista de todos los clientes utilizando el método */
	public List<Cliente> listar() {
		return (List<Cliente>)data.findAll();
	}

	@Override
	/* Retorna un Optional que contiene el cliente correspondiente al ID proporcionado utilizando el método findById()
	 *  proporcionado por CrudRepository.*/
	public Optional<Cliente> listarId(int id) {
		return data.findById(id);
	}

	@Override
	/*Guarda un nuevo cliente o actualiza uno existente utilizando el método save() proporcionado por CrudRepository.*/
	public int save(Cliente c) {
		int res=0;
		Cliente cliente=data.save(c);
		if(!cliente.equals(null)){
			res=1;
		}
		return res;
	}

	@Override
	/*Elimina un cliente por su ID utilizando el método deleteById() proporcionado por CrudRepository.*/
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
