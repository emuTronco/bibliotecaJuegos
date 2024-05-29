package es.altia.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.altia.app.entity.User;
import es.altia.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserApiController {
	
	//Con inyeccion de dependencias, podemos usar 'UserService' desde esta clase
	@Autowired
	private UserService userService;
	
	//Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.save(user));
	}
	
	//Read
	@GetMapping("/{id}")
	//public ResponseEntity<?> read(@PathVariable Long id) {
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
		Optional<User> user = userService.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(user);
	}
	
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId) {
		Optional<User> user = userService.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//user.get().setId(userId);
		user.get().setName(userDetails.getName());
		user.get().setSurname(userDetails.getSurname());
		user.get().setEmail(userDetails.getEmail());
		user.get().setEnabled(userDetails.getEnabled());
		
		
		/*Con esta opcion, se copiarian todas las porpiedades, incluido el ID, 
		 * que en este caso no nos interesa
		 */
		//BeanUtils.copyProperties(userDetails, user.get());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.save(user.get()));
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
		if(!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		userService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	//Read all users
	@GetMapping()
	public List<User> readAll() {
		
		List<User> users = StreamSupport
				.stream(userService.findAll().spliterator(), false) //false = secuencial
				.collect(Collectors.toList());
		
		return users;
		
	}
	

}
