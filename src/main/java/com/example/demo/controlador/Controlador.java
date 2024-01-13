package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceservice.IClienteService;
import com.example.demo.modelo.Cliente;

@Controller  /*se utiliza en Spring para marcar una clase como un controlador. Los controladores en Spring son
componentes que manejan las solicitudes web y devuelven las respuestas adecuadas*/

@RequestMapping  /*se utiliza para asignar solicitudes HTTP a métodos específicos en clases de controlador.*/
public class Controlador {
	
	@Autowired  /* es utilizada en Spring para realizar la inyección de dependencias automáticamente. 
	En este caso, se está utilizando para inyectar la dependencia service en la clase que contiene este código.*/	
	private IClienteService service;  /* interfaz que define métodos para realizar operaciones relacionadas con la
	 entidades de clientes. */
	
	@GetMapping("/")  /* indica que este método manejará solicitudes HTTP GET en la ruta raíz ("/") de la
	 aplicación.*/
	public String listar(Model /* se utiliza para pasar datos entre el controlador y la vista.*/ model) /*Este es el
	 método que se ejecutará cuando se realice una solicitud GET a la ruta raíz*/ {
		List<Cliente>clientes=service.listar();  /* instancia de una clase que implementa la interfaz 
		IClienteService. Este método devuelve una lista de objetos Cliente.*/
		model.addAttribute("clientes", clientes); /*Se agrega la lista de clientes al modelo con el nombre
		 "clientes". */
		return "index"; /*El método devuelve una cadena "index". En el contexto de Spring MVC, esto generalmente
		 indica el nombre de la vista que se debe utilizar para renderizar la respuesta. La vista "index" se
		 resolverá por el sistema de vistas de Spring y se usará para presentar los datos.*/
	}
	
	
	/*este método se encarga de preparar y mostrar el formulario de creación de clientes.*/
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "crearC";		
	}
	
	
	/* este método se encarga de procesar la información enviada a través de un formulario de creación de clientes. */
	@PostMapping("/save")
	public String save(@Validated Cliente c, Model model) {
		service.save(c);
		return "redirect:/";		
	}
	
	
	/*este método se encarga de mostrar el formulario de edición de clientes. Al obtener el cliente correspondiente al ID
	 *  proporcionado, lo agrega al modelo y luego devuelve el nombre de la vista "crearC". La vista "crearC" donde
	 *   contendrá un formulario HTML prellenado con los datos del cliente existente para que el usuario los edite.*/
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Cliente>cliente=service.listarId(id);
		model.addAttribute("cliente", cliente);
		return "crearC";
		
	}
	/* este método se encarga de eliminar un cliente basado en el ID proporcionado. Después de la eliminación, redirige al
	 *  usuario a la página principal ("/") de la aplicación.*/
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/";
		
	}

}
