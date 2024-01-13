/*esta interfaz proporciona operaciones CRUD estándar para la entidad Cliente utilizando Spring Data JPA. Las operaciones CRUD
 *  se implementan automáticamente en tiempo de ejecución, y no es necesario proporcionar la implementación de estos métodos,
 *   ya que son proporcionados por CrudRepository.*/

package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;


@Repository
public interface Icliente extends CrudRepository<Cliente, Integer>{

}
