package com.alleoni.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alleoni.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping // para dizer que o método abaixo será será um endpoint rest no caminho "/users" deve-se colocar a anotação "@RequestMapping"
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown.", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>(); // List é considerado Interface, portanto para podemrmos instanciar, devemos criar uma arraylist. Que é uma implementaçao do List
		list.addAll(Arrays.asList(maria,alex)); //Para adicionar na lista, utiliza-se o Arrays.asList() tudo que estiver no parenteses será inserido na lista.
		return ResponseEntity.ok().body(list); // Serve para definir o corpo da resposta terá a lista (list)
	}
	public UserResource() {
		
	}

}
