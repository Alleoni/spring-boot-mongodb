package com.alleoni.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alleoni.workshopmongo.domain.User;
import com.alleoni.workshopmongo.dto.UserDTO;
import com.alleoni.workshopmongo.repository.UserRepository;
import com.alleoni.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;  //Devemos criar o UserRepository dentro de UserService, pois é o service que se comunica com o repository.
	
	public List<User> findAll(){
		return  repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

	}
	

