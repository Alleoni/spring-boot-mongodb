package com.alleoni.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	public UserResource() {

	}

}
