package com.alleoni.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alleoni.workshopmongo.domain.User;
import com.alleoni.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;  //Devemos criar o UserRepository dentro de UserService, pois é o service que se comunica com o repository.
	
	public List<User> findAll(){
		return  repo.findAll();
	}
}
