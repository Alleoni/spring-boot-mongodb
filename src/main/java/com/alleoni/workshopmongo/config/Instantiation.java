package com.alleoni.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alleoni.workshopmongo.domain.User;
import com.alleoni.workshopmongo.repository.UserRepository;

@Configuration  // Para o Spring entender que o código abaixo, significa uma configuração.
public class Instantiation implements CommandLineRunner { // CommandLineRunner será utilizado para instanciação do Banco
															// de Dados.

	@Autowired
	private UserRepository userRepository; // Injeção do UserRepository para fazer operação com o banco de dados.

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll(); // Limpar a coleção no MongoDB

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));  //Salvar automaticamente os dados no MongoDB
		
	}

}
