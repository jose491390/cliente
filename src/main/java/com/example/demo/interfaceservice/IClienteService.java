/*esta interfaz de servicio define las operaciones relacionadas con la entidad Cliente. */

package com.example.demo.interfaceservice;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Cliente;

public interface IClienteService {
	
	public List<Cliente>listar();
	public Optional<Cliente>listarId(int id);
	public int save(Cliente c);
	public void delete(int id);
}
