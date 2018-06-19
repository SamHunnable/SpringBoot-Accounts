package com.QA.Accounts;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


	
@RestController
class UserController {
	
	    private UserRepository repository;
	    
	    	    public UserController(UserRepository repository) {
	        this.repository = repository;
	    }
	    
		@GetMapping("/users")
		public List<User> retrieveAllUsers() {
			return repository.findAll();
		}
		
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable long id) {
			repository.deleteById(id);
		}
		
		@PostMapping("/users")
		public ResponseEntity<Object> createUser(@RequestBody User User) {
			User savedUser = repository.save(User);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedUser.getId()).toUri();

			return ResponseEntity.created(location).build();

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

