package com.alleoni.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alleoni.workshopmongo.domain.User;
import com.alleoni.workshopmongo.dto.UserDTO;
import com.alleoni.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service; // Devemos criar o UserService dentro de UserResource, pois é o Resource que se
									// comunica com o service.

	@GetMapping // para dizer que o método abaixo será será um endpoint rest no caminho "/users"
				// deve-se colocar a anotação "@RequestMapping(method=RequestMethod.GET) ou utilizar apenas @GetMapping"
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { //PathVariable serve para indicar que o id do DTO seja igual o Id do endpoint
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));

	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();  //Created - Retorna o código 201, que é o código de resposta HTTP quando você cria um novo recurso. Passando Uri como argumento.
		
		
	}

	public UserResource() {

}
	
}