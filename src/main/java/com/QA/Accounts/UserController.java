package com.QA.Accounts;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;

@RestController
class UserController {
	
	    private UserRepository repository;	 
	    
	    public UserController(UserRepository repository) {
	    	this.repository = repository;
	    }
	    
		@GetMapping("/users")
		@CrossOrigin(origins = "http://localhost:4200")
		public List<User> retrieveAllUsers() {
			return repository.findAll();
		}
		
		@GetMapping("/users/{id}")
		public String retrieveUserById(@PathVariable long id) {
			return new Gson().toJson(repository.findById(id));
		}
		
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable long id) {
			repository.deleteById(id);
		}
		
		@PostMapping("/users/add")
		public String createUser(@RequestBody String user) {
			repository.save(new Gson().fromJson(user, User.class));
			return "\"message\" : \"User added\"";
		}
		
		@PutMapping("/users/edit")
		public String updateUser(@RequestBody String user) {
			User newUser = new Gson().fromJson(user, User.class);
			User oldUser = repository.findById(newUser.getId()).get();
			oldUser.setFirstName(newUser.getFirstName());
			oldUser.setLastName(newUser.getLastName());
			repository.save(oldUser);
			return "\"message\" : \"User edited\"";
		}
	    
	    
	    @GetMapping("/Some-Users")
	    public Collection<User> Users() {
	        return repository.findAll().stream()
	                .filter(this::isAdam)
	                .collect(Collectors.toList());
	    }

	    private boolean isAdam(User User) {
	        return User.getLastName().equals("Smith");
	    }
}

